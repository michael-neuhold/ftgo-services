package ftgo.consumer.common

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InjectionPoint
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EntityScan(value = ["ftgo.consumer"])
class FtgoConsumerServiceCommonConfig


@Configuration
class LoggingConfiguration {
    @Bean
    @Scope("prototype")
    fun logger(injectionPoint: InjectionPoint): Logger {
        return LoggerFactory.getLogger(
            injectionPoint.methodParameter?.containingClass // constructor
                ?:injectionPoint.field?.declaringClass) // or field injection
    }
}
