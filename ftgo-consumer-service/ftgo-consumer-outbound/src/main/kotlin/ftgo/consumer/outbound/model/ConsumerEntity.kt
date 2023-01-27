package ftgo.consumer.outbound.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class ConsumerEntity(
    val firstName: String,
    val lastName: String,
    val email: String
) {
    @Id
    @GeneratedValue
    var id: Long? = null
}