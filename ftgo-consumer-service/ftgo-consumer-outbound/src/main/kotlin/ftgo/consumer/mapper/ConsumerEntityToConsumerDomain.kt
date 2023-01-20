package ftgo.consumer.mapper

import ftgo.consumer.Consumer
import ftgo.consumer.model.ConsumerEntity

class ConsumerEntityToConsumerDomain {

    companion object {

        fun toDomain(consumerEntity: ConsumerEntity): Consumer {
            return Consumer(consumerEntity.id, consumerEntity.firstName, consumerEntity.lastName, consumerEntity.email)
        }

    }

}