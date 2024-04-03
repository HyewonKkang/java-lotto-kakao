package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoBallTest {
	@ParameterizedTest
	@ValueSource(ints = {1, 10, 45})
	@DisplayName("로또 번호 생성에 성공한다.")
	void validLottoNumberBoundaryTest(int number) {
		assertThatCode(() -> new LottoBall(number))
			.doesNotThrowAnyException();
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 46})
	@DisplayName("로또 번호는 1에서 45 사이의 정수여야 한다.")
	void invalidLottoNumberBoundaryTest(int number) {
		assertThatThrownBy(() -> new LottoBall(number))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
