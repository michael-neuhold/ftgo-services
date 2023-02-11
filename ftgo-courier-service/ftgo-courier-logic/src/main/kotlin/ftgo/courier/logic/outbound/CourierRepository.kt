package ftgo.courier.logic.outbound

import ftgo.courier.logic.Courier
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CourierRepository {

    fun save(courier: Courier): Result<Courier>;

    fun findById(id: Long): Result<Courier?>;

    fun findAll(): Result<List<Courier>>;

    fun update(courier: Courier): Result<Courier>;

}