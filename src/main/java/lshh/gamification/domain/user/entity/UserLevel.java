package lshh.gamification.domain.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserLevel {
    @Id
    private Long userIdx;
    private Integer level;
    private String gradeLevel;
    private Integer totalExp;
    private Integer requestExp;
    private LocalDateTime lastLevelUpDate;
    private LocalDateTime lastExpDate;
    private Integer beforeLevel;

    @OneToOne
    @MapsId
    private User user;
}
