package ftgo.courier.inbound.api.dto

import java.util.*

data class CourierDto(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val available: Boolean,
    val address: AddressDto,
    val action: List<ActionDto>
)