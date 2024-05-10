package lshh.gamification.domain.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lshh.gamification.domain.user.code.MemberType;
import lshh.gamification.domain.user.code.SchoolClass;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String userId;
    private SchoolClass schoolClass;
    private String nickName;
    private MemberType memberType;
    private Integer ruby;
    private String defaultAvatar;
    private String defaultRoom;
    boolean createAvatarYn;
    boolean createRoomYn;
    boolean noticeYn;
    private LocalDateTime regDate;
    boolean servicePauseYn;
    private Integer AvatarNickCode;
    private Integer grade;

    @OneToOne(mappedBy = "user")
    private UserEtcInfo etcInfo;
    @OneToOne(mappedBy = "user")
    private UserEquiped equiped;
    @OneToOne(mappedBy = "user")
    private UserLevel level;
    @OneToMany(mappedBy = "user")
    private List<UserInventoryItem> inventoryItems;

    public static User of(Long userIdx) {
        User user = new User();
        user.idx = userIdx;
        return user;
    }

    public void initAggregates() {
        initEtcInfo();
        initEquiped();
        initLevel();
        initInventoryItem();
    }

    public void initEtcInfo() {
        this.etcInfo = UserEtcInfo.builder()
                .user(this)
                .build();
    }

    public void initEquiped() {
        this.equiped = UserEquiped.builder()
                .user(this)
                .build();
    }

    public void initLevel() {
        this.level = UserLevel.builder()
                .user(this)
                .build();
    }

    public void initInventoryItem() {
        UserInventoryItem inventoryItem = UserInventoryItem.builder()
                .user(this)
                .itemId(defaultRoom)
                .build();
        this.inventoryItems = new ArrayList<>();
        this.inventoryItems.add(inventoryItem);
    }
}
