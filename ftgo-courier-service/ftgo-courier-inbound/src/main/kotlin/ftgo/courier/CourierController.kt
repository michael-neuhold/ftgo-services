package ftgo.courier

import ftgo.courier.inbound.CourierLogic
import ftgo.courier.shared.Courier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class CourierController(private val courierLogic: CourierLogic) {

    @PostMapping
    fun create(@RequestBody courier: CreateCourierRequestDto): ResponseEntity<UUID> {
        val created = courierLogic.create(Courier("", "", "")).id;
        if (created != null) {
            return ResponseEntity.ok(created);
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Courier> {
        val courier = courierLogic.getById(id);
        if (courier.isPresent) {
            return ResponseEntity.ok(courier.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<Courier>> {
        return ResponseEntity.ok(courierLogic.getAll());
    }

    @GetMapping("{id}/availability")
    fun getAvailability(@PathVariable id: Long): String {
        return "getAvailability";
    }

}