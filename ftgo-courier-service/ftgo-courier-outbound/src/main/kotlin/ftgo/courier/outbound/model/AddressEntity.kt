package ftgo.courier.outbound.model

import jakarta.persistence.Embeddable

@Embeddable
data class AddressEntity(var street: String, var city: String, var state: String, var zip: String)
