package ru.arbalest.exception;

public class UserNotFoundException  extends RuntimeException {

    private final int id;

    public UserNotFoundException(int id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "User with id = " + id + " not found";
    }
}