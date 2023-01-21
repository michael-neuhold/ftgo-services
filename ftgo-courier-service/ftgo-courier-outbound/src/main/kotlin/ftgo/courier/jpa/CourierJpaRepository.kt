package ftgo.consumer.jpa

import ftgo.consumer.model.CourierEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface CourierJpaRepository: CrudRepository<CourierEntity, UUID> {
}