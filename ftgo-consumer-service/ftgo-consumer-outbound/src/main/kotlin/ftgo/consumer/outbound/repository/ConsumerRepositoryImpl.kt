package ftgo.consumer.outbound.repository

import ftgo.consumer.logic.Consumer
import ftgo.consumer.common.constants.OUTBOUND_LEVEL
import ftgo.consumer.common.constants.withPrefix
import ftgo.consumer.outbound.jpa.ConsumerJpaRepository
import ftgo.consumer.outbound.mapper.toDomain
import ftgo.consumer.outbound.mapper.toEntity
import ftgo.consumer.logic.outbound.ConsumerRepository
import org.slf4j.Logger
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ConsumerRepositoryImpl(private val consumerJpaRepository: ConsumerJpaRepository, private val logger: Logger) :
    ConsumerRepository {

    override fun save(consumer: Consumer): Result<Consumer> {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Save Consumer: {}"), consumer)

        if (consumer.id != null) {
            return Result.failure(Exception("Id was set when creating entity."))
        }

        return Result.runCatching { consumerJpaRepository.save(toEntity(consumer)) }
            .fold(
                onSuccess = { createdConsumer -> Result.success(toDomain(createdConsumer)) },
                onFailure = { Result.failure(Exception("Persistence error")) }
            )
    }

    override fun findById(id: Long): Result<Consumer?> {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Find Consumer with id: {}"), id)
        return Result.success(consumerJpaRepository.findByIdOrNull(id)
            ?.let { consumer -> toDomain(consumer) })
    }

    override fun findAll(): Result<List<Consumer>> {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Find all Consumers"))
        return Result.success(consumerJpaRepository.findAll()
            .map { consumer -> toDomain(consumer) })
    }

}