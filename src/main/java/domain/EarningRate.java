package domain;

public class EarningRate {
	private final double earningRate;

	private EarningRate(double earningRate) {
		this.earningRate = earningRate;
	}

	public static EarningRate of(LottoMoney lottoMoney, WinningMoney winningMoney) {
		return new EarningRate(calculate(lottoMoney.getSpentMoney(),
			winningMoney.getMoney()));
	}

	private static double calculate(int spent, long earned) {
		if (spent == 0) {
			return 0;
		}
		return (double)earned / spent;
	}

	public double getEarningRate() {
		return earningRate;
	}
}
