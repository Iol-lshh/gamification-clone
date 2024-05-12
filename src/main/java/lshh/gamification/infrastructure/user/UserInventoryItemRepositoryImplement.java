package lshh.gamification.infrastructure.user;

import lombok.RequiredArgsConstructor;
import lshh.gamification.domain.user.entity.UserInventoryItem;
import lshh.gamification.domain.user.component.UserInventoryItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserInventoryItemRepositoryImplement implements UserInventoryItemRepository {

    private final UserInventoryItemJpaRepository jpaRepository;

    @Override
    public void save(UserInventoryItem entity) {
        jpaRepository.save(entity);
    }

    @Override
    public void saveAll(List<UserInventoryItem> entities) {
        jpaRepository.saveAll(entities);
    }

    @Override
    public List<UserInventoryItem> findByUserIdx(Long userIdx) {
        return jpaRepository.findByUserIdx(userIdx);
    }

    @Override
    public List<UserInventoryItem> findAll() {
        return jpaRepository.findAll();
    }
}
