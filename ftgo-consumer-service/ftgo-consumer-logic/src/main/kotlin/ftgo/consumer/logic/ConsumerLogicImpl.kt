package ftgo.consumer.logic

import ftgo.consumer.inbound.ConsumerLogic
import ftgo.consumer.outbound.ConsumerRepository
import ftgo.consumer.shared.Consumer
import org.springframework.stereotype.Component
import java.util.*

@Component
class ConsumerLogicImpl(private val consumerRepository: ConsumerRepository) : ConsumerLogic {
    override fun create(consumer: Consumer): Consumer {
        return consumerRepository.save(consumer);
    }

    override fun findById(id: Long): Optional<Consumer> {
        return consumerRepository.findById(id);
    }

    override fun getAll(): List<Consumer> {
        return consumerRepository.findAll().toList();
    }

}