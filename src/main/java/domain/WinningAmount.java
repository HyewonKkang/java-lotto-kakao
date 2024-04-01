package domain;

public class WinningAmount {
	public static final long ZERO = 0;
	public static final long SAME_THREE = 5_000;
	public static final long SAME_FOUR = 50_000;
	public static final long SAME_FIVE = 1_500_000;
	public static final long SAME_FIVE_WITH_BONUS = 30_000_000;
	public static final long SAME_SIX = 2_000_000_000;

	private long amount;

	public WinningAmount(long amount) {
		this.amount = amount;
	}

	public void addWinningAmount(WinningAmount winningAmount) {
		this.amount += winningAmount.getAmount();
	}

	public long getAmount() {
		return amount;
	}
}
