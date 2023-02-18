package ftgo.courier.inbound.api.dto

data class AddressDto(
    val street1: String,
    val street2: String,
    val city: String,
    val state: String,
    val zip: String
)