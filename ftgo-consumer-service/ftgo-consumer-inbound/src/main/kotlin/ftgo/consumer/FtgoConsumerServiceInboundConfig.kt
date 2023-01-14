package ftgo.consumer

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration

@EntityScan
@Configuration
@EnableAutoConfiguration
class FtgoConsumerServiceInboundConfig

