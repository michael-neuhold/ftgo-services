package ftgo.courier.outbound

import ftgo.courier.shared.Courier
import org.springframework.data.repository.CrudRepository

interface CourierRepository : CrudRepository<Courier, Long> {
}