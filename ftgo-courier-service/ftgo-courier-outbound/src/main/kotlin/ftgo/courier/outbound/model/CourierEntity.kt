package ftgo.courier.outbound.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*

@Entity
data class CourierEntity(
    val firstName: String,
    val lastName: String,
    val email: String
) {
    @Id
    @GeneratedValue
    var id: UUID? = null
}
