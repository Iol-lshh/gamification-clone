package lshh.gamification.domain.user.entity;

import jakarta.persistence.*;
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
    private String itemId;
    private boolean equipYn;
    private LocalDateTime useStartDate;
    private LocalDateTime useEndDate;
    private Long shopItemIdx;

    @ManyToOne
    @JoinColumn(name = "user_idx")
    private User user;

    public static UserInventoryItem of(Long userIdx, String itemId, boolean equipYn) {
        UserInventoryItem userInventoryItem = new UserInventoryItem();
        userInventoryItem.user = User.of(userIdx);
        userInventoryItem.itemId = itemId;
        userInventoryItem.equipYn = equipYn;
        return userInventoryItem;
    }
}
