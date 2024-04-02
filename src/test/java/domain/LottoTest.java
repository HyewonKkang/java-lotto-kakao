package domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
	@Test
	@DisplayName("로또 번호는 오름차순으로 정렬되어있다.")
	void sortLottoTest() {
		List<LottoBall> unsorted = LottoBall.of(6, 5, 4, 3, 2, 1);
		Lotto lotto = new Lotto(unsorted);

		List<LottoBall> sorted = lotto.getLottoNumbers();

		assertThat(sorted).isSorted();
	}
}
