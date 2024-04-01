package domain;

import java.util.List;

public class WinningLotto {
	private final Lotto winnigLotto;
	private final int bonusNumber;

	public WinningLotto(Lotto winnigLotto, int bonusNumber) {
		this.winnigLotto = winnigLotto;
		this.bonusNumber = bonusNumber;
	}

	public WinningMoney getResultAmount(Lotto lotto) {
		int matchNumberCount = countSameNumber(lotto);
		if (matchNumberCount != 5) {
			Rank rank = Rank.findByMatchNumberCount(matchNumberCount);
			return rank.getWinningMoney();
		}
		if (hasBonusNumber(lotto)) {
			return Rank.MATCH_FIVE_WITH_BONUS.getWinningMoney();
		}
		return Rank.MATCH_FIVE.getWinningMoney();
	}

	private int countSameNumber(Lotto lotto) {
		List<Integer> targetLottoNumbers = lotto.getLottoNumbers();
		return (int) targetLottoNumbers.stream().filter(winnigLotto::contains).count();
	}

	private boolean hasBonusNumber(Lotto lotto) {
		return lotto.contains(bonusNumber);
	}
}
