package domain;

public class WinningAmount {
	public static final WinningAmount ZERO = new WinningAmount(0);
	public static final WinningAmount SAME_THREE = new WinningAmount(5_000);
	public static final WinningAmount SAME_FOUR = new WinningAmount(50_000);
	public static final WinningAmount SAME_FIVE = new WinningAmount(1_500_000);
	public static final WinningAmount SAME_FIVE_WITH_BONUS = new WinningAmount(30_000_000);
	public static final WinningAmount SAME_SIX = new WinningAmount(2_000_000_000);

	private long amount;

	public long getAmount() {
		return amount;
	}

	private WinningAmount(long amount) {
		this.amount = amount;
	}
}
