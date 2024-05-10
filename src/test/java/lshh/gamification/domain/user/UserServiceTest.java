package lshh.gamification.domain.user;

import lshh.gamification.common.user.CommonUser;
import lshh.gamification.common.user.NoSuchCommonUserException;
import lshh.gamification.domain.user.code.SchoolClass;
import lshh.gamification.domain.user.component.*;
import lshh.gamification.domain.user.dto.UserJoinCommand;
import lshh.gamification.domain.user.dto.UserJoinResult;
import lshh.gamification.domain.user.entity.User;
import lshh.gamification.domain.user.exception.UserJoinException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private CommonUserRepository commonUserRepository;

    @Mock
    private UserEtcInfoRepository etcInfoRepository;

    @Mock
    private UserEquipedRepository equipedRepository;

    @Mock
    private UserLevelRepository levelRepository;

    @Mock
    private UserInventoryItemRepository inventoryItemRepository;

    @Mock
    private UserNoticeMessenger noticeMessenger;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("회원가입: whenUserNotExists_throwsNoSuchCommonUserException")
    void join_whenUserExists_savesAndReturnsUser() {
        // given
        UserJoinCommand command = new UserJoinCommand("userId", "ELEMENTARY", "nick", "avatar", "room");
        CommonUser stubCommonUser = new CommonUser("userId", "name", "email", 1);
        given(commonUserRepository.findCommonUserByUserId(any())).willReturn(Optional.of(stubCommonUser));
        User stubUser = User.builder()
                        .idx(1L)
                        .userId(stubCommonUser.getUserId()).grade(stubCommonUser.getGrade())
                        .schoolClass(SchoolClass.valueOf(command.schoolClass()))
                        .defaultAvatar(command.defaultAvatar())
                        .defaultRoom(command.defaultRoom())
                        .build();
        given(userRepository.save(any())).willReturn(stubUser);

        // when
        UserJoinResult result = userService.join(command);

        // then
        verify(userRepository).save(any(User.class));
        assertEquals("Y", result.result());
        assertEquals("" + stubUser.getIdx(), result.resultData());
    }

    @Test
    @DisplayName("회원가입: userId 중복")
    void join_whenUserAlreadyExists_throwUserJoinException() {
        // given
        UserJoinCommand command = new UserJoinCommand("userId", "ELEMENTARY", "nick", "avatar", "room");
        given(userRepository.findByUserId(any())).willReturn(Optional.of(mock(User.class)));

        // when
        assertThrows(UserJoinException.class, () -> userService.join(command));
    }

    @Test
    @DisplayName("회원가입: 공통 user 없음")
    void join_whenCommonUserNotExists_throwNoSuchCommonUserException() {
        // given
        UserJoinCommand command = new UserJoinCommand("userId", "ELEMENTARY", "nick", "avatar", "room");
        given(commonUserRepository.findCommonUserByUserId(any())).willReturn(Optional.empty());

        // when
        assertThrows(NoSuchCommonUserException.class, () -> userService.join(command));
    }
}
