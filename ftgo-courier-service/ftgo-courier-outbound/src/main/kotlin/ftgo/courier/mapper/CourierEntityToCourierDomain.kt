package ftgo.consumer.mapper

import ftgo.consumer.model.CourierEntity
import ftgo.courier.Courier

class CourierEntityToCourierDomain {

    companion object {

        fun toDomain(courierEntity: CourierEntity): Courier {
            return Courier(courierEntity.id, courierEntity.firstName, courierEntity.lastName, courierEntity.email)
        }

    }

}