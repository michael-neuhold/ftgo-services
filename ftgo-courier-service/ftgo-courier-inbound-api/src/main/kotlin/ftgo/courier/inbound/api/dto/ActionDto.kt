package ftgo.courier.inbound.api.dto

import ftgo.courier.common.type.ActionType
import java.time.LocalDateTime

data class ActionDto(
    val orderId: Long,
    val courierId: Long,
    val time: LocalDateTime,
    val type: ActionType
)