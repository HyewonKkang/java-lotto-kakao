package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningAmountTest {
	@Test
	@DisplayName("당첨 상금을 더하는 것이 가능하다.")
	void addWinningAmountTest() {
		WinningAmount winningAmount = new WinningAmount(WinningAmount.SAME_FOUR);
		winningAmount.addWinningAmount(new WinningAmount(WinningAmount.SAME_FIVE));

		long expectedAmount = WinningAmount.SAME_FOUR + WinningAmount.SAME_FIVE;
		assertThat(winningAmount.getAmount()).isEqualTo(expectedAmount);
	}
}
