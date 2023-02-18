package ftgo.courier.outbound.mapper.address

import ftgo.courier.logic.Address
import ftgo.courier.outbound.model.AddressEntity

fun toEntity(address: Address): AddressEntity {
    return AddressEntity(address.street1, address.street2, address.city, address.state, address.zip)
}