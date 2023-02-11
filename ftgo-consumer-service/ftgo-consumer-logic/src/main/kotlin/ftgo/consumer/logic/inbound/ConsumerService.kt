package ftgo.consumer.logic.inbound

import ftgo.consumer.logic.Consumer
import java.util.*

interface ConsumerService {

    fun create(consumer: Consumer): Result<Consumer>

    fun findById(id: Long): Result<Consumer?>

    fun getAll(): Result<List<Consumer>>

}