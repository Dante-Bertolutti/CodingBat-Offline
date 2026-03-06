package com.codingbat.model;

import java.util.List;

public record Problem(
    String id,
    String category,
    String name,
    String description,
    String methodSignature,
    String methodName,
    List<TestCase> testCases
) {}
