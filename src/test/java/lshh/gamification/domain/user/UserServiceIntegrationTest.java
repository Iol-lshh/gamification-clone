package lshh.gamification.domain.user;

import lshh.gamification.common.library.lock.AdvisoryLockException;
import lshh.gamification.domain.user.component.*;
import lshh.gamification.domain.user.dto.UserJoinCommand;
import lshh.gamification.domain.user.dto.UserJoinResult;
import lshh.gamification.domain.user.entity.User;
import lshh.gamification.domain.user.exception.UserJoinException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

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
        UserJoinCommand command = new UserJoinCommand("join_success", "ELEMENTARY", "nick", "avatar", "room");

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

    @Test
    @DisplayName("통합테스트 회원가입 실패 - 이미 가입된 사용자")
    public void join_fail_exists(){
        UserJoinCommand command = new UserJoinCommand("join_fail_exists", "ELEMENTARY", "nick", "avatar", "room");

        UserJoinResult result = userService.join(command);

        assertEquals("Y", result.result());
        assertThrows(UserJoinException.class, () -> userService.join(command));
    }

    // 동시성 회원가입 테스트
    @Test
    @DisplayName("통합테스트 회원가입 실패 - 동시성")
    public void join_fail_concurrent(){
        UserJoinCommand command = new UserJoinCommand("join_fail_concurrent", "ELEMENTARY", "nick", "avatar", "room");

        int testCount = 10;
        AtomicInteger failCount = new AtomicInteger(0);
        AtomicReference<UserJoinResult> result = new AtomicReference<>();
        ExecutorService executorService = Executors.newFixedThreadPool(testCount);
        IntStream.range(0, testCount).forEach(i -> {
            executorService.execute(() -> {
                try{
                    UserJoinResult joinResult = userService.join(command);
                    if(joinResult.result() != null && joinResult.result().equals("Y")){
                        result.set(joinResult);
                        System.out.println("Thread " + Thread.currentThread().getName() + " success-userId: " + command.userId());
                    }
                }catch (UserJoinException e){
                    failCount.incrementAndGet();
                    System.out.println("Thread " + Thread.currentThread().getName() + " user join buisness fail");
                }catch (AdvisoryLockException e) {
                    failCount.incrementAndGet();
                    System.out.println("Thread " + Thread.currentThread().getName() + " advisory lock fail");
                }catch (Exception e){
                    failCount.incrementAndGet();
                    System.out.println("Thread " + Thread.currentThread().getName() + " exception");
                }
            });
        });

        executorService.shutdown();
        try{
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        }catch (InterruptedException e) {
        }

        UserJoinResult joinResult = result.get();
        assertNotNull(joinResult);
        assertEquals("Y", joinResult.result());
        assertEquals(testCount - 1, failCount.get());
    }

}
