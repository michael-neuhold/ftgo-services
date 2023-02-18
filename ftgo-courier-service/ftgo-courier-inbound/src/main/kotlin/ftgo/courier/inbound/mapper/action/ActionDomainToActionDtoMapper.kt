package ftgo.courier.inbound.mapper.action

import ftgo.courier.inbound.api.dto.ActionDto
import ftgo.courier.logic.Action

fun toDto(actions: List<Action>): List<ActionDto> {
    return actions.map { action ->  toDto(action) }
}

fun toDto(action: Action): ActionDto {
    return ActionDto(
        courierId = action.courierId,
        orderId = action.orderId,
        time = action.time,
        type = action.type
    )
}