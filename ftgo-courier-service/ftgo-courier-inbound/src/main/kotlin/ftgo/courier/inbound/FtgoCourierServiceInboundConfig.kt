package ftgo.courier.inbound

import ftgo.courier.common.FtgoCourierServiceCommonConfig
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@EnableAutoConfiguration
@ComponentScan(value = ["ftgo.courier.inbound", "ftgo.courier.logic"])
@EntityScan
@Import(value = [FtgoCourierServiceCommonConfig::class])
class FtgoCourierServiceInboundConfig

