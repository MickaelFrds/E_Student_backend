package com.app.Student;

public record StudentRequest(
        String firstName,
        String lastName,
        Integer age
) {
}
