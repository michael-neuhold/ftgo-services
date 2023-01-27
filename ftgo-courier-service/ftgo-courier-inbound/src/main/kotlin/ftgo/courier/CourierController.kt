package ftgo.courier

import ftgo.consumer.common.constants.INBOUND_LEVEL
import ftgo.consumer.common.constants.withPrefix
import ftgo.consumer.mapper.toDomain
import ftgo.consumer.mapper.toDto
import ftgo.courier.constants.COURIERS_RESOURCE_V1
import ftgo.courier.constants.buildCreatedUriV1
import ftgo.courier.inbound.CourierService
import org.slf4j.Logger
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping(
    value = [COURIERS_RESOURCE_V1],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class CourierController(private val courierService: CourierService, private val logger: Logger) {

    @PostMapping
    fun create(@RequestBody courier: CreateCourierRequestDto): ResponseEntity<UUID> {
        logger.info(withPrefix(INBOUND_LEVEL, "Create Courier {}"), courier)
        val createdCourier = courierService.create(toDomain(courier));
        if (createdCourier.id != null) {
            logger.info(withPrefix(INBOUND_LEVEL,
                "Courier was created. Courier.id = {}"), createdCourier.id)
            return ResponseEntity.created(buildCreatedUriV1(createdCourier.id)).build();
        }
        logger.error(withPrefix(INBOUND_LEVEL, "Courier could not be created"))
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: UUID): ResponseEntity<CourierDto> {
        logger.info(withPrefix(INBOUND_LEVEL, "Get Courier with id = {}"), id)
        val courier = courierService.getById(id);
        if (courier.isPresent) {
            logger.info(withPrefix(INBOUND_LEVEL, "Courier with id = {} found = {}"), id, courier)
            return ResponseEntity.ok(toDto(courier.get()));
        }
        logger.info(withPrefix(INBOUND_LEVEL, "Courier with id = {} could not be found"), id)
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<CourierDto>> {
        logger.info(withPrefix(INBOUND_LEVEL, "Get All Couriers"))
        return ResponseEntity.ok(toDto(courierService.getAll()));
    }

    @GetMapping("{id}/availability")
    fun getAvailability(@PathVariable id: Long): String {
        return "getAvailability";
    }

}