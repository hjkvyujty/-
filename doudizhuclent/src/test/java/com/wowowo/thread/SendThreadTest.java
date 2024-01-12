package com.wowowo.thread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.Socket;

import static org.assertj.core.api.Assertions.assertThat;

class SendThreadTest {

    private SendThread sendThreadUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        sendThreadUnderTest = new SendThread(new Socket("host", 80), "msg");
    }

    @Test
    void testMsgGetterAndSetter() {
        final String msg = "msg";
        sendThreadUnderTest.setMsg(msg);
        assertThat(sendThreadUnderTest.getMsg()).isEqualTo(msg);
    }

    @Test
    void testSocketGetterAndSetter() throws Exception {
        final Socket socket = new Socket("host", 80);
        sendThreadUnderTest.setSocket(socket);
        assertThat(sendThreadUnderTest.getSocket()).isEqualTo(socket);
    }

    @Test
    void testIsRunGetterAndSetter() {
        final boolean isRun = false;
        sendThreadUnderTest.setRun(isRun);
        assertThat(sendThreadUnderTest.isRun()).isFalse();
    }

    @Test
    void testRun() {
        // Setup
        // Run the test
        sendThreadUnderTest.run();

        // Verify the results
    }
}
