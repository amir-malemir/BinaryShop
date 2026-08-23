package online.shop.binary.service.impl;

import org.springframework.stereotype.Service;

import online.shop.binary.service.WarehouseService;
import online.shop.binary.warehouse.Warehouse;
import online.shop.binary.warehouse.WarehouseRepository;

@Service
public class WarehouseServiceImpl
        extends BaseServiceImpl<Warehouse, WarehouseRepository>
        implements WarehouseService {

    public WarehouseServiceImpl(WarehouseRepository repository) {
        super(repository);
    }
}