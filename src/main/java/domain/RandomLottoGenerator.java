package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {
	private static final List<Integer> numbers =
		IntStream.rangeClosed(Lotto.LOTTO_LOWER_BOUND, Lotto.LOTTO_UPPER_BOUND)
			.boxed().collect(Collectors.toList());

	@Override
	public Lotto generateLotto() {
		Collections.shuffle(numbers);
		return new Lotto(numbers.subList(0, Lotto.LOTTO_NUMBER_SIZE));
	}
}
