package domain;

public class EarningRate {
	private final double earningRate;

	public EarningRate(LottoMoney lottoMoney, WinningMoney winningMoney) {
		this.earningRate = calculate(lottoMoney.getSpentMoney(),
			winningMoney.getMoney());
	}

	private double calculate(int spent, long earned) {
		return (double)earned / spent;
	}

	public double getEarningRate() {
		return earningRate;
	}
}
