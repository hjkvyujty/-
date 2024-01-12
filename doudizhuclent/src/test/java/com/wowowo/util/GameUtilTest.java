package com.wowowo.util;

import com.wowowo.model.PokerLabel;
import org.junit.jupiter.api.Test;

class GameUtilTest {

    @Test
    void testMove() {
        // Setup
        final PokerLabel pokerLabel = new PokerLabel(0, "name", 0, false, false);

        // Run the test
        GameUtil.move(pokerLabel, 0, 0);

        // Verify the results
    }

    @Test
    void testMove2() {
        // Setup
        final PokerLabel pokerLabel = new PokerLabel(0, "name", 0, false, false);

        // Run the test
        GameUtil.move2(pokerLabel, 0, 0);

        // Verify the results
    }
}
