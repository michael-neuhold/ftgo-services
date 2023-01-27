package ftgo.courier.logic.outbound

import ftgo.courier.logic.Courier
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CourierRepository {

    fun save(courier: Courier): Courier;

    fun findById(id: UUID): Optional<Courier>;

    fun findAll(): List<Courier>;

}