package ftgo.courier.inbound.mapper.courier

import ftgo.courier.logic.Courier
import ftgo.courier.inbound.api.dto.CourierDto
import ftgo.courier.inbound.mapper.address.toDto
import ftgo.courier.inbound.mapper.action.toDto

fun toDto(courier: Courier): CourierDto {
    return CourierDto(
        courier.id,
        courier.firstName,
        courier.lastName,
        courier.available,
        toDto(courier.address),
        toDto(courier.actions)
    )
}

fun toDto(courierList: List<Courier>): List<CourierDto> {
    return courierList.map { courier -> toDto(courier) }
}