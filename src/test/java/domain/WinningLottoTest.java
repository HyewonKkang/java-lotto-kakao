package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
	@Test
	@DisplayName("당첨 결과를 계산할 수 있다.")
	void checkRank() {
		Lotto testLotto = LottoBall.toLotto(1, 2, 3, 4, 5, 6);
		Lotto winnigLotto = LottoBall.toLotto(1, 2, 3, 7, 8, 9);
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, new LottoBall(10));

		Rank rank = testWinningLotto.getRank(testLotto);

		assertThat(rank).isEqualTo(Rank.MATCH_THREE);
	}

	@Test
	@DisplayName("숫자 3개가 일치하면 5,000원이다.")
	void checkThree() {
		Lotto testLotto = LottoBall.toLotto(1, 2, 3, 4, 5, 6);
		Lotto winnigLotto = LottoBall.toLotto(1, 2, 3, 7, 8, 9);
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, new LottoBall(10));

		WinningMoney winningMoney = testWinningLotto.getResultAmount(testLotto);

		assertThat(winningMoney.getMoney()).isEqualTo(WinningMoney.MATCH_THREE);
	}

	@Test
	@DisplayName("숫자 4개가 일치하면 50,000원이다.")
	void checkFour() {
		Lotto testLotto = LottoBall.toLotto(1, 2, 3, 4, 5, 6);
		Lotto winnigLotto = LottoBall.toLotto(1, 2, 3, 4, 8, 9);
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, new LottoBall(10));

		WinningMoney winningMoney = testWinningLotto.getResultAmount(testLotto);

		assertThat(winningMoney.getMoney()).isEqualTo(WinningMoney.MATCH_FOUR);
	}

	@Test
	@DisplayName("숫자 5개가 일치하면 1,500,000원이다.")
	void checkFive() {
		Lotto testLotto = LottoBall.toLotto(1, 2, 3, 4, 5, 6);
		Lotto winnigLotto = LottoBall.toLotto(1, 2, 3, 4, 5, 9);
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, new LottoBall(10));

		WinningMoney winningMoney = testWinningLotto.getResultAmount(testLotto);

		assertThat(winningMoney.getMoney()).isEqualTo(WinningMoney.MATCH_FIVE);
	}

	@Test
	@DisplayName("숫자 5개와 보너스 번호가 일치하면 30,000,000원이다.")
	void checkFiveWithBonus() {
		Lotto testLotto = LottoBall.toLotto(1, 2, 3, 4, 5, 6);
		Lotto winnigLotto = LottoBall.toLotto(1, 2, 3, 4, 5, 9);
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, new LottoBall(6));

		WinningMoney winningMoney = testWinningLotto.getResultAmount(testLotto);

		assertThat(winningMoney.getMoney()).isEqualTo(WinningMoney.MATCH_FIVE_WITH_BONUS);
	}

	@Test
	@DisplayName("숫자 6개가 일치하면 2,000,000,000원이다.")
	void checkSix() {
		Lotto testLotto = LottoBall.toLotto(1, 2, 3, 4, 5, 6);
		Lotto winnigLotto = LottoBall.toLotto(1, 2, 3, 4, 5, 6);
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, new LottoBall(10));

		WinningMoney winningMoney = testWinningLotto.getResultAmount(testLotto);

		assertThat(winningMoney.getMoney()).isEqualTo(WinningMoney.MATCH_SIX);
	}
}
