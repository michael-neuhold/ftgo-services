package ftgo.courier.logic.inbound

import ftgo.courier.logic.Courier

interface CourierService {

    // fun updateAvailability(id: Long): Result<Boolean>

    fun create(courier: Courier): Result<Courier>

    fun update(courier: Courier): Result<Courier>

    fun findById(id: Long): Result<Courier?>

    fun findAll(): Result<List<Courier>>

}