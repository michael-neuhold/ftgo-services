package ftgo.consumer.outbound

import ftgo.consumer.Consumer
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ConsumerRepository {

    fun save(consumer: Consumer): Consumer;

    fun findById(id: UUID): Optional<Consumer>;

    fun findAll(): List<Consumer>;

}