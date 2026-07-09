package online.shop.binary.products;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.shop.binary.base.BaseController;

@RestController
@RequestMapping("/products")
public class ProductsController extends BaseController<Products, ProductsService>{}
