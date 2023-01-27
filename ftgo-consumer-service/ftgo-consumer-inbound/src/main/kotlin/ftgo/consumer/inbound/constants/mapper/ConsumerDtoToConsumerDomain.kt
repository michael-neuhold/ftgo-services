package ftgo.consumer.inbound.constants.mapper

import ftgo.consumer.logic.Consumer
import ftgo.consumer.inbound.dto.CreateConsumerRequestDto

fun toDomain(createConsumerRequestDto: CreateConsumerRequestDto): Consumer {
    return Consumer(null, createConsumerRequestDto.firstName, createConsumerRequestDto.lastName, createConsumerRequestDto.email)
}