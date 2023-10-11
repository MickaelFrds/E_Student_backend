package com.app.Student;

public record StudentRequest(
        String firstName,
        String lastName,
        String birthDay,
        Integer age,
        String emailParent,
        String phoneParent,
        String observation,
        String additionalInformation
) {
}

