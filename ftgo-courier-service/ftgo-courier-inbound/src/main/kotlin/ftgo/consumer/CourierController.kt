package ftgo.consumer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CourierController(private val courierLogic: CourierLogic) {

    @GetMapping("/courier")
    fun getMessage(): List<String> {
        return courierLogic.getAllCouriers();
    }

}