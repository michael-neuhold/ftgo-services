package ftgo.consumer.logic.inbound

import ftgo.consumer.logic.Consumer
import java.util.*

interface ConsumerService {

    fun create(consumer: Consumer): Consumer;

    fun findById(id: UUID): Optional<Consumer>;

    fun getAll(): List<Consumer>;

}