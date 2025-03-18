package com.finaltask;

import org.junit.runner.JUnitCore;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running all UC tests...");
        JUnitCore.runClasses(
                UC1_EmptyCredentialsTest.class,
                UC2_UsernameOnlyTest.class,
                UC3_ValidCredentialsTest.class
        );
    }
}
