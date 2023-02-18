package ftgo.courier.outbound.mapper.courier

import ftgo.courier.logic.Courier
import ftgo.courier.outbound.model.CourierEntity
import ftgo.courier.outbound.mapper.address.toEntity
import ftgo.courier.outbound.mapper.action.toEntity

fun toEntity(courier: Courier): CourierEntity {
    val courierEntity = CourierEntity(
        courier.firstName,
        courier.lastName,
        courier.available,
        toEntity(courier.address),
        toEntity(courier.actions)
    )
    courierEntity.id = courier.id;
    return courierEntity;
}