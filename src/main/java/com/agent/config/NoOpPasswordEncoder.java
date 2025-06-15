package com.agent.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class NoOpPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        // Do nothing and directly return the string representation of the original password.
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // Do nothing and directly compare the raw password with the encoded password (since the encodedPassword is actually the raw password).
        return rawPassword.toString().equals(encodedPassword);
    }


    public static PasswordEncoder getInstance() {
        return INSTANCE;
    }

    private static final PasswordEncoder INSTANCE = new NoOpPasswordEncoder();

    public NoOpPasswordEncoder() {}
}