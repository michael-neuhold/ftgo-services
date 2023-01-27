package ftgo.courier.constants

import java.net.URI
import java.util.*

const val API = "api"
const val V1 = "v1"

const val COURIERS = "couriers"

const val COURIERS_RESOURCE_V1 = "$API/$V1/$COURIERS"

fun buildCreatedUriV1(id: UUID?): URI {
    return URI("$COURIERS_RESOURCE_V1/$id")
}