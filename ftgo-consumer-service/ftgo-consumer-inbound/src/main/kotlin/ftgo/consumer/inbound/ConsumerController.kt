package ftgo.consumer.inbound

import ftgo.consumer.common.constants.INBOUND_LEVEL
import ftgo.consumer.common.constants.withPrefix
import ftgo.consumer.inbound.constants.CONSUMERS
import ftgo.consumer.inbound.constants.CONSUMERS_RESOURCE_V1
import ftgo.consumer.inbound.constants.ID_PARAM
import ftgo.consumer.inbound.constants.buildCreatedUriV1
import ftgo.consumer.inbound.dto.ConsumerDto
import ftgo.consumer.inbound.dto.CreateConsumerRequestDto
import ftgo.consumer.logic.inbound.ConsumerService
import ftgo.consumer.inbound.mapper.toDomain
import ftgo.consumer.inbound.mapper.toDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
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
@Tag(name = CONSUMERS)
class ConsumerController(private val consumerService: ConsumerService, private val logger: Logger) {

    @PostMapping
    @Operation(description = "Creates new consumer.")
    fun create(@RequestBody consumer: CreateConsumerRequestDto): ResponseEntity<UUID> {
        logger.info(withPrefix(INBOUND_LEVEL, "Create Consumer {}"), consumer)

        return consumerService.create(toDomain(consumer))
            .fold(
                onSuccess = { createdConsumer ->
                    ResponseEntity.created(buildCreatedUriV1(createdConsumer.id)).build()
                },
                onFailure = { ResponseEntity.internalServerError().build() }
            )
    }

    @GetMapping(ID_PARAM)
    @Operation(description = "Returns consumer with given id.")
    fun getById(@PathVariable id: Long): ResponseEntity<ConsumerDto> {
        logger.info(withPrefix(INBOUND_LEVEL, "Get Consumer with id = {}"), id)

        return consumerService.findById(id)
            .fold(
                onSuccess = { consumerOrNull ->
                    consumerOrNull
                        ?.let { consumer -> ResponseEntity.ok(toDto(consumer)) }
                        ?: ResponseEntity.notFound().build()
                },
                onFailure = { ResponseEntity.internalServerError().build() }
            )
    }

    @GetMapping
    @Operation(description = "Returns all consumers.")
    fun getAll(): ResponseEntity<List<ConsumerDto>> {
        logger.info(withPrefix(INBOUND_LEVEL, "Get All Consumers"))

        return consumerService.getAll()
            .fold(
                onSuccess = { consumers -> ResponseEntity.ok(toDto(consumers)) },
                onFailure = { ResponseEntity.internalServerError().build() }
            )
    }

}