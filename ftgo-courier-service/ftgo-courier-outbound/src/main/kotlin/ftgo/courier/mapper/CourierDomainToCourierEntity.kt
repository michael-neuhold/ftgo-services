package ftgo.consumer.mapper

import ftgo.consumer.model.CourierEntity
import ftgo.courier.Courier

class CourierDomainToCourierEntity {

    companion object {

        fun toEntity(courierDomain: Courier): CourierEntity {
            return CourierEntity(courierDomain.firstName, courierDomain.lastName, courierDomain.email);
        }

    }
}