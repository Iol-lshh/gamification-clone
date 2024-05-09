package lshh.gamification.infrastructure.shop;

import lshh.gamification.domain.shop.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopItemJpaRepository extends JpaRepository<ShopItem, Long>{

}
