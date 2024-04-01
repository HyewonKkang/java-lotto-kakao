package domain;

public class EarningRate {
	private final double earningRate;

	public EarningRate(LottoMoney lottoMoney, WinningAmount winningAmount) {
		this.earningRate = calculate(lottoMoney.getSpentMoney(),
			winningAmount.getAmount());
	}

	private double calculate(int spent, long earned) {
		return (double)earned / spent;
	}

	public double getEarningRate() {
		return earningRate;
	}
}
