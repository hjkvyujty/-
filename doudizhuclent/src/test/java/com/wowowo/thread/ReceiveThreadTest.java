package com.wowowo.thread;

import com.wowowo.model.Player;
import com.wowowo.model.Poker;
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
class ReceiveThreadTest {

    @Mock
    private MainFrame mockMainFrame;

    private ReceiveThread receiveThreadUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        receiveThreadUnderTest = new ReceiveThread(new Socket("host", 80), mockMainFrame);
    }

    @Test
    void testIsRunGetterAndSetter() {
        final boolean isRun = false;
        receiveThreadUnderTest.setRun(isRun);
        assertThat(receiveThreadUnderTest.isRun()).isFalse();
    }

    @Test
    void testRun() {
        // Setup
        // Run the test
        receiveThreadUnderTest.run();

        // Verify the results
        // Confirm MainFrame.showAllPlayersInfo(...).
        final Player player = new Player();
        player.setId(0);
        player.setName("name");
        final Poker poker = new Poker();
        poker.setId(0);
        poker.setName("name");
        poker.setNum(0);
        player.setPokers(List.of(poker));
        final List<Player> players = List.of(player);
        verify(mockMainFrame).showAllPlayersInfo(players);
        verify(mockMainFrame).showMsg(0, 1);
        verify(mockMainFrame).getLord();
        verify(mockMainFrame).addLordPokers(List.of(new Poker(0, "name", 0, false)));
        verify(mockMainFrame).showChuPaiJabel();
        verify(mockMainFrame).showLordIcon(0);
        verify(mockMainFrame).addClickEventToPoker();
        verify(mockMainFrame).showOutPokerList(0, List.of(new Poker(0, "name", 0, false)));
        verify(mockMainFrame).gameOver();
    }
}
