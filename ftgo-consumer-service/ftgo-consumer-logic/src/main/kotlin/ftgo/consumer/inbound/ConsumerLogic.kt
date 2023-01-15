package ftgo.consumer.inbound

import ftgo.consumer.shared.Consumer
import java.util.*

interface ConsumerLogic {

    fun create(consumer: Consumer): Consumer;

    fun findById(id: Long): Optional<Consumer>;

    fun getAll(): List<Consumer>;

}