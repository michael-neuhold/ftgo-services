package ftgo.consumer.shared

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*

@Entity
data class Consumer(
    private val firstName: String,
    private val lastName: String,
    private val email: String
) {
    @Id
    @GeneratedValue
    var id: UUID? = null
}
