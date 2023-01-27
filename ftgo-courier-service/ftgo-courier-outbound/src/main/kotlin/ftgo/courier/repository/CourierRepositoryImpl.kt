package ftgo.courier.repository

import ftgo.consumer.common.constants.OUTBOUND_LEVEL
import ftgo.consumer.common.constants.withPrefix
import ftgo.courier.Courier
import ftgo.courier.jpa.CourierJpaRepository
import ftgo.courier.mapper.toDomain
import ftgo.courier.mapper.toEntity
import ftgo.courier.outbound.CourierRepository
import org.slf4j.Logger
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CourierRepositoryImpl(private val courierJpaRepository: CourierJpaRepository,
                            private val logger: Logger) : CourierRepository {

    override fun save(courier: Courier): Courier {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Save Courier: {}"), courier)
        return toDomain(courierJpaRepository.save(toEntity(courier)))
    }

    override fun findById(id: UUID): Optional<Courier> {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Find Courier with id: {}"), id)
        return courierJpaRepository.findById(id).map { courier -> toDomain(courier) }
    }

    override fun findAll(): List<Courier> {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Find all couriers"))
        return courierJpaRepository.findAll().map { courier -> toDomain(courier) }
    }
}