package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
	public static final int LOTTO_NUMBER_SIZE = 6;
	public static final int LOTTO_UPPER_BOUND = 45;
	public static final int LOTTO_LOWER_BOUND = 1;

	private final List<LottoBall> lottoNumbers;

	public Lotto(List<LottoBall> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
			throw new IllegalArgumentException("로또 번호는 6개로 이뤄져야 합니다!");
		}
		Collections.sort(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}

	public List<LottoBall> getLottoNumbers() {
		return lottoNumbers;
	}

	public boolean contains(LottoBall lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}
}
