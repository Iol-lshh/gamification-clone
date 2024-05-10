package lshh.gamification.domain.user.component;

import lshh.gamification.domain.user.entity.UserInventoryItem;

public interface UserInventoryItemRepository {
    void save(UserInventoryItem of);
}
