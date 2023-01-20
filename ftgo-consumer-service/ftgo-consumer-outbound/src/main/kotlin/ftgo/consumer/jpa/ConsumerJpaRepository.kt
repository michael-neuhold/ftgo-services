package ftgo.consumer.jpa

import ftgo.consumer.model.ConsumerEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ConsumerJpaRepository: CrudRepository<ConsumerEntity, UUID> {
}