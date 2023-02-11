package ftgo.consumer.logic.outbound

import ftgo.consumer.logic.Consumer
import org.springframework.stereotype.Repository

@Repository
interface ConsumerRepository {

    fun save(consumer: Consumer): Result<Consumer>

    fun findById(id: Long): Result<Consumer?>

    fun findAll(): Result<List<Consumer>>

}