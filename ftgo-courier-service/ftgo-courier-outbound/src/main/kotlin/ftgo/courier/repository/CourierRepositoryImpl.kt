package ftgo.courier.repository

import ftgo.courier.Courier
import ftgo.courier.jpa.CourierJpaRepository
import ftgo.courier.mapper.CourierDomainToCourierEntity
import ftgo.courier.mapper.CourierEntityToCourierDomain
import ftgo.courier.outbound.CourierRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CourierRepositoryImpl(private val courierJpaRepository: CourierJpaRepository) : CourierRepository {
    override fun save(courier: Courier): Courier {
        return CourierEntityToCourierDomain.toDomain(courierJpaRepository.save(CourierDomainToCourierEntity.toEntity(courier)))
    }

    override fun findById(id: UUID): Optional<Courier> {
        return courierJpaRepository.findById(id).map { courier -> CourierEntityToCourierDomain.toDomain(courier) }
    }

    override fun findAll(): List<Courier> {
        return courierJpaRepository.findAll().map { courier -> CourierEntityToCourierDomain.toDomain(courier) }
    }
}