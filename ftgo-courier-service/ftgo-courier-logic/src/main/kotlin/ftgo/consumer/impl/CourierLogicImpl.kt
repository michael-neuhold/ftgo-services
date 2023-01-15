package ftgo.consumer.impl

import ftgo.consumer.CourierLogic
import org.springframework.stereotype.Component

@Component
class CourierLogicImpl : CourierLogic {
    override fun getAllCouriers(): List<String> {
        return listOf("Michael", "Julian");
    }

}