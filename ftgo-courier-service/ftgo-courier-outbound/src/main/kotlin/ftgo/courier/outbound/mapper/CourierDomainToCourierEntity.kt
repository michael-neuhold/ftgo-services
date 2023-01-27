package ftgo.courier.outbound.mapper

import ftgo.courier.logic.Courier
import ftgo.courier.outbound.model.CourierEntity

fun toEntity(courier: Courier): CourierEntity {
    return CourierEntity(courier.firstName, courier.lastName, courier.email)
}