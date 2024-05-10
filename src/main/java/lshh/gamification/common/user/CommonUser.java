package lshh.gamification.common.user;

import lombok.Getter;

@Getter
public class CommonUser {
    private String userId;
    private String userName;
    private String name;
    private Integer grade;

    public CommonUser(String userId, String userName, String name, Integer grade) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.grade = grade;
    }
}
