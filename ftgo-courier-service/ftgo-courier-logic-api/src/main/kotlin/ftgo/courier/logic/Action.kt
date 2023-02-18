package ftgo.courier.logic

import ftgo.courier.common.type.ActionType
import java.time.LocalDateTime

data class Action(
    val orderId: Long,
    val courierId: Long,
    val time: LocalDateTime,
    val type: ActionType
)
