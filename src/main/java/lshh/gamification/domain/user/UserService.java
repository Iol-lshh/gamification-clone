package lshh.gamification.domain.user;

import lombok.RequiredArgsConstructor;
import lshh.gamification.common.user.CommonUser;
import lshh.gamification.common.user.NoSuchCommonUserException;
import lshh.gamification.domain.user.dto.UserJoinCommand;
import lshh.gamification.domain.user.dto.UserJoinResult;
import lshh.gamification.domain.user.component.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final CommonUserRepository commonUserRepository;
    private final UserEtcInfoRepository etcInfoRepository;
    private final UserEquipedRepository equipedRepository;
    private final UserLevelRepository levelRepository;
    private final UserInventoryItemRepository inventoryItemRepository;
    private final UserNoticeMessenger noticeMessenger;

    @Transactional
    public UserJoinResult join(UserJoinCommand command) {
        CommonUser commonUser = commonUserRepository.findCommonUserByUserId(command.userId())
                .orElseThrow(NoSuchCommonUserException::new);

        User user = command.toUserEntityWithCommonUser(commonUser);
        Long userIdx = userRepository.save(user).getIdx();

        etcInfoRepository.save(command.toEtcInfoEntity(userIdx));
        equipedRepository.save(command.toEquipedEntity(userIdx));
        levelRepository.save(command.toLevelEntity(userIdx));
        inventoryItemRepository.save(command.toDefaultInventoryItemEntity(userIdx));
        noticeMessenger.sendJoinNotice(user);

        return UserJoinResult.of("Y", ""+user.getIdx());
    }


}
