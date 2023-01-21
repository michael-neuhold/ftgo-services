package ftgo.ftgo

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean


@SpringBootApplication
@OpenAPIDefinition
class FtgoApiGatewayApplication {

	@Bean
	fun myRoutes(builder: RouteLocatorBuilder): RouteLocator? {
		return builder.routes()
			.route { p: PredicateSpec ->
				p
					.path("/get")
					.filters { f: GatewayFilterSpec ->
						f.addRequestHeader(
							"Hello",
							"World"
						)
					}
					.uri("http://httpbin.org:80")
			}
			.build()
	}

}

fun main(args: Array<String>) {
	runApplication<FtgoApiGatewayApplication>(*args)
}
