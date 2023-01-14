package ftgo.consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(value = [FtgoConsumerServiceInboundConfig::class])
class FtgoConsumerService

fun main(args: Array<String>) {
    runApplication<FtgoConsumerService>(*args)
}
