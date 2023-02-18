package ftgo.courier.outbound.mapper.courier

import ftgo.courier.logic.Courier
import ftgo.courier.outbound.mapper.address.toDomain
import ftgo.courier.outbound.mapper.action.toDomain
import ftgo.courier.outbound.model.CourierEntity

fun toDomain(courierEntity: CourierEntity): Courier {
    return Courier(
        courierEntity.id,
        courierEntity.firstName,
        courierEntity.lastName,
        courierEntity.available,
        toDomain(courierEntity.address),
        toDomain(courierEntity.actions)
    )
}