package domain;

public class WinningMoney {
	public static final long ZERO = 0;
	public static final long MATCH_THREE = 5_000;
	public static final long MATCH_FOUR = 50_000;
	public static final long MATCH_FIVE = 1_500_000;
	public static final long MATCH_FIVE_WITH_BONUS = 30_000_000;
	public static final long MATCH_SIX = 2_000_000_000;

	private long money;

	public WinningMoney(long money) {
		this.money = money;
	}

	public void addWinningMoney(WinningMoney winningMoney) {
		this.money += winningMoney.getMoney();
	}

	public long getMoney() {
		return money;
	}
}
