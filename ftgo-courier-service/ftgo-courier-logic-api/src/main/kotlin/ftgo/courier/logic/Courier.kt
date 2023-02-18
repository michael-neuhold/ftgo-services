package ftgo.courier.logic


data class Courier(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    var available: Boolean,
    val address: Address,
    val actions: List<Action>
)
