package ftgo.courier.inbound.mapper.courier

import ftgo.courier.logic.Courier
import ftgo.courier.inbound.api.dto.CourierDto
import ftgo.courier.inbound.mapper.address.toDto

fun toDto(consumer: Courier): CourierDto {
    return CourierDto(consumer.id, consumer.firstName, consumer.lastName, consumer.available, toDto(consumer.address))
}

fun toDto(consumerList: List<Courier>): List<CourierDto> {
    return consumerList.map { consumer -> toDto(consumer) }
}