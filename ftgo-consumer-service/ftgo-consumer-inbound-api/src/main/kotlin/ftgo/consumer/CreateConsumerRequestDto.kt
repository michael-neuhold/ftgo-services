package ftgo.consumer

data class CreateConsumerRequestDto(
    private val firstName: String,
    private val lastName: String,
    private val email: String
)
