package ftgo.consumer.outbound.mapper

import ftgo.consumer.logic.Consumer
import ftgo.consumer.outbound.model.ConsumerEntity

fun toDomain(consumerEntity: ConsumerEntity): Consumer {
    return Consumer(consumerEntity.id, consumerEntity.firstName, consumerEntity.lastName, consumerEntity.email)
}