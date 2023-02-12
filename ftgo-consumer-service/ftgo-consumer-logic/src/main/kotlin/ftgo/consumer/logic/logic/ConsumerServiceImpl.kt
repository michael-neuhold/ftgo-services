package ftgo.consumer.logic.logic

import ftgo.consumer.logic.Consumer
import ftgo.consumer.common.constants.LOGIC_LEVEL
import ftgo.consumer.common.constants.withPrefix
import ftgo.consumer.logic.inbound.ConsumerService
import ftgo.consumer.logic.outbound.ConsumerRepository
import org.slf4j.Logger
import org.springframework.stereotype.Component
import java.util.*

@Component
class ConsumerServiceImpl(private val consumerRepository: ConsumerRepository, private val logger: Logger) :
    ConsumerService {
    override fun create(consumer: Consumer): Result<Consumer> {
        logger.info(withPrefix(LOGIC_LEVEL, "Create Consumer: {}"), consumer)
        return consumerRepository.save(consumer)
    }

    override fun findById(id: Long): Result<Consumer?> {
        logger.info(withPrefix(LOGIC_LEVEL, "Find Consumer with id: {}"), id)
        return consumerRepository.findById(id)
    }

    override fun getAll(): Result<List<Consumer>> {
        logger.info(withPrefix(LOGIC_LEVEL, "Find all Consumers"))
        return consumerRepository.findAll()
    }

}