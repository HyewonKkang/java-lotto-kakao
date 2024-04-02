package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class LottoBallTest {
	@Test
	@DisplayName("로또 번호 생성에 성공한다.")
	void validLottoNumberBoundaryTest() {
		assertThatCode(() -> new LottoBall(1))
			.doesNotThrowAnyException();
	}

	@Test
	@DisplayName("로또 번호는 1에서 45 사이의 정수여야 한다.")
	void invalidLottoNumberBoundaryTest() {
		assertThatThrownBy(() -> new LottoBall(46))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new LottoBall(0))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
