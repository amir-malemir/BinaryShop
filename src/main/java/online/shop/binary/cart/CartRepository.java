package online.shop.binary.cart;

import online.shop.binary.base.BaseRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends BaseRepository<Cart> {
	List<Cart> findByUserIdAndStatus(Long userId, CartStatus status);
}