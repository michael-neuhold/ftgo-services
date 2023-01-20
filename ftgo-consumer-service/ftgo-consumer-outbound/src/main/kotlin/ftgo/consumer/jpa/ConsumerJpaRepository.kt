package ftgo.consumer.jpa

import ftgo.consumer.model.ConsumerEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

interface ConsumerJpaRepository: CrudRepository<ConsumerEntity, UUID> {
}