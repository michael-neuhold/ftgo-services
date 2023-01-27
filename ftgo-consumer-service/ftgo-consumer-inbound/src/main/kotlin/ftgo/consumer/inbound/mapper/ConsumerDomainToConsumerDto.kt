package ftgo.consumer.inbound.mapper

import ftgo.consumer.logic.Consumer
import ftgo.consumer.inbound.dto.ConsumerDto

fun toDto(consumer: Consumer): ConsumerDto {
    return ConsumerDto(consumer.id, consumer.firstName, consumer.lastName, consumer.email)
}

fun toDto(consumerList: List<Consumer>): List<ConsumerDto> {
    return consumerList.map { consumer -> toDto(consumer) }
}