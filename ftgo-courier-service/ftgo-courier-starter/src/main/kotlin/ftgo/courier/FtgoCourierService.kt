package ftgo.courier

import ftgo.courier.FtgoCourierServiceInboundConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@Import(value = [FtgoCourierServiceInboundConfig::class])
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