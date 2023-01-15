package ftgo.consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@Import(value = [FtgoConsumerServiceInboundConfig::class])
class FtgoConsumerService

fun main(args: Array<String>) {
    runApplication<FtgoConsumerService>(*args)
}

@RestController
class MyController {

    @GetMapping("/hello")
    fun getMessage(): String {
        return "Hello from Consumer Service";
    }
}