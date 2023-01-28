package ftgo.courier.inbound.api.dto

data class CreateCourierRequestDto(
    val firstName: String,
    val lastName: String,
    val available: Boolean,
    val address: AddressDto
)
