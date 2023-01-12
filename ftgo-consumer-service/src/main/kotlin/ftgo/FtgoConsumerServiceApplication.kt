package ftgo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FtgoConsumerServiceApplication

fun main(args: Array<String>) {
    runApplication<FtgoConsumerServiceApplication>(*args)
}
