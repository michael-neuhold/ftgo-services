package ftgo.courier.jpa

import ftgo.courier.model.CourierEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface CourierJpaRepository : CrudRepository<CourierEntity, UUID> {
}