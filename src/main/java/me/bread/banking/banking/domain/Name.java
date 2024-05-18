package me.bread.banking.banking.domain;

public record Name(String firstName, String lastName) {

    public Name {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank.");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank.");
        }
        if (firstName.length() > 50 || lastName.length() > 50) {
            throw new IllegalArgumentException("Names cannot be longer than 50 characters.");
        }
    }
}