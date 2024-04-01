package domain;

import java.util.Arrays;

public enum Rank {
	LOSE(0, new WinningMoney(WinningMoney.ZERO)),
	MATCH_THREE(3, new WinningMoney(WinningMoney.MATCH_THREE)),
	MATCH_FOUR(4, new WinningMoney(WinningMoney.MATCH_FOUR)),
	MATCH_FIVE(5, new WinningMoney(WinningMoney.MATCH_FIVE)),
	MATCH_FIVE_WITH_BONUS(5, new WinningMoney(WinningMoney.MATCH_FIVE_WITH_BONUS)),
	MATCH_SIX(6, new WinningMoney(WinningMoney.MATCH_SIX));

	private final int matchNumberCount;
	private final WinningMoney winningMoney;

	Rank(int matchNumberCount, WinningMoney winningMoney) {
		this.matchNumberCount = matchNumberCount;
		this.winningMoney = winningMoney;
	}

	public WinningMoney getWinningMoney() {
		return winningMoney;
	}

	public static Rank findByMatchNumberCount(int matchNumberCount) {
		if (matchNumberCount == 5) {
			throw new IllegalArgumentException("추가 정보가 필요합니다.");
		}
		return Arrays.stream(Rank.values())
			.filter(rank -> rank.matchNumberCount == matchNumberCount)
			.findFirst()
			.orElse(Rank.LOSE);
	}
}
