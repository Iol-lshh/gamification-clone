package lshh.gamification.infrastructure.user;

import lshh.gamification.domain.user.entity.UserInventoryItem;
import lshh.gamification.domain.user.component.UserInventoryItemRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserInventoryItemRepositoryImplement implements UserInventoryItemRepository {
    @Override
    public void save(UserInventoryItem of) {
        //
    }
}
