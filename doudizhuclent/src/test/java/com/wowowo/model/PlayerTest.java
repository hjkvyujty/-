package com.wowowo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.Socket;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private Player playerUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        playerUnderTest = new Player(0, "name", new Socket("host", 80), List.of(new Poker(0, "name", 0, false)));
    }

    @Test
    void testIdGetterAndSetter() {
        final int id = 0;
        playerUnderTest.setId(id);
        assertThat(playerUnderTest.getId()).isEqualTo(id);
    }

    @Test
    void testNameGetterAndSetter() {
        final String name = "name";
        playerUnderTest.setName(name);
        assertThat(playerUnderTest.getName()).isEqualTo(name);
    }

    @Test
    void testSocketGetterAndSetter() throws Exception {
        final Socket socket = new Socket("host", 80);
        playerUnderTest.setSocket(socket);
        assertThat(playerUnderTest.getSocket()).isEqualTo(socket);
    }

    @Test
    void testPokersGetterAndSetter() {
        final List<Poker> pokers = List.of(new Poker(0, "name", 0, false));
        playerUnderTest.setPokers(pokers);
        assertThat(playerUnderTest.getPokers()).isEqualTo(pokers);
    }

    @Test
    void testToString() {
        assertThat(playerUnderTest.toString()).isEqualTo("result");
    }
}
