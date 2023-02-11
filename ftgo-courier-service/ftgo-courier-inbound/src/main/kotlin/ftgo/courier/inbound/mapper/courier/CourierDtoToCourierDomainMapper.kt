package ftgo.courier.inbound.mapper.courier

import ftgo.courier.logic.Courier
import ftgo.courier.inbound.api.dto.CreateCourierRequestDto
import ftgo.courier.inbound.api.dto.UpdateCourierRequestDto
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

fun toDomain(updateCourierRequestDto: UpdateCourierRequestDto): Courier {
    return Courier(
        updateCourierRequestDto.id,
        updateCourierRequestDto.firstName,
        updateCourierRequestDto.lastName,
        updateCourierRequestDto.available,
        toDomain(updateCourierRequestDto.address)
    )
}