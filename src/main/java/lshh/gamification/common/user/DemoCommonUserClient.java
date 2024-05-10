package lshh.gamification.common.user;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Optional;

public class DemoCommonUserClient extends CommonUserClientImplement {
    @Override
    public Optional<CommonUser> findByUserId(String userId) {
        String randomUserName = RandomStringUtils.randomAlphabetic(5);
        String randomName = RandomStringUtils.randomAlphabetic(5);
        int randomGrade = RandomUtils.nextInt(1, 7);
        CommonUser sample = new CommonUser(userId, randomUserName, randomName, randomGrade);
        return Optional.of(sample);
    }
}
