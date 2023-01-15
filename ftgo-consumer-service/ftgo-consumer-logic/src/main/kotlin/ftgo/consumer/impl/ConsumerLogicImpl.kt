package ftgo.consumer.impl

import ftgo.consumer.ConsumerLogic
import org.springframework.stereotype.Component

@Component
class ConsumerLogicImpl : ConsumerLogic {
    override fun getAllConsumer(): List<String> {
        return listOf("Michael", "Julian");
    }
}