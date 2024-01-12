package com.wowowo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PokerLabelTest {

    private PokerLabel pokerLabelUnderTest;

    @BeforeEach
    void setUp() {
        pokerLabelUnderTest = new PokerLabel(0, "name", 0, false, false);
    }

    @Test
    void testIsSelectedGetterAndSetter() {
        final boolean isSelected = false;
        pokerLabelUnderTest.setSelected(isSelected);
        assertThat(pokerLabelUnderTest.isSelected()).isFalse();
    }

    @Test
    void testIdGetterAndSetter() {
        final int id = 0;
        pokerLabelUnderTest.setId(id);
        assertThat(pokerLabelUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testNameGetterAndSetter() {
        final String name = "name";
        pokerLabelUnderTest.setName(name);
        assertThat(pokerLabelUnderTest.getName()).isEqualTo(name);
    }

    @Test
    void testNumGetterAndSetter() {
        final int num = 0;
        pokerLabelUnderTest.setNum(num);
        assertThat(pokerLabelUnderTest.getNum()).isEqualTo(num);
    }

    @Test
    void testIsOutGetterAndSetter() {
        final boolean isOut = false;
        pokerLabelUnderTest.setOut(isOut);
        assertThat(pokerLabelUnderTest.isOut()).isFalse();
    }

    @Test
    void testIsUpGetterAndSetter() {
        final boolean isUp = false;
        pokerLabelUnderTest.setUp(isUp);
        assertThat(pokerLabelUnderTest.isUp()).isFalse();
    }

    @Test
    void testTurnUp() {
        // Setup
        // Run the test
        pokerLabelUnderTest.turnUp();

        // Verify the results
    }

    @Test
    void testTurnDown() {
        // Setup
        // Run the test
        pokerLabelUnderTest.turnDown();

        // Verify the results
    }

    @Test
    void testCompareTo() {
        assertThat(pokerLabelUnderTest.compareTo("arg0")).isEqualTo(0);
        assertThatThrownBy(() -> pokerLabelUnderTest.compareTo("arg0")).isInstanceOf(NullPointerException.class);
        assertThatThrownBy(() -> pokerLabelUnderTest.compareTo("arg0")).isInstanceOf(ClassCastException.class);
    }
}
