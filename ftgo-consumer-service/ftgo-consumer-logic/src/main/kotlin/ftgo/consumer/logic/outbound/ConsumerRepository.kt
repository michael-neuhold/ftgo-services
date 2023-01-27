package ftgo.consumer.logic.outbound

import ftgo.consumer.logic.Consumer
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ConsumerRepository {

    fun save(consumer: Consumer): Consumer;

    fun findById(id: UUID): Optional<Consumer>;

    fun findAll(): List<Consumer>;

}