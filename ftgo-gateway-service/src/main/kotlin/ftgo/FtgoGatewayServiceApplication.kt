package ftgo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FtgoGatewayServiceApplication

fun main(args: Array<String>) {
    runApplication<FtgoGatewayServiceApplication>(*args)
}
