package ftgo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FtgoCourierServiceApplication

fun main(args: Array<String>) {
    runApplication<FtgoCourierServiceApplication>(*args)
}
