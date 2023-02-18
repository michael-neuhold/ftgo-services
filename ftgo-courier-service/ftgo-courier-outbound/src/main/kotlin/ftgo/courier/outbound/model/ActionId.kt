package ftgo.courier.outbound.model

import java.io.Serializable

class ActionId(
    val orderId: Long = 0,
    val courierId: Long = 0
): Serializable
