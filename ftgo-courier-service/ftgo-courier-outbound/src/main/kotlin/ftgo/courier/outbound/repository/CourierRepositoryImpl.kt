package ftgo.courier.outbound.repository

import ftgo.consumer.common.constants.OUTBOUND_LEVEL
import ftgo.consumer.common.constants.withPrefix
import ftgo.courier.logic.Courier
import ftgo.courier.outbound.jpa.CourierJpaRepository
import ftgo.courier.outbound.mapper.courier.toDomain
import ftgo.courier.outbound.mapper.courier.toEntity
import ftgo.courier.logic.outbound.CourierRepository
import org.slf4j.Logger
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CourierRepositoryImpl(
    private val courierJpaRepository: CourierJpaRepository,
    private val logger: Logger
) : CourierRepository {

    override fun save(courier: Courier): Result<Courier> {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Save Courier: {}"), courier)
        return Result.runCatching { courierJpaRepository.save(toEntity(courier)) }
            .fold(
                onSuccess = { createdCourier -> Result.success(toDomain(createdCourier)) },
                onFailure = { Result.failure(Exception("Persistence error")) }
            )
    }

    override fun findById(id: Long): Result<Courier?> {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Find Courier with id: {}"), id)
        return Result.success(courierJpaRepository.findByIdOrNull(id)?.let { courier -> toDomain(courier) })
    }

    override fun findAll(): Result<List<Courier>> {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Find all couriers"))
        return Result.success(courierJpaRepository.findAll().map { courier -> toDomain(courier) })
    }

    override fun update(courier: Courier): Result<Courier> {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Update courier: {}"), courier)

        if (courier.id == null) {
            return Result.failure(Exception("Id is not set when updating entity."))
        }

        return Result.runCatching { courierJpaRepository.save(toEntity(courier)) }
            .fold(
                onSuccess = { updatedCourier -> Result.success(toDomain(updatedCourier)) },
                onFailure = { Result.failure(Exception("Persistence error")) }
            )
    }

}