package lshh.gamification.common.user;

public class NoSuchCommonUserException extends RuntimeException{
    public NoSuchCommonUserException(String message) {
        super(message);
    }
    public NoSuchCommonUserException(){
        super("No such common user exists.");
    }
}
