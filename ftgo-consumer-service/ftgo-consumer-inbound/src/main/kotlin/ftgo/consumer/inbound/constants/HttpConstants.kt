package ftgo.consumer.inbound.constants

import java.net.URI
import java.util.UUID

const val API = "api"
const val V1 = "v1"

const val CONSUMERS = "consumers"

const val CONSUMERS_RESOURCE_V1 = "$API/$V1/$CONSUMERS"
const val ID_PARAM = "{id}"

fun buildCreatedUriV1(id: UUID?): URI {
    return URI("$CONSUMERS_RESOURCE_V1/$id")
}