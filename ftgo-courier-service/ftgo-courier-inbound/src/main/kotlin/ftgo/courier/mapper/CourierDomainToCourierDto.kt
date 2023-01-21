package ftgo.consumer.mapper

import ftgo.courier.Courier
import ftgo.courier.CourierDto

class CourierDomainToCourierDto {

    companion object {

        fun toDto(consumer: Courier): CourierDto {
            return CourierDto(consumer.id, consumer.firstName, consumer.lastName, consumer.email)
        }

        fun toDto(consumerList: List<Courier>): List<CourierDto> {
            return consumerList.map { consumer -> toDto(consumer) }
        }

    }

}