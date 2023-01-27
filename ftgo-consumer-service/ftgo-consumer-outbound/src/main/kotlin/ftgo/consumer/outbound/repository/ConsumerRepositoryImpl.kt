package ftgo.consumer.outbound.repository

import ftgo.consumer.logic.Consumer
import ftgo.consumer.common.constants.OUTBOUND_LEVEL
import ftgo.consumer.common.constants.withPrefix
import ftgo.consumer.outbound.jpa.ConsumerJpaRepository
import ftgo.consumer.outbound.mapper.toDomain
import ftgo.consumer.outbound.mapper.toEntity
import ftgo.consumer.logic.outbound.ConsumerRepository
import org.slf4j.Logger
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ConsumerRepositoryImpl(private val consumerJpaRepository: ConsumerJpaRepository, private val logger: Logger) :
    ConsumerRepository {

    override fun save(consumer: Consumer): Consumer {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Save Consumer: {}"), consumer)
        return toDomain(consumerJpaRepository.save(toEntity(consumer)));
    }

    override fun findById(id: Long): Optional<Consumer> {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Find Consumer with id: {}"), id)
        return consumerJpaRepository.findById(id)
            .map { consumer -> toDomain(consumer) };
    }

    override fun findAll(): List<Consumer> {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Find all Consumers"))
        return consumerJpaRepository.findAll()
            .map { consumer -> toDomain(consumer) };
    }

}