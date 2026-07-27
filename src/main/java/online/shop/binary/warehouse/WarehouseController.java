package online.shop.binary.warehouse;

import online.shop.binary.base.BaseController;
import online.shop.binary.service.WarehouseService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController extends BaseController<Warehouse, WarehouseService> {
}
