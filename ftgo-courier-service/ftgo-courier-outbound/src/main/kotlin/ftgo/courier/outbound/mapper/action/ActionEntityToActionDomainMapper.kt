package ftgo.courier.outbound.mapper.action

import ftgo.courier.logic.Action
import ftgo.courier.outbound.model.ActionEntity

fun toDomain(actionEntity: MutableList<ActionEntity>): List<Action> {
    return actionEntity.map { action ->  toDomain(action)}
}
fun toDomain(actionEntity: ActionEntity): Action {
    return Action(
        courierId = actionEntity.courierId,
        orderId = actionEntity.orderId,
        time = actionEntity.time,
        type = actionEntity.type
    )
}