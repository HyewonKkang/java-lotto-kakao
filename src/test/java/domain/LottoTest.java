package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    @DisplayName("로또 번호는 오름차순으로 정렬되어있다.")
    void sortLottoTest() {
        Lotto lotto = LottoBall.toLotto(6, 5, 4, 3, 2, 1);

        List<LottoBall> sorted = lotto.getLottoNumbers();

        assertThat(sorted).isSorted();
    }

    @Test
    @DisplayName("로또 번호는 여섯 개로 이뤄져야한다.")
    void lottoSizeTest() {
        assertThatThrownBy(() -> LottoBall.toLotto(6, 5, 4, 3, 2, 1, 11))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoBall.toLotto(6, 5, 4, 3, 2))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
