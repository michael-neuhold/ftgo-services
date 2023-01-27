package ftgo.consumer.outbound.jpa

import ftgo.consumer.outbound.model.ConsumerEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ConsumerJpaRepository: CrudRepository<ConsumerEntity, UUID> {
}