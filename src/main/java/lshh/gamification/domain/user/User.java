package lshh.gamification.domain.user;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lshh.gamification.domain.user.code.MemberType;
import lshh.gamification.domain.user.code.SchoolClass;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    private Long idx;
    private String userId;
    private SchoolClass schoolClass;
    private String nickName;
    private MemberType memberType;
    private Integer ruby;
    @Nullable
    private String defaultAvatar;
    @Nullable
    private String defaultRoom;
    boolean createAvatarYn;
    boolean createRoomYn;
    boolean noticeYn;
    private LocalDateTime regDate;
    boolean servicePauseYn;
    @Nullable
    private Integer AvatarNickCode;
    @Nullable
    private Integer grade;

    @OneToOne(mappedBy = "user")
    private UserEtcInfo etcInfo;
    @OneToOne(mappedBy = "user")
    private UserEquiped equiped;
    @OneToOne(mappedBy = "user")
    private UserLevel level;
    @OneToMany(mappedBy = "user")
    private List<UserInventoryItem> inventoryItems;
}
