package ftgo.courier.outbound.model

import jakarta.persistence.*

@Entity
data class CourierEntity(
    val firstName: String,
    val lastName: String,
    val available: Boolean,
    @Embedded
    val address: AddressEntity,
    @OneToMany(mappedBy = "courierId", fetch = FetchType.EAGER)
    val actions: MutableList<ActionEntity> = ArrayList()
) {

    @Id
    @GeneratedValue
    var id: Long? = null

}
