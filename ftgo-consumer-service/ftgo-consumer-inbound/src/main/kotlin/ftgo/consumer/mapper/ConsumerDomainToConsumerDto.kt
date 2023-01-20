package ftgo.consumer.mapper

import ftgo.consumer.Consumer
import ftgo.consumer.ConsumerDto

class ConsumerDomainToConsumerDto {

    companion object {

        fun toDto(consumer: Consumer): ConsumerDto {
            return ConsumerDto(consumer.id, consumer.firstName, consumer.lastName, consumer.email)
        }

        fun toDto(consumerList: List<Consumer>): List<ConsumerDto> {
            return consumerList.map { consumer -> toDto(consumer) }
        }

    }

}