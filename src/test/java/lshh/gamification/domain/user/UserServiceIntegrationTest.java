package lshh.gamification.domain.user;

import lshh.gamification.domain.user.component.*;
import lshh.gamification.domain.user.dto.UserJoinCommand;
import lshh.gamification.domain.user.dto.UserJoinResult;
import lshh.gamification.domain.user.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceIntegrationTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserEtcInfoRepository etcInfoRepository;
    @Autowired
    UserEquippedInfoRepository equipedRepository;
    @Autowired
    UserLevelRepository levelRepository;
    @Autowired
    UserInventoryItemRepository inventoryItemRepository;

    @Test
    @DisplayName("통합테스트 회원가입 성공 - 데이터베이스 이용")
    public void join_success(){
        UserJoinCommand command = new UserJoinCommand("userId", "ELEMENTARY", "nick", "avatar", "room");

        UserJoinResult result = userService.join(command);

        assertEquals("Y", result.result());
        Optional<User> optionalUser = userRepository.findByUserId(command.userId());
        assertTrue(optionalUser.isPresent());
        assertEquals(command.userId(), optionalUser.get().getUserId());
        assertTrue(etcInfoRepository.findByUserIdx(optionalUser.get().getIdx()).isPresent());
        assertTrue(equipedRepository.findByUserIdx(optionalUser.get().getIdx()).isPresent());
        assertTrue(levelRepository.findByUserIdx(optionalUser.get().getIdx()).isPresent());
        assertFalse(inventoryItemRepository.findByUserIdx(optionalUser.get().getIdx()).isEmpty());
    }
}
