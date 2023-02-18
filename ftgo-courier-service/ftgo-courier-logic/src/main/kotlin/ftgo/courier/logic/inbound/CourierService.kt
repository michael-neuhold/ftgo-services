package ftgo.courier.logic.inbound

import ftgo.courier.logic.Action
import ftgo.courier.logic.Courier

interface CourierService {

    fun create(courier: Courier): Result<Courier>

    fun update(courier: Courier): Result<Courier>

    fun findById(id: Long): Result<Courier?>

    fun findAll(): Result<List<Courier>>

    fun createAction(courierId: Long, action: Action): Result<Courier?>

    fun deleteAction(courierId: Long, orderId: Long): Result<Unit>

}