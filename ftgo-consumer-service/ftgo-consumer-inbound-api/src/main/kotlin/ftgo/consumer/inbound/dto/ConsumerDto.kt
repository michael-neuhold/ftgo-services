package ftgo.consumer.inbound.dto

import java.util.UUID

data class ConsumerDto(val id: UUID?, val firstName: String, val lastName: String, val email: String)
