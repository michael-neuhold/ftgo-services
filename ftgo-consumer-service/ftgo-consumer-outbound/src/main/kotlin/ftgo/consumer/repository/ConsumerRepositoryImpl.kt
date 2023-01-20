package ftgo.consumer.repository

import ftgo.consumer.Consumer
import ftgo.consumer.jpa.ConsumerJpaRepository
import ftgo.consumer.mapper.ConsumerDomainToConsumerEntity
import ftgo.consumer.mapper.ConsumerEntityToConsumerDomain
import ftgo.consumer.outbound.ConsumerRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ConsumerRepositoryImpl(private val consumerJpaRepository: ConsumerJpaRepository): ConsumerRepository {
    override fun save(consumer: Consumer): Consumer {
        return ConsumerEntityToConsumerDomain.toDomain(consumerJpaRepository.save(ConsumerDomainToConsumerEntity.toEntity(consumer)));
    }

    override fun findById(id: UUID): Optional<Consumer> {
        return consumerJpaRepository.findById(id).map { consumer -> ConsumerEntityToConsumerDomain.toDomain(consumer) };
    }

    override fun findAll(): List<Consumer> {
        return consumerJpaRepository.findAll().map { consumer -> ConsumerEntityToConsumerDomain.toDomain(consumer) };
    }

}