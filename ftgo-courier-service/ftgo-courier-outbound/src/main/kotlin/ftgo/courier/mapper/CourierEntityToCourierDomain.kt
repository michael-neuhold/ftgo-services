package ftgo.courier.mapper

import ftgo.courier.Courier
import ftgo.courier.model.CourierEntity

class CourierEntityToCourierDomain {

    companion object {

        fun toDomain(courierEntity: CourierEntity): Courier {
            return Courier(courierEntity.id, courierEntity.firstName, courierEntity.lastName, courierEntity.email)
        }

    }
}