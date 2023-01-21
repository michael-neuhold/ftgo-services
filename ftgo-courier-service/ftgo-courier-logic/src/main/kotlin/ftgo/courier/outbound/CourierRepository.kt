package ftgo.courier.outbound

import ftgo.courier.Courier
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.*

@Service
interface CourierRepository {

    fun save(courier: Courier): Courier;

    fun findById(id: UUID): Optional<Courier>;

    fun findAll(): List<Courier>;

}