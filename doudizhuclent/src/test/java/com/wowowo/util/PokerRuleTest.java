package com.wowowo.util;

import com.wowowo.model.PokerLabel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PokerRuleTest {

    @Test
    void testCheckPokerType() {
        // Setup
        final List<PokerLabel> list = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final PokerType result = PokerRule.checkPokerType(list);

        // Verify the results
        assertThat(result).isEqualTo(PokerType.p_1);
    }

    @Test
    void testIsWangZha() {
        // Setup
        final List<PokerLabel> list = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final boolean result = PokerRule.isWangZha(list);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testIsSame() {
        // Setup
        final List<PokerLabel> list = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final boolean result = PokerRule.isSame(list, 0);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testIsSanDaiYi() {
        // Setup
        final List<PokerLabel> list = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final boolean result = PokerRule.isSanDaiYi(list);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testIsSanDaiYiDui() {
        // Setup
        final List<PokerLabel> list = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final boolean result = PokerRule.isSanDaiYiDui(list);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testIsShunZi() {
        // Setup
        final List<PokerLabel> list = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final boolean result = PokerRule.isShunZi(list);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testIsLianDui() {
        // Setup
        final List<PokerLabel> list = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final boolean result = PokerRule.isLianDui(list);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testIsFeiJI() {
        // Setup
        final List<PokerLabel> list = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final boolean result = PokerRule.isFeiJI(list);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testIsFeiJIDaiChiBang2() {
        // Setup
        final List<PokerLabel> list = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final boolean result = PokerRule.isFeiJIDaiChiBang2(list);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testIsFeiJIDaiChiBang1() {
        // Setup
        final List<PokerLabel> list = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final boolean result = PokerRule.isFeiJIDaiChiBang1(list);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testFeiCount() {
        // Setup
        final List<PokerLabel> list = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final List<Integer> result = PokerRule.feiCount(list);

        // Verify the results
        assertThat(result).isEqualTo(List.of(0));
    }

    @Test
    void testFeiDuiCount() {
        // Setup
        final List<PokerLabel> list = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final int result = PokerRule.feiDuiCount(list, List.of(0));

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testFeiDanZhangCount() {
        // Setup
        final List<PokerLabel> list = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final int result = PokerRule.feiDanZhangCount(list, List.of(0));

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testIsBigger() {
        // Setup
        final List<PokerLabel> prevList = List.of(new PokerLabel(0, "name", 0, false, false));
        final List<PokerLabel> currentList = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final boolean result = PokerRule.isBigger(prevList, currentList);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testCompareLast() {
        // Setup
        final List<PokerLabel> prevList = List.of(new PokerLabel(0, "name", 0, false, false));
        final List<PokerLabel> currentList = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final boolean result = PokerRule.compareLast(prevList, currentList);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testCompare() {
        // Setup
        final List<PokerLabel> prevList = List.of(new PokerLabel(0, "name", 0, false, false));
        final List<PokerLabel> currentList = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final boolean result = PokerRule.compare(prevList, currentList);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testSan() {
        // Setup
        final List<PokerLabel> list = List.of(new PokerLabel(0, "name", 0, false, false));

        // Run the test
        final int result = PokerRule.san(list);

        // Verify the results
        assertThat(result).isEqualTo(0);
    }
}
