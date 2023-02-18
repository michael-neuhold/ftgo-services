package ftgo.courier.inbound.mapper.action

import ftgo.courier.inbound.api.dto.ActionDto
import ftgo.courier.logic.Action

fun toDomain(actions: List<ActionDto>): List<Action> {
    return actions.map { action ->  toDomain(action) }
}

fun toDomain(actionDto: ActionDto): Action {
    return Action(
        courierId = actionDto.courierId,
        orderId = actionDto.orderId,
        time = actionDto.time,
        type = actionDto.type
    )
}