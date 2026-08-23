package online.shop.binary.service.impl;

import org.springframework.stereotype.Service;

import online.shop.binary.products.Products;
import online.shop.binary.products.ProductsRepository;
import online.shop.binary.service.ProductsService;

@Service
public class ProductsServiceImpl
        extends BaseServiceImpl<Products, ProductsRepository>
        implements ProductsService {

    public ProductsServiceImpl(ProductsRepository repository) {
        super(repository);
    }
}