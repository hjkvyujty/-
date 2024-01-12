package com.wowowo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PokerTest {

    private Poker pokerUnderTest;

    @BeforeEach
    void setUp() {
        pokerUnderTest = new Poker(0, "name", 0, false);
    }

    @Test
    void testIsOutGetterAndSetter() {
        final boolean isOut = false;
        pokerUnderTest.setOut(isOut);
        assertThat(pokerUnderTest.isOut()).isFalse();
    }

    @Test
    void testIdGetterAndSetter() {
        final int id = 0;
        pokerUnderTest.setId(id);
        assertThat(pokerUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testNameGetterAndSetter() {
        final String name = "name";
        pokerUnderTest.setName(name);
        assertThat(pokerUnderTest.getName()).isEqualTo(name);
    }

    @Test
    void testNumGetterAndSetter() {
        final int num = 0;
        pokerUnderTest.setNum(num);
        assertThat(pokerUnderTest.getNum()).isEqualTo(num);
    }
}
