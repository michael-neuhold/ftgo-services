package ftgo.consumer.outbound

import ftgo.consumer.shared.Consumer
import org.springframework.data.repository.CrudRepository

interface ConsumerRepository : CrudRepository<Consumer, Long> {
}