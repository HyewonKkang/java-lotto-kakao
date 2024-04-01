package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
	@Test
	@DisplayName("숫자 3개가 일치하면 5,000원이다.")
	void checkThree() {
		Lotto testLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto winnigLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, 10);

		WinningAmount winningAmount = testWinningLotto.getResultAmount(testLotto);

		assertThat(winningAmount.getAmount()).isEqualTo(WinningAmount.SAME_THREE);
	}

	@Test
	@DisplayName("숫자 4개가 일치하면 50,000원이다.")
	void checkFour() {
		Lotto testLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto winnigLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9));
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, 10);

		WinningAmount winningAmount = testWinningLotto.getResultAmount(testLotto);

		assertThat(winningAmount.getAmount()).isEqualTo(WinningAmount.SAME_FOUR);
	}

	@Test
	@DisplayName("숫자 5개가 일치하면 1,500,000원이다.")
	void checkFive() {
		Lotto testLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto winnigLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9));
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, 10);

		WinningAmount winningAmount = testWinningLotto.getResultAmount(testLotto);

		assertThat(winningAmount.getAmount()).isEqualTo(WinningAmount.SAME_FIVE);
	}

	@Test
	@DisplayName("숫자 5개와 보너스 번호가 일치하면 30,000,000원이다.")
	void checkFiveWithBonus() {
		Lotto testLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto winnigLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9));
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, 6);

		WinningAmount winningAmount = testWinningLotto.getResultAmount(testLotto);

		assertThat(winningAmount.getAmount()).isEqualTo(WinningAmount.SAME_FIVE_WITH_BONUS);
	}

	@Test
	@DisplayName("숫자 6개가 일치하면 2,000,000,000원이다.")
	void checkSix() {
		Lotto testLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto winnigLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, 10);

		WinningAmount winningAmount = testWinningLotto.getResultAmount(testLotto);

		assertThat(winningAmount.getAmount()).isEqualTo(WinningAmount.SAME_SIX);
	}
}
