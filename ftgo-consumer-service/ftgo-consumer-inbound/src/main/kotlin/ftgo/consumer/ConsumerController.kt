package ftgo.consumer

import ftgo.consumer.inbound.ConsumerService
import ftgo.consumer.mapper.ConsumerDomainToConsumerDto
import ftgo.consumer.mapper.ConsumerDtoToConsumerDomain
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping(
    value = ["/api/consumer"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class ConsumerController(private val consumerService: ConsumerService) {

    @PostMapping
    fun create(@RequestBody consumer: CreateConsumerRequestDto): ResponseEntity<UUID> {
        val created = consumerService.create(ConsumerDtoToConsumerDomain.toDomain(consumer)).id;
        if (created != null) {
            return ResponseEntity.ok(created)
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: UUID): ResponseEntity<ConsumerDto> {
        val consumer = consumerService.findById(id);
        if (consumer.isPresent) {
            return ResponseEntity.ok(ConsumerDomainToConsumerDto.toDto(consumer.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<ConsumerDto>> {
        return ResponseEntity.ok(ConsumerDomainToConsumerDto.toDto(consumerService.getAll()))
    }

}