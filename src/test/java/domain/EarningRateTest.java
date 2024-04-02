package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EarningRateTest {
	@Test
	@DisplayName("총 수익률을 계산한다.")
	void earningRateTest() {
		LottoMoney spent = new LottoMoney(10500);
		WinningMoney earned = new WinningMoney(WinningMoney.MATCH_THREE);

		EarningRate earningRate = EarningRate.of(spent, earned);
		double expected = (double)earned.getMoney() / spent.getSpentMoney();

		Assertions.assertThat(earningRate.getEarningRate()).isEqualTo(expected);
	}
}
