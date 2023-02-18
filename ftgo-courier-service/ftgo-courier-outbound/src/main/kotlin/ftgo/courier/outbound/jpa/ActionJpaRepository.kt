package ftgo.courier.outbound.jpa

import ftgo.courier.outbound.model.ActionEntity
import ftgo.courier.outbound.model.ActionId
import org.springframework.data.repository.CrudRepository

interface ActionJpaRepository : CrudRepository<ActionEntity, ActionId> {
}