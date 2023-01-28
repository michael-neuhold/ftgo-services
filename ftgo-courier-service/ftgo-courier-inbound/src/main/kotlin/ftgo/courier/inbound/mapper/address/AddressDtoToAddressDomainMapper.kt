package ftgo.courier.inbound.mapper.address

import ftgo.courier.inbound.api.dto.AddressDto
import ftgo.courier.logic.Address

fun toDomain(addressDto: AddressDto): Address {
    return Address(addressDto.street, addressDto.city, addressDto.state, addressDto.zip)
}