package ftgo.courier.inbound.mapper.address

import ftgo.courier.inbound.api.dto.AddressDto
import ftgo.courier.logic.Address

fun toDto(address: Address): AddressDto {
    return AddressDto(address.street1, address.street2, address.city, address.state, address.zip)
}