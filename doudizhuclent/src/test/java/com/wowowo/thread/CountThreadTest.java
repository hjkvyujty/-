package com.wowowo.thread;

import com.wowowo.view.MainFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CountThreadTest {

    @Mock
    private MainFrame mockMainFrame;

    private CountThread countThreadUnderTest;

    @BeforeEach
    void setUp() {
        countThreadUnderTest = new CountThread(0, mockMainFrame);
    }

    @Test
    void testIsRunGetterAndSetter() {
        final boolean isRun = false;
        countThreadUnderTest.setRun(isRun);
        assertThat(countThreadUnderTest.isRun()).isFalse();
    }

    @Test
    void testRun() {
        // Setup
        // Run the test
        countThreadUnderTest.run();

        // Verify the results
    }
}
