package ftgo.courier.shared

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*


@Entity
data class Courier(
    var firstName: String,
    var lastName: String,
    var email: String
) {

    @Id
    @GeneratedValue
    var id: UUID? = null

}
