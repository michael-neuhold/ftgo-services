package ftgo.courier.outbound.mapper.address

import ftgo.courier.logic.Address
import ftgo.courier.outbound.model.AddressEntity

fun toDomain(addressEntity: AddressEntity): Address {
    return Address(addressEntity.street, addressEntity.city, addressEntity.state, addressEntity.zip)
}