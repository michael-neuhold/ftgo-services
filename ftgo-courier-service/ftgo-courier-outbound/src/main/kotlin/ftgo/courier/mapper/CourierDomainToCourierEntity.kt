package ftgo.courier.mapper

import ftgo.courier.Courier
import ftgo.courier.model.CourierEntity

class CourierDomainToCourierEntity {

    companion object {

        fun toEntity(courier: Courier): CourierEntity {
            return CourierEntity(courier.firstName, courier.lastName, courier.email)
        }

    }

}