package ftgo.consumer.outbound.config

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EntityScan(value = ["ftgo.consumer"])
class FtgoConsumerServiceOutboundConfig

