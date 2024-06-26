package lshh.gamification.domain.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserEquippedInfo {
    @Id
    private Long userIdx;

    private Long itemIdxA01;
    private Long itemIdxA11;
    private Long itemIdxA12;
    private Long itemIdxA14;
    private Long itemIdxA19;
    private Long itemIdxA30;
    private Long itemIdxA31;
    private Long itemIdxE01;
    private Long itemIdxR10;

    @OneToOne
    @MapsId
    private User user;
}
