package ftgo.consumer.inbound.dto

data class CreateConsumerRequestDto(
    val firstName: String,
    val lastName: String,
    val email: String
)
