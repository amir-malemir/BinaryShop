package online.shop.binary.warehouse;

import online.shop.binary.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarehouseRepository extends BaseRepository<Warehouse> {

    Optional<Warehouse> findByProductId(Long productId);
}
