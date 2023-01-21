package ftgo.courier.outbound

import ftgo.courier.Courier
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CourierRepository {

    fun save(courier: Courier): Courier;

    fun findById(id: UUID): Optional<Courier>;

    fun findAll(): List<Courier>;

}