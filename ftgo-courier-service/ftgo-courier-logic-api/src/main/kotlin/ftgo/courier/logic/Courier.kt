package ftgo.courier.logic

import java.util.*

data class Courier(val id: Long?, val firstName: String, val lastName: String, var available: Boolean, val address: Address)
