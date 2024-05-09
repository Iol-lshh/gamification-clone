package lshh.gamification.infrastructure.shop;

import lombok.RequiredArgsConstructor;
import lshh.gamification.domain.shop.ShopItemRepository;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ShopItemRepositoryImplement implements ShopItemRepository {
    private final ShopItemJpaRepository jpaRepository;
}
