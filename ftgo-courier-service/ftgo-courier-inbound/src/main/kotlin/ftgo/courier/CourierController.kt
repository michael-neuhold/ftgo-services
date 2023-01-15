package ftgo.courier

import ftgo.courier.inbound.CourierLogic
import ftgo.courier.shared.Courier
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping(
    value = ["/api/courier"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class CourierController(private val courierLogic: CourierLogic) {

    @PostMapping
    fun create(@RequestBody courier: CreateCourierRequestDto): ResponseEntity<UUID> {
        val created = courierLogic.create(Courier(courier.firstName, courier.lastName, courier.email)).id;
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