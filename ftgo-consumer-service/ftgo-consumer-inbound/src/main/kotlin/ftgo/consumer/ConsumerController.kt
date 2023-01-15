package ftgo.consumer

import ftgo.consumer.inbound.ConsumerLogic
import ftgo.consumer.shared.Consumer
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping(
    value = ["/api/consumer"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class ConsumerController(private val consumerLogic: ConsumerLogic) {

    @PostMapping
    fun create(@RequestBody consumer: CreateConsumerRequestDto): ResponseEntity<UUID> {
        val created = consumerLogic.create(Consumer(consumer.firstName, consumer.lastName, consumer.email)).id;
        if (created != null) {
            return ResponseEntity.ok(created)
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Consumer> {
        val consumer = consumerLogic.findById(id);
        if (consumer.isPresent) {
            return ResponseEntity.ok(consumer.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<Consumer>> {
        return ResponseEntity.ok(consumerLogic.getAll());
    }

}