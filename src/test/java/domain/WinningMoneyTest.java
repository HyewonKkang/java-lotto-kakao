package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningMoneyTest {
	@Test
	@DisplayName("당첨 상금을 더하는 것이 가능하다.")
	void addWinningAmountTest() {
		WinningMoney winningMoney = new WinningMoney(WinningMoney.MATCH_FOUR);
		winningMoney.addWinningMoney(new WinningMoney(WinningMoney.MATCH_FIVE));

		long expectedAmount = WinningMoney.MATCH_FOUR + WinningMoney.MATCH_FIVE;
		assertThat(winningMoney.getMoney()).isEqualTo(expectedAmount);
	}
}
