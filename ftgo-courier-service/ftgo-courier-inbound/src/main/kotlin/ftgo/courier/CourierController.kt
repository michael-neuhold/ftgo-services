package ftgo.courier

import ftgo.consumer.mapper.CourierDomainToCourierDto
import ftgo.consumer.mapper.CourierDtoToCourierDomain
import ftgo.courier.constants.COURIERS_RESOURCE_V2
import ftgo.courier.inbound.CourierService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping(
    value = [COURIERS_RESOURCE_V2],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class CourierController(private val courierService: CourierService) {

    @PostMapping
    fun create(@RequestBody courier: CreateCourierRequestDto): ResponseEntity<UUID> {
        val created = courierService.create(CourierDtoToCourierDomain.toDomain(courier)).id;
        if (created != null) {
            return ResponseEntity.ok(created);
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: UUID): ResponseEntity<CourierDto> {
        val courier = courierService.getById(id);
        if (courier.isPresent) {
            return ResponseEntity.ok(CourierDomainToCourierDto.toDto(courier.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<CourierDto>> {
        return ResponseEntity.ok(CourierDomainToCourierDto.toDto(courierService.getAll()));
    }

    @GetMapping("{id}/availability")
    fun getAvailability(@PathVariable id: Long): String {
        return "getAvailability";
    }

}