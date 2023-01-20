package ftgo.consumer.mapper

import ftgo.consumer.Consumer
import ftgo.consumer.model.ConsumerEntity

class ConsumerDomainToConsumerEntity {

    companion object {

        fun toEntity(consumerDomain: Consumer): ConsumerEntity {
            return ConsumerEntity(consumerDomain.firstName, consumerDomain.lastName, consumerDomain.email);
        }

    }
}