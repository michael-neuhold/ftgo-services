package ftgo.courier.outbound.repository

import ftgo.consumer.common.constants.OUTBOUND_LEVEL
import ftgo.consumer.common.constants.withPrefix
import ftgo.courier.logic.Action
import ftgo.courier.logic.Courier
import ftgo.courier.logic.outbound.ActionRepository
import ftgo.courier.outbound.jpa.ActionJpaRepository
import ftgo.courier.outbound.mapper.action.toEntity
import ftgo.courier.outbound.mapper.action.toDomain
import ftgo.courier.outbound.model.ActionId
import org.slf4j.Logger
import org.springframework.stereotype.Repository

@Repository
class ActionRepositoryImpl(
    private val actionJpaRepository: ActionJpaRepository,
    private val logger: Logger
) : ActionRepository {
    override fun save(action: Action): Result<Action> {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Save Action"))
        return Result.runCatching { actionJpaRepository.save(toEntity(action)) }
            .fold(
                onSuccess = { createdAction -> Result.success(toDomain(createdAction)) },
                onFailure = { Result.failure(Exception("Persistence error")) }
            )
    }

    override fun deleteById(courierId: Long, orderId: Long): Result<Unit> {
        logger.info(withPrefix(OUTBOUND_LEVEL, "Remove Action"))
        return Result.runCatching { actionJpaRepository.deleteById(ActionId(orderId, courierId)) }
            .fold(
                onSuccess = { Result.success(Unit) },
                onFailure = { Result.failure(Exception("Persistence error")) }
            )
    }
}