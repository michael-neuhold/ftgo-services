package ftgo.courier.logic.inbound

import ftgo.courier.logic.Courier
import java.util.*

interface CourierService {

    fun updateAvailability(id: Long): Optional<Boolean>;

    fun create(courier: Courier): Courier;

    fun getById(id: Long): Optional<Courier>;

    fun getAll(): List<Courier>;

}