package ftgo.consumer.mapper

import ftgo.courier.Courier
import ftgo.courier.CreateCourierRequestDto

class CourierDtoToCourierDomain {

    companion object {

        fun toDomain(createConsumerRequestDto: CreateCourierRequestDto): Courier {
            return Courier(null, createConsumerRequestDto.firstName, createConsumerRequestDto.lastName, createConsumerRequestDto.email)
        }

    }

}