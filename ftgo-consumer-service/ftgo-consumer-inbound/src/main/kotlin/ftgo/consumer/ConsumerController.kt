package ftgo.consumer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ConsumerController(private val consumerLogic: ConsumerLogic) {

    @GetMapping("/consumer")
    fun getMessage(): List<String> {
        return consumerLogic.getAllConsumer();
    }

}