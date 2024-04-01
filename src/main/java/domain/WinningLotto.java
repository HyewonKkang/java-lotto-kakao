package domain;

import java.util.List;

public class WinningLotto {
	private final Lotto winnigLotto;
	private final int bonusNumber;

	public WinningLotto(Lotto winnigLotto, int bonusNumber) {
		this.winnigLotto = winnigLotto;
		this.bonusNumber = bonusNumber;
	}

	public WinningAmount getResultAmount(Lotto lotto) {
		int sameNumberCount = countSameNumber(lotto);
		if (sameNumberCount != 5) {
			Rank rank = Rank.findBySameNumberCount(sameNumberCount);
			return rank.getWinningAmount();
		}
		if (hasBonusNumber(lotto)) {
			return Rank.SAME_FIVE_WITH_BONUS.getWinningAmount();
		}
		return Rank.SAME_FIVE.getWinningAmount();
	}

	private int countSameNumber(Lotto lotto) {
		List<Integer> targetLottoNumbers = lotto.getLottoNumbers();
		return (int) targetLottoNumbers.stream().filter(winnigLotto::contains).count();
	}

	private boolean hasBonusNumber(Lotto lotto) {
		return lotto.contains(bonusNumber);
	}
}
