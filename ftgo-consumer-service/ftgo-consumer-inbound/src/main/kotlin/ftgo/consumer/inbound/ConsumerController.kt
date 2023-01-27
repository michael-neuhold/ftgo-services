package ftgo.consumer.inbound

import ftgo.consumer.common.constants.INBOUND_LEVEL
import ftgo.consumer.common.constants.withPrefix
import ftgo.consumer.inbound.constants.CONSUMERS_RESOURCE_V1
import ftgo.consumer.inbound.constants.ID_PARAM
import ftgo.consumer.inbound.constants.buildCreatedUriV1
import ftgo.consumer.inbound.dto.ConsumerDto
import ftgo.consumer.inbound.dto.CreateConsumerRequestDto
import ftgo.consumer.logic.inbound.ConsumerService
import ftgo.consumer.inbound.mapper.toDomain
import ftgo.consumer.inbound.mapper.toDto
import org.slf4j.Logger
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping(
    value = [CONSUMERS_RESOURCE_V1],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class ConsumerController(private val consumerService: ConsumerService, private val logger: Logger) {

    @PostMapping
    fun create(@RequestBody consumer: CreateConsumerRequestDto): ResponseEntity<UUID> {
        logger.info(withPrefix(INBOUND_LEVEL, "Create Consumer {}"), consumer)
        val createdConsumer = consumerService.create(toDomain(consumer))
        if (createdConsumer.id != null) {
            logger.info(withPrefix(INBOUND_LEVEL,
                "Consumer was created. Consumer.id = {}"), createdConsumer.id)
            return ResponseEntity.created(buildCreatedUriV1(createdConsumer.id)).build()
        }
        logger.error(withPrefix(INBOUND_LEVEL, "Consumer could not be created"))
        return ResponseEntity.internalServerError().build()
    }

    @GetMapping(ID_PARAM)
    fun getById(@PathVariable id: UUID): ResponseEntity<ConsumerDto> {
        logger.info(withPrefix(INBOUND_LEVEL, "Get Consumer with id = {}"), id)
        val consumer = consumerService.findById(id)
        if (consumer.isPresent) {
            logger.info(withPrefix(INBOUND_LEVEL, "Consumer with id = {} found = {}"), id, consumer)
            return ResponseEntity.ok(toDto(consumer.get()))
        }
        logger.info(withPrefix(INBOUND_LEVEL, "Consumer with id = {} could not be found"), id)
        return ResponseEntity.notFound().build()
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<ConsumerDto>> {
        logger.info(withPrefix(INBOUND_LEVEL, "Get All Consumers"))
        return ResponseEntity.ok(toDto(consumerService.getAll()))
    }

}