package ftgo.courier.logic.logic

import ftgo.consumer.common.constants.LOGIC_LEVEL
import ftgo.consumer.common.constants.withPrefix
import ftgo.courier.logic.Action
import ftgo.courier.logic.Courier
import ftgo.courier.logic.inbound.CourierService
import ftgo.courier.logic.outbound.ActionRepository
import ftgo.courier.logic.outbound.CourierRepository
import org.slf4j.Logger
import org.springframework.stereotype.Component
import java.util.*

@Component
class CourierServiceImpl(
    private val courierRepository: CourierRepository,
    private val actionRepository: ActionRepository,
    private val logger: Logger
) : CourierService {

    /*
    override fun updateAvailability(id: Long): Result<Boolean> {
        logger.info(withPrefix(LOGIC_LEVEL, "Update Availability of courier id: {}"), id)
        val courierToUpdate = getById(id);
        if (courierToUpdate.isPresent) {
            courierToUpdate.get().available = !courierToUpdate.get().available
            return Optional.of(courierRepository.update(courierToUpdate.get()).available)
        }
       return Optional.empty();
    }*/

    override fun create(courier: Courier): Result<Courier> {
        logger.info(withPrefix(LOGIC_LEVEL, "Create Courier: {}"), courier)
        return courierRepository.save(courier)
    }

    override fun update(courier: Courier): Result<Courier> {
        logger.info(withPrefix(LOGIC_LEVEL, "Update Courier: {}"), courier)
        return courierRepository.update(courier)
    }

    override fun findById(id: Long): Result<Courier?> {
        logger.info(withPrefix(LOGIC_LEVEL, "Find Courier with id: {}"), id)
        return courierRepository.findById(id);
    }

    override fun findAll(): Result<List<Courier>> {
        logger.info(withPrefix(LOGIC_LEVEL, "Find all Couriers"))
        return courierRepository.findAll()
    }

    override fun createAction(courierId: Long, action: Action): Result<Courier?> {
        logger.info(withPrefix(LOGIC_LEVEL, "Create action for courier with id: {}"), courierId)
        return actionRepository.save(action)
            .fold(
                onSuccess = { a -> findById(a.courierId)},
                onFailure = { Result.failure(Exception()) }
            )
    }

    override fun deleteAction(courierId: Long, orderId: Long): Result<Unit> {
        logger.info(withPrefix(LOGIC_LEVEL, "Remove action for courier with id: {}"), courierId)
        return actionRepository.deleteById(courierId, orderId)
    }

}