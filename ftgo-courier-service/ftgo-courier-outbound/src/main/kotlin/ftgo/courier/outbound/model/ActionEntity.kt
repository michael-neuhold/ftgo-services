package ftgo.courier.outbound.model

import ftgo.courier.common.type.ActionType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import java.time.LocalDateTime

@Entity
@IdClass(value = ActionId::class)
data class ActionEntity(
    @Id
    var orderId: Long,

    @Id
    var courierId: Long,

    var time: LocalDateTime,
    var type: ActionType
)
