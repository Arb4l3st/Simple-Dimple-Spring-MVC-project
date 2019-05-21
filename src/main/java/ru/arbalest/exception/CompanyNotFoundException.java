package ru.arbalest.exception;

public class CompanyNotFoundException extends RuntimeException {

    private final String TIN;

    public CompanyNotFoundException(String TIN) {
        this.TIN = TIN;
    }

    @Override
    public String getMessage() {
        return "Company with TIN = " + TIN + " not found";
    }
}
