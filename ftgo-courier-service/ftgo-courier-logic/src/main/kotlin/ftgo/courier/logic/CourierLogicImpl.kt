package ftgo.courier.logic

import ftgo.courier.inbound.CourierLogic
import ftgo.courier.outbound.CourierRepository
import ftgo.courier.shared.Courier
import org.springframework.stereotype.Component
import java.util.*

@Component
class CourierLogicImpl(private val courierRepository: CourierRepository) : CourierLogic {

    override fun updateAvailability(id: Long) {
        TODO("Not yet implemented")
    }

    override fun create(courier: Courier): Courier {
        return courierRepository.save(courier);
    }

    override fun getById(id: Long): Optional<Courier> {
        return courierRepository.findById(id);
    }

    override fun getAll(): List<Courier> {
        return courierRepository.findAll().toList();
    }

}