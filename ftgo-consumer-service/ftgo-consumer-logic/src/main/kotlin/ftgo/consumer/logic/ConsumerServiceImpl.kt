package ftgo.consumer.logic

import ftgo.consumer.Consumer
import ftgo.consumer.inbound.ConsumerService
import ftgo.consumer.outbound.ConsumerRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class ConsumerServiceImpl(private val consumerRepository: ConsumerRepository) : ConsumerService {
    override fun create(consumer: Consumer): Consumer {
        return consumerRepository.save(consumer);
    }

    override fun findById(id: UUID): Optional<Consumer> {
        return consumerRepository.findById(id);
    }

    override fun getAll(): List<Consumer> {
        return consumerRepository.findAll().toList();
    }

}