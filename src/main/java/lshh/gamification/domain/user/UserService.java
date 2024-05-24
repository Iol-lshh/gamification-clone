package lshh.gamification.domain.user;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lshh.gamification.common.library.lock.AdvisoryLock;
import lshh.gamification.common.library.user.CommonUser;
import lshh.gamification.common.library.user.NoSuchCommonUserException;
import lshh.gamification.domain.user.dto.UserView;
import lshh.gamification.domain.user.dto.UserJoinCommand;
import lshh.gamification.domain.user.dto.UserJoinResult;
import lshh.gamification.domain.user.component.*;
import lshh.gamification.domain.user.entity.User;
import lshh.gamification.domain.user.exception.UserJoinException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final CommonUserRepository commonUserRepository;
    private final UserEtcInfoRepository etcInfoRepository;
    private final UserEquippedInfoRepository equippedItemRepository;
    private final UserLevelRepository levelRepository;
    private final UserInventoryItemRepository inventoryItemRepository;
    private final UserNoticeMessenger noticeMessenger;

    @Operation(summary = "사용자 가입")
    @AdvisoryLock(key = "#command.userId()")
    @Transactional
    public UserJoinResult join(UserJoinCommand command) {
        userRepository.findByUserId(command.userId())
                .ifPresent(user -> {
                    throw new UserJoinException("이미 가입되어 있습니다.");
                });

        CommonUser commonUser = commonUserRepository.findCommonUserByUserId(command.userId())
                .orElseThrow(NoSuchCommonUserException::new);

        User user = command.toUserEntityWithCommonUser(commonUser);
        user = userRepository.save(user);
        noticeMessenger.sendJoinNotice(user);

        return new UserJoinResult("Y", ""+user.getIdx());
    }

    @Operation(summary = "사용자 목록 전체 조회")
    @Transactional(readOnly = true)
    public List<UserView> findAllCore() {
        List<User> users = userRepository.findAll();
        return UserView.from(users);
    }
}
