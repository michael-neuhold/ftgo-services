package ftgo.courier.inbound.api.dto

class UpdateCourierRequestDto(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val available: Boolean,
    val address: AddressDto
)