package ftgo.consumer.common.constants

const val INBOUND_LEVEL = "INBOUND LEVEL"
const val LOGIC_LEVEL = "LOGIC LEVEL"
const val OUTBOUND_LEVEL = "OUTBOUND LEVEL"

fun withPrefix(prefix: String, message: String): String {
    return "[$prefix]: $message";
}