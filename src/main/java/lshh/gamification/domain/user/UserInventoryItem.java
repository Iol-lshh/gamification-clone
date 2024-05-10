package lshh.gamification.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserInventoryItem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long idx;
    private Long userIdx;
    private String itemId;
    private boolean equipYn;
    private LocalDateTime useStartDate;
    private LocalDateTime useEndDate;
    private Long shopItemIdx;

    public static UserInventoryItem of(Long userIdx, String itemId, boolean equipYn) {
        UserInventoryItem userInventoryItem = new UserInventoryItem();
        userInventoryItem.userIdx = userIdx;
        userInventoryItem.itemId = itemId;
        userInventoryItem.equipYn = equipYn;
        return userInventoryItem;
    }
}
