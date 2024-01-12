package com.wowowo.thread;

import com.wowowo.model.Poker;
import com.wowowo.model.PokerLabel;
import com.wowowo.view.MainFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.Socket;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ChuPaiThreadTest {

    @Mock
    private MainFrame mockMainFrame;

    private ChuPaiThread chuPaiThreadUnderTest;

    @BeforeEach
    void setUp() {
        chuPaiThreadUnderTest = new ChuPaiThread(0, mockMainFrame);
    }

    @Test
    void testTimeGetterAndSetter() {
        final int time = 0;
        chuPaiThreadUnderTest.setTime(time);
        assertThat(chuPaiThreadUnderTest.getTime()).isEqualTo(time);
    }

    @Test
    void testMainFrameGetterAndSetter() throws Exception {
        final MainFrame mainFrame = new MainFrame("uname", new Socket("host", 80));
        chuPaiThreadUnderTest.setMainFrame(mainFrame);
        assertThat(chuPaiThreadUnderTest.getMainFrame()).isEqualTo(mainFrame);
    }

    @Test
    void testIsRunGetterAndSetter() {
        final boolean isRun = false;
        chuPaiThreadUnderTest.setRun(isRun);
        assertThat(chuPaiThreadUnderTest.isRun()).isFalse();
    }

    @Test
    void testRun() {
        // Setup
        // Run the test
        chuPaiThreadUnderTest.run();

        // Verify the results
        verify(mockMainFrame).removeOutPokerFromPokerList();
    }

    @Test
    void testChangePokerLableToPoker() {
        // Setup
        final List<PokerLabel> selectedPokerLabels = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final List<Poker> result = chuPaiThreadUnderTest.changePokerLableToPoker(selectedPokerLabels);

        // Verify the results
    }
}
