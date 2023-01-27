package ftgo.courier.logic.logic

import ftgo.consumer.common.constants.LOGIC_LEVEL
import ftgo.consumer.common.constants.withPrefix
import ftgo.courier.logic.Courier
import ftgo.courier.logic.inbound.CourierService
import ftgo.courier.logic.outbound.CourierRepository
import org.slf4j.Logger
import org.springframework.stereotype.Component
import java.util.*

@Component
class CourierServiceImpl(private val courierRepository: CourierRepository,
                         private val logger: Logger) : CourierService {

    override fun updateAvailability(id: Long) {
        logger.info(withPrefix(LOGIC_LEVEL, "Update Availability of courier id: {}"), id)
        print("not implemented")
    }

    override fun create(courier: Courier): Courier {
        logger.info(withPrefix(LOGIC_LEVEL, "Create Courier: {}"), courier)
        return courierRepository.save(courier)
    }

    override fun getById(id: UUID): Optional<Courier> {
        logger.info(withPrefix(LOGIC_LEVEL, "Find Courier with id: {}"), id)
        return courierRepository.findById(id);
    }

    override fun getAll(): List<Courier> {
        logger.info(withPrefix(LOGIC_LEVEL, "Find all Couriers"))
        return courierRepository.findAll().toList()
    }

}