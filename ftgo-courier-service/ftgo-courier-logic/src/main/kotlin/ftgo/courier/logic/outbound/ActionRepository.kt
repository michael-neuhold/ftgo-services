package ftgo.courier.logic.outbound

import ftgo.courier.logic.Action

interface ActionRepository {

    fun save(action: Action): Result<Action>

    fun deleteById(courierId: Long, orderId: Long): Result<Unit>

}