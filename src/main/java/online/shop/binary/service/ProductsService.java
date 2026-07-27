package online.shop.binary.service;

import org.springframework.stereotype.Service;

import online.shop.binary.products.Products;
import online.shop.binary.products.ProductsRepository;

@Service
public class ProductsService extends BaseService<Products, ProductsRepository> {
}
