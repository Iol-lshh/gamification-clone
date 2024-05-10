package lshh.gamification.domain.user.component;

import lshh.gamification.domain.user.entity.UserInventoryItem;

import java.util.List;

public interface UserInventoryItemRepository {
    void save(UserInventoryItem entity);
    void saveAll(List<UserInventoryItem> entities);
}
