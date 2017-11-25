package com.hackathon.networking;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class TokenGenerator {
    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lower = upper.toLowerCase(Locale.ROOT);
    private static final String digits = "0123456789";
    private static final String alphanum = upper + lower + digits;
    private final Random random;
    private final char[] symbols;
    private final char[] buf;

    public TokenGenerator(int length, Random random, String symbols) {
        if (length < 1)
            throw new IllegalArgumentException();
        if (symbols.length() < 2)
            throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }

    public TokenGenerator(int length, Random random) {
        this(length, random, alphanum);
    }

    public TokenGenerator(int length) {
        this(length, new SecureRandom());
    }

    public TokenGenerator() {
        this(21);
    }

    public String generate() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }
}
