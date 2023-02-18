package ftgo.courier.outbound.mapper.action

import ftgo.courier.logic.Action
import ftgo.courier.outbound.model.ActionEntity

fun toEntity(action: List<Action>): MutableList<ActionEntity> {
    return action.map { a ->  toEntity(a) }.toMutableList()
}
fun toEntity(action: Action): ActionEntity {
    return ActionEntity(
        courierId = action.courierId,
        orderId = action.orderId,
        time = action.time,
        type = action.type
    )
}