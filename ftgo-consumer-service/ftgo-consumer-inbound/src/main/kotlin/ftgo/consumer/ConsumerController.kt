package ftgo.consumer

import ftgo.consumer.inbound.ConsumerLogic
import ftgo.consumer.shared.Consumer
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class ConsumerController(private val consumerLogic: ConsumerLogic) {

    @PostMapping
    fun create(@RequestBody consumer: CreateConsumerRequestDto): ResponseEntity<UUID> {
        val created = consumerLogic.create(Consumer("", "", "")).id;
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