package lshh.gamification.infrastructure.user;

import lshh.gamification.domain.user.entity.UserInventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInventoryItemJpaRepository extends JpaRepository<UserInventoryItem, Long> {
    List<UserInventoryItem> findByUserIdx(Long userIdx);
}
