package com.wowowo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MessageTest {

    private Message messageUnderTest;

    @BeforeEach
    void setUp() {
        messageUnderTest = new Message(0, 0, "content", List.of(new Poker(0, "name", 0, false)));
    }

    @Test
    void testTypeidGetterAndSetter() {
        final int typeid = 0;
        messageUnderTest.setTypeid(typeid);
        assertThat(messageUnderTest.getTypeid()).isEqualTo(typeid);
    }

    @Test
    void testPlayeridGetterAndSetter() {
        final int playerid = 0;
        messageUnderTest.setPlayerid(playerid);
        assertThat(messageUnderTest.getPlayerid()).isEqualTo(playerid);
    }

    @Test
    void testContentGetterAndSetter() {
        final String content = "content";
        messageUnderTest.setContent(content);
        assertThat(messageUnderTest.getContent()).isEqualTo(content);
    }

    @Test
    void testPokersGetterAndSetter() {
        final List<Poker> pokers = List.of(new Poker(0, "name", 0, false));
        messageUnderTest.setPokers(pokers);
        assertThat(messageUnderTest.getPokers()).isEqualTo(pokers);
    }
}
