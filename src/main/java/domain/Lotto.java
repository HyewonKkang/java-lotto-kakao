package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
	public static final int LOTTO_NUMBER_SIZE = 6;
	public static final int LOTTO_UPPER_BOUND = 45;
	public static final int LOTTO_LOWER_BOUND = 1;

	private final List<Integer> lottoNumbers;

	public Lotto(List<Integer> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("로또 번호는 6개로 이뤄져야 합니다!");
		}
		Collections.sort(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}
}
