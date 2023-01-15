package ftgo.courier.inbound

import ftgo.courier.shared.Courier
import java.util.*

interface CourierLogic {

    fun updateAvailability(id: Long);

    fun create(courier: Courier): Courier;

    fun getById(id: Long): Optional<Courier>;

    fun getAll(): List<Courier>;

}