package ftgo.courier.outbound.mapper

import ftgo.courier.logic.Courier
import ftgo.courier.outbound.model.CourierEntity

fun toDomain(courierEntity: CourierEntity): Courier {
    return Courier(courierEntity.id, courierEntity.firstName, courierEntity.lastName, courierEntity.email)
}