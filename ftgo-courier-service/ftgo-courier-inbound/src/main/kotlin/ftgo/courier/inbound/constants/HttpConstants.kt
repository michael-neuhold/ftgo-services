package ftgo.courier.inbound.constants

import java.net.URI

const val API = "api"
const val V1 = "v1"

const val COURIERS = "couriers"

const val COURIERS_RESOURCE_V1 = "/$API/$V1/$COURIERS"

const val ID_PARAM = "{id}"
const val AVAILABILITY = "availability"

const val AVAILABILITY_OF_COURIER = "$ID_PARAM/$AVAILABILITY"

fun buildCreatedUriV1(id: Long?): URI {
    return URI("$COURIERS_RESOURCE_V1/$id")
}