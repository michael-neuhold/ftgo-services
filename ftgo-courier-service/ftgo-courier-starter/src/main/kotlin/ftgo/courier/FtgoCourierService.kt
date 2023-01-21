package ftgo.courier

import ftgo.consumer.config.FtgoCourierServiceOutboundConfig
import ftgo.courier.FtgoCourierServiceInboundConfig
import ftgo.courier.config.FtgoCourierServiceLogicConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@Import(value = [FtgoCourierServiceInboundConfig::class, FtgoCourierServiceOutboundConfig::class, FtgoCourierServiceLogicConfig::class])
class FtgoCourierService

fun main(args: Array<String>) {
    runApplication<FtgoCourierService>(*args)
}

@RestController
class MyController {

    @GetMapping("/hello")
    fun getMessage(): String {
        return "Hello from Courier Service";
    }

}