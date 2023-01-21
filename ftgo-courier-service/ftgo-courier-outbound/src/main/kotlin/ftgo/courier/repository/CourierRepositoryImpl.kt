package ftgo.consumer.repository

import ftgo.consumer.jpa.CourierJpaRepository
import ftgo.consumer.mapper.CourierDomainToCourierEntity
import ftgo.consumer.mapper.CourierEntityToCourierDomain
import ftgo.courier.Courier
import ftgo.courier.outbound.CourierRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CourierRepositoryImpl(private val courierJpaRepository: CourierJpaRepository): CourierRepository {
    override fun save(courier: Courier): Courier {
        return CourierEntityToCourierDomain.toDomain(courierJpaRepository.save(CourierDomainToCourierEntity.toEntity(courier)));
    }

    override fun findById(id: UUID): Optional<Courier> {
        return courierJpaRepository.findById(id).map { consumer -> CourierEntityToCourierDomain.toDomain(consumer) };
    }

    override fun findAll(): List<Courier> {
        return courierJpaRepository.findAll().map { consumer -> CourierEntityToCourierDomain.toDomain(consumer) };
    }

}