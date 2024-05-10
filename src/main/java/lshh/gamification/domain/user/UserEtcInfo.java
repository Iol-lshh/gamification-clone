package lshh.gamification.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lshh.gamification.domain.user.code.ProfileType;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserEtcInfo {
    @Id
    private Long userIdx;
    private Long nickNameListIdx;
    private Long nickNameRegistedNumber;
    private boolean searchAllowYn;
    private ProfileType profileType;
    private String profilePath;
    private Integer goodCount;
    private Integer visitCount;
    private LocalDateTime updated;
    private Integer friendCount;
    private String nickNameFullString;

}
