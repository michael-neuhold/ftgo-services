package ftgo.courier.logic

import ftgo.courier.Courier
import ftgo.courier.inbound.CourierService
import ftgo.courier.outbound.CourierRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class CourierServiceImpl(private val courierRepository: CourierRepository) : CourierService {

    override fun updateAvailability(id: Long) {
       print("not implemented")
    }

    override fun create(courier: Courier): Courier {
        return courierRepository.save(courier)
    }

    override fun getById(id: UUID): Optional<Courier> {
       return courierRepository.findById(id);
    }

    override fun getAll(): List<Courier> {
        return courierRepository.findAll().toList()
    }

}