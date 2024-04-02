package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {
	@Test
	@DisplayName("당첨 통계 정보를 계산할 수 있다.")
	void winningResultTest() {
		// given : 사용자가 구매한 Lottos가 존재한다.
		// when : 당첨 통계(각 당첨 개수, 상금)를 계산한다.
		WinningResult result = generateTestWinningResult();

		assertThat(result.getWinningCount(Rank.LOSE)).isEqualTo(1);
		assertThat(result.getWinningCount(Rank.MATCH_THREE)).isEqualTo(0);
		assertThat(result.getWinningCount(Rank.MATCH_FOUR)).isEqualTo(1);
		assertThat(result.getWinningCount(Rank.MATCH_FIVE)).isEqualTo(0);
		assertThat(result.getWinningCount(Rank.MATCH_FIVE_WITH_BONUS)).isEqualTo(1);
		assertThat(result.getWinningCount(Rank.MATCH_SIX)).isEqualTo(1);
	}

	@Test
	@DisplayName("당첨 금액을 계산할 수 있다.")
	void winningMoneyResultTest() {
		// given : 사용자가 구매한 Lottos가 존재한다.
		// when : 당첨 통계(각 당첨 개수, 상금)를 계산한다.
		WinningResult result = generateTestWinningResult();

		WinningMoney resultMoney = new WinningMoney(WinningMoney.ZERO);
		resultMoney.addWinningMoney(new WinningMoney(WinningMoney.MATCH_FOUR));
		resultMoney.addWinningMoney(new WinningMoney(WinningMoney.MATCH_FIVE_WITH_BONUS));
		resultMoney.addWinningMoney(new WinningMoney(WinningMoney.MATCH_SIX));

		assertThat(result.getWinningMoney()).isEqualTo(resultMoney);
	}

	private WinningResult generateTestWinningResult() {
		// 사용자가 구매한 로또
		Lotto testLotto1 = LottoBall.toLotto(1, 2, 3, 4, 5, 6); // 4개 일치
		Lotto testLotto2 = LottoBall.toLotto(1, 2, 3, 4, 8, 9); // 6개 일치
		Lotto testLotto3 = LottoBall.toLotto(1, 2, 3, 4, 8, 10); // 5개 + 보너스 일치
		Lotto testLotto4 = LottoBall.toLotto(11, 12, 13, 14, 15, 16); // 꽝
		Lottos testLottos = new Lottos(List.of(testLotto1, testLotto2, testLotto3, testLotto4));

		// 당첨 로또
		Lotto winnigLotto = LottoBall.toLotto(1, 2, 3, 4, 8, 9);
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, new LottoBall(10));

		// 결과 계산
		return WinningResult.of(testWinningLotto, testLottos);
	}
}
