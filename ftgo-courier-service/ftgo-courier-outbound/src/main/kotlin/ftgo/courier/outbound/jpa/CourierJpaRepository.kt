package ftgo.courier.outbound.jpa

import ftgo.courier.outbound.model.CourierEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface CourierJpaRepository : CrudRepository<CourierEntity, Long> {
}