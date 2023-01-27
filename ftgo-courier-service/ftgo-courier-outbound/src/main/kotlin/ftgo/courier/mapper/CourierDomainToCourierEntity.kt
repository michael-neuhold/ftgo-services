package ftgo.courier.mapper

import ftgo.courier.Courier
import ftgo.courier.model.CourierEntity

fun toEntity(courier: Courier): CourierEntity {
    return CourierEntity(courier.firstName, courier.lastName, courier.email)
}