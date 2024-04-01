package domain;

import java.util.Arrays;

public enum Rank {
	LOSE(0, new WinningAmount(WinningAmount.ZERO)),
	SAME_THREE(3, new WinningAmount(WinningAmount.SAME_THREE)),
	SAME_FOUR(4, new WinningAmount(WinningAmount.SAME_FOUR)),
	SAME_FIVE(5, new WinningAmount(WinningAmount.SAME_FIVE)),
	SAME_FIVE_WITH_BONUS(5, new WinningAmount(WinningAmount.SAME_FIVE_WITH_BONUS)),
	SAME_SIX(6, new WinningAmount(WinningAmount.SAME_SIX));

	private final int sameNumberCount;
	private final WinningAmount winningAmount;

	Rank(int sameNumberCount, WinningAmount winningAmount) {
		this.sameNumberCount = sameNumberCount;
		this.winningAmount = winningAmount;
	}

	public WinningAmount getWinningAmount() {
		return winningAmount;
	}

	public static Rank findBySameNumberCount(int sameNumberCount) {
		if (sameNumberCount == 5) {
			throw new IllegalArgumentException("추가 정보가 필요합니다.");
		}
		return Arrays.stream(Rank.values())
			.filter(rank -> rank.sameNumberCount == sameNumberCount)
			.findFirst()
			.orElse(Rank.LOSE);
	}
}
