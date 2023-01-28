package ftgo.courier.inbound.mapper.courier

import ftgo.courier.logic.Courier
import ftgo.courier.inbound.api.dto.CreateCourierRequestDto
import ftgo.courier.inbound.mapper.address.toDomain

fun toDomain(createConsumerRequestDto: CreateCourierRequestDto): Courier {
    return Courier(
        null,
        createConsumerRequestDto.firstName,
        createConsumerRequestDto.lastName,
        createConsumerRequestDto.available,
        toDomain(createConsumerRequestDto.address)
    )
}