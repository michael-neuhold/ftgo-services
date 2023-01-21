package ftgo.courier

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FtgoGatewayService

fun main(args: Array<String>) {
    runApplication<FtgoGatewayService>(*args)
}