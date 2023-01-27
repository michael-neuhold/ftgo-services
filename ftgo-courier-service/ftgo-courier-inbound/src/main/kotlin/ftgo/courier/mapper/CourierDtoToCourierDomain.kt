package ftgo.consumer.mapper

import ftgo.courier.Courier
import ftgo.courier.CreateCourierRequestDto

fun toDomain(createConsumerRequestDto: CreateCourierRequestDto): Courier {
    return Courier(null, createConsumerRequestDto.firstName, createConsumerRequestDto.lastName, createConsumerRequestDto.email)
}