package ftgo.courier.inbound

import ftgo.courier.Courier
import java.util.*

interface CourierService {

    fun updateAvailability(id: Long);

    fun create(courier: Courier): Courier;

    fun getById(id: UUID): Optional<Courier>;

    fun getAll(): List<Courier>;

}