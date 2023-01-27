package ftgo.courier

import ftgo.courier.common.FtgoCourierServiceCommonConfig
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EntityScan
@Import(value = [FtgoCourierServiceCommonConfig::class])
class FtgoCourierServiceInboundConfig

