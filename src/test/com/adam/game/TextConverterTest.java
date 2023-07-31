package com.adam.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextConverterTest {

    private TextConverter CONVERTER;

    @BeforeEach
    void setUp() {
        CONVERTER = new TextConverter();
    }

    @Test
    public void testCat() {
        String s = CONVERTER.everyOtherCapital("cat");
        assertEquals("cAt", s);
    }

    @Test
    public void testApple() {
        String s = CONVERTER.everyOtherCapital("apple");
        assertEquals("aPpLe", s);
    }

    @Test
    public void testSpoonCrushingBlow() {
        String s = CONVERTER.spoon("crushing blow");
        assertEquals("blushing crow", s);
    }

    @Test
    public void testSpoonSoundBite() {
        String s = CONVERTER.spoon("sound bite");
        assertEquals("bound site", s);
    }
}
