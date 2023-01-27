package ftgo.consumer.mapper

import ftgo.courier.logic.Courier
import ftgo.courier.inbound.api.dto.CreateCourierRequestDto

fun toDomain(createConsumerRequestDto: CreateCourierRequestDto): Courier {
    return Courier(null, createConsumerRequestDto.firstName, createConsumerRequestDto.lastName, createConsumerRequestDto.email)
}