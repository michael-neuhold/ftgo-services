package ftgo.consumer.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*

@Entity
data class ConsumerEntity(
    val firstName: String,
    val lastName: String,
    val email: String
) {
    @Id
    @GeneratedValue
    var id: UUID? = null
}