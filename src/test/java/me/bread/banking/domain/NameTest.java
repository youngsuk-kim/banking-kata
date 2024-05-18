package me.bread.banking.domain;

import me.bread.banking.banking.domain.Name;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NameTest {

    @Test
    public void validNameTest() {
        // Given
        // When
        // Then
        assertDoesNotThrow(() -> new Name("John", "Doe"));
    }

    @Test
    public void firstNameCannotBeNullTest() {
        // Given
        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Name(null, "Doe"));
        // Then
        assertEquals("First name cannot be null or blank.", exception.getMessage());
    }

    @Test
    public void firstNameCannotBeBlankTest() {
        // Given
        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Name("", "Doe"));
        // Then
        assertEquals("First name cannot be null or blank.", exception.getMessage());
    }

    @Test
    public void lastNameCannotBeNullTest() {
        // Given
        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Name("John", null));
        // Then
        assertEquals("Last name cannot be null or blank.", exception.getMessage());
    }

    @Test
    public void lastNameCannotBeBlankTest() {
        // Given
        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Name("John", ""));
        // Then
        assertEquals("Last name cannot be null or blank.", exception.getMessage());
    }

    @Test
    public void namesCannotBeTooLongTest() {
        // Given
        String longName = "a".repeat(51);
        // When
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> new Name(longName, "Doe"));
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> new Name("John", longName));
        // Then
        assertEquals("Names cannot be longer than 50 characters.", exception1.getMessage());
        assertEquals("Names cannot be longer than 50 characters.", exception2.getMessage());
    }
}
