package ftgo.courier.inbound

import ftgo.consumer.common.constants.INBOUND_LEVEL
import ftgo.consumer.common.constants.withPrefix
import ftgo.courier.inbound.mapper.courier.toDomain
import ftgo.courier.inbound.mapper.courier.toDto
import ftgo.courier.inbound.api.dto.CourierDto
import ftgo.courier.inbound.api.dto.CreateCourierRequestDto
import ftgo.courier.inbound.api.dto.UpdateCourierRequestDto
import ftgo.courier.inbound.constants.AVAILABILITY_OF_COURIER
import ftgo.courier.inbound.constants.COURIERS_RESOURCE_V1
import ftgo.courier.inbound.constants.ID_PARAM
import ftgo.courier.inbound.constants.buildCreatedUriV1
import ftgo.courier.logic.inbound.CourierService
import io.swagger.v3.oas.annotations.Operation
import org.slf4j.Logger
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(
    value = [COURIERS_RESOURCE_V1],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class CourierController(private val courierService: CourierService, private val logger: Logger) {

    @PostMapping
    @Operation(description = "Creates new courier.")
    fun create(@RequestBody courier: CreateCourierRequestDto): ResponseEntity<Long> {
        logger.info(withPrefix(INBOUND_LEVEL, "Create Courier {}"), courier)

        return courierService.create(toDomain(courier))
            .fold(
                onSuccess = { createdCourier ->
                    ResponseEntity.created(buildCreatedUriV1(createdCourier.id)).build()
                },
                onFailure = { ResponseEntity.internalServerError().build() }
            )
    }

    @GetMapping(ID_PARAM)
    @Operation(description = "Returns courier with given id.")
    fun getById(@PathVariable id: Long): ResponseEntity<CourierDto> {
        logger.info(withPrefix(INBOUND_LEVEL, "Get Courier with id: {}"), id)

        return courierService.findById(id)
            .fold(
                onSuccess = { courierOrNull ->
                    courierOrNull
                        ?.let { courier -> ResponseEntity.ok(toDto(courier)) }
                        ?: ResponseEntity.notFound().build()
                },
                onFailure = { ResponseEntity.internalServerError().build() }
            )
    }

    @GetMapping
    @Operation(description = "Returns all couriers.")
    fun getAll(): ResponseEntity<List<CourierDto>> {
        logger.info(withPrefix(INBOUND_LEVEL, "Get All Couriers"))
        return courierService.findAll()
            .fold(
                onSuccess = { courier -> ResponseEntity.ok(toDto(courier)) },
                onFailure = { ResponseEntity.internalServerError().build() }
            )
    }

    @GetMapping(AVAILABILITY_OF_COURIER)
    @Operation(description = "Get availability of courier with given id.")
    fun getAvailability(@PathVariable id: Long): ResponseEntity<Boolean> {
        logger.info(withPrefix(INBOUND_LEVEL, "Get Availability of courier with id: {}"), id)
        return courierService.findById(id)
            .fold(
                onSuccess = { courierOrNull ->
                    courierOrNull
                        ?.let { courier -> ResponseEntity.ok(courier.available) }
                        ?: ResponseEntity.notFound().build()
                },
                onFailure = { ResponseEntity.internalServerError().build() }
            )
    }

    /*@PatchMapping(AVAILABILITY_OF_COURIER)
    @Operation(description = "Updates availability of courier with given id.")
    fun toggleAvailability(@PathVariable id: Long): ResponseEntity<Boolean> {
        logger.info(withPrefix(INBOUND_LEVEL, "Update Availability of courier with id: {}"), id)
        val newCourierAvailability = courierService.updateAvailability(id);
        if (newCourierAvailability.isPresent) {
            logger.info(
                withPrefix(INBOUND_LEVEL, "Courier with id: {} found. availability: {}"),
                id,
                newCourierAvailability.get()
            )
            return ResponseEntity.ok(newCourierAvailability.get());
        }
        logger.info(withPrefix(INBOUND_LEVEL, "Courier with id: {} could not be found"), id)
        return ResponseEntity.notFound().build();
    }*/

    @PatchMapping(ID_PARAM)
    @Operation(description = "Updates courier with given id.")
    fun update(@PathVariable id: Long, @RequestBody courierDto: UpdateCourierRequestDto): ResponseEntity<CourierDto> {
        logger.info(withPrefix(INBOUND_LEVEL, "Update courier with id: {}"), id)

        return courierService.update(toDomain(courierDto))
            .fold(
                onSuccess = { updatedCourier ->
                    ResponseEntity.ok(toDto(updatedCourier))
                },
                onFailure = { ResponseEntity.internalServerError().build() }
            )
    }

}