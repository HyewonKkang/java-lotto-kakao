package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoMoneyTest {
	@Test
	@DisplayName("1000원 단위의 로또 개수를 계산한다.")
	void lottoNumberTest() {
		LottoMoney lottoMoney = new LottoMoney(14000);

		int bought = lottoMoney.calculateLottoCount();

		assertThat(bought).isEqualTo(14);
	}

	@Test
	@DisplayName("1000원으로 나누어떨어지지 않는 부분은 버려진다.")
	void lottoNumberRemainTest() {
		LottoMoney lottoMoney = new LottoMoney(14500);

		int bought = lottoMoney.calculateLottoCount();

		assertThat(bought).isEqualTo(14);
	}
}
