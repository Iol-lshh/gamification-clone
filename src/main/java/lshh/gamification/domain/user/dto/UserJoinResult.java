package lshh.gamification.domain.user.dto;

public class UserJoinResult {
    public String result;
    public String resultData;

    public static UserJoinResult of(String result, String resultData) {
        UserJoinResult dto = new UserJoinResult();
        dto.result = result;
        dto.resultData = resultData;
        return dto;
    }
}
