package lshh.gamification.domain.user;

import lshh.gamification.domain.user.component.UserRepository;
import lshh.gamification.domain.user.dto.UserJoinCommand;
import lshh.gamification.domain.user.dto.UserJoinResult;
import lshh.gamification.domain.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceIntegrationTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void join_success(){
        UserJoinCommand command = new UserJoinCommand("userId", "ELEMENTARY", "nick", "avatar", "room");

        UserJoinResult result = userService.join(command);

        assertEquals("success", result.result());
        Optional<User> optionalUser = userRepository.findByUserId(command.userId());
        assertTrue(optionalUser.isPresent());
        assertEquals(command.userId(), optionalUser.get().getUserId());
    }
}
