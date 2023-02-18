package ftgo.consumer

import ftgo.consumer.common.FtgoConsumerServiceCommonConfig
import ftgo.consumer.inbound.FtgoConsumerServiceInboundConfig
import ftgo.consumer.logic.config.FtgoConsumerServiceLogicConfig
import ftgo.consumer.outbound.config.FtgoConsumerServiceOutboundConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@Import(value = [
    FtgoConsumerServiceInboundConfig::class,
    FtgoConsumerServiceLogicConfig::class,
    FtgoConsumerServiceOutboundConfig::class,
    FtgoConsumerServiceCommonConfig::class])
class FtgoConsumerService

fun main(args: Array<String>) {
    runApplication<FtgoConsumerService>(*args)
}
