package lshh.gamification.domain.user.dto;

import lshh.gamification.common.library.user.CommonUser;
import lshh.gamification.domain.user.code.SchoolClass;
import lshh.gamification.domain.user.entity.*;
import lshh.gamification.domain.user.exception.UserJoinException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserJoinCommandTest {

    @Test
    @DisplayName("회원가입 명령 값 유효성 검증 - userId가 null인 경우 UserJoinException 발생")
    void testUserJoinCommand_throwsExceptionWithNullUserId() {
        String nullValue = null;
        Exception e = assertThrows(UserJoinException.class, () ->
                new UserJoinCommand(nullValue, "someSchoolClass", "Nick", "defaultAvatar", "defaultRoom"));
        assertEquals("userId is null or empty", e.getMessage());
    }

    @Test
    @DisplayName("회원가입 명령 값 유효성 검증 - userId가 빈 값인 경우 UserJoinException 발생")
    void testUserJoinCommand_throwsExceptionWithEmptyUserId() {
        Exception e = assertThrows(UserJoinException.class, () ->
                new UserJoinCommand("", "someSchoolClass", "Nick", "defaultAvatar", "defaultRoom"));
        assertEquals("userId is null or empty", e.getMessage());
    }

    @Test
    @DisplayName("회원가입 명령 값 유효성 검증 - defaultAvatar가 null인 경우 UserJoinException 발생")
    void testUserJoinCommand_throwsExceptionWithNullDefaultAvatar() {
        String nullValue = null;
        Exception e = assertThrows(UserJoinException.class, () ->
                new UserJoinCommand("someUserId", "someSchoolClass", "Nick", nullValue, "defaultRoom"));
        assertEquals("defaultAvatar is null or empty", e.getMessage());
    }

    @Test
    @DisplayName("회원가입 명령 값 유효성 검증 - defaultAvatar가 빈 값인 경우 UserJoinException 발생")
    void testUserJoinCommand_throwsExceptionWithEmptyDefaultAvatar() {
        Exception e = assertThrows(UserJoinException.class, () ->
                new UserJoinCommand("someUserId", "someSchoolClass", "Nick", "", "defaultRoom"));
        assertEquals("defaultAvatar is null or empty", e.getMessage());
    }

    @Test
    @DisplayName("회원가입 명령 값 유효성 검증 - defaultRoom이 null인 경우 UserJoinException 발생")
    void testUserJoinCommand_throwsExceptionWithNullDefaultRoom() {
        String nullValue = null;
        Exception e = assertThrows(UserJoinException.class, () ->
                new UserJoinCommand("someUserId", "someSchoolClass", "Nick", "defaultAvatar", nullValue));
        assertEquals("defaultRoom is null or empty", e.getMessage());
    }

    @Test
    @DisplayName("회원가입 명령 값 유효성 검증 - defaultRoom이 빈 값인 경우 UserJoinException 발생")
    void testUserJoinCommand_throwsExceptionWithEmptyDefaultRoom() {
        Exception e = assertThrows(UserJoinException.class, () ->
                new UserJoinCommand("someUserId", "someSchoolClass", "Nick", "defaultAvatar", ""));
        assertEquals("defaultRoom is null or empty", e.getMessage());
    }

    @Test
    @DisplayName("회원가입 명령 객체 생성 - 성공")
    void testUserJoinCommand_successfulCreation() {
        UserJoinCommand command = new UserJoinCommand("someUserId", "someSchoolClass", "Nick", "defaultAvatar", "defaultRoom");
        assertEquals("someUserId", command.userId());
        assertEquals("someSchoolClass", command.schoolClass());
        assertEquals("Nick", command.nickName());
        assertEquals("defaultAvatar", command.defaultAvatar());
        assertEquals("defaultRoom", command.defaultRoom());
    }

    @Test
    @DisplayName("회원가입 명령 객체를 통한 User 엔티티 생성 - 성공")
    void testToUserEntityWithCommonUser() {
        UserJoinCommand command = new UserJoinCommand("someUserId", "ELEMENTARY", "Nick", "defaultAvatar", "defaultRoom");
        CommonUser commonUser = new CommonUser(command.userId(), "commonUserName", "commonName", 2); // Assuming a CommonUser instance can be created here

        User user = command.toUserEntityWithCommonUser(commonUser);

        assertEquals(command.userId(), user.getUserId());
        assertEquals(SchoolClass.valueOf(command.schoolClass()), user.getSchoolClass());
        assertEquals(commonUser.getName(), user.getNickName());
        assertEquals(command.defaultAvatar(), user.getDefaultAvatar());
        assertEquals(command.defaultRoom(), user.getDefaultRoom());
        assertEquals(commonUser.getGrade(), user.getGrade());
    }

}