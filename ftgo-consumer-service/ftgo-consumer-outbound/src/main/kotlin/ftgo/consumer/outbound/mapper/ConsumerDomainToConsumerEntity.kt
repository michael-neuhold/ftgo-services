package ftgo.consumer.outbound.mapper

import ftgo.consumer.logic.Consumer
import ftgo.consumer.outbound.model.ConsumerEntity

fun toEntity(consumerDomain: Consumer): ConsumerEntity {
    return ConsumerEntity(consumerDomain.firstName, consumerDomain.lastName, consumerDomain.email);
}