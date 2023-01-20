package ftgo.consumer.mapper

import ftgo.consumer.Consumer
import ftgo.consumer.CreateConsumerRequestDto

class ConsumerDtoToConsumerDomain {

    companion object {

        fun toDomain(createConsumerRequestDto: CreateConsumerRequestDto): Consumer {
            return Consumer(null, createConsumerRequestDto.firstName, createConsumerRequestDto.lastName, createConsumerRequestDto.email)
        }

    }

}