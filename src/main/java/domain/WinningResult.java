package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinningResult {
	private final Map<Rank, Integer> winningResult;
	private final WinningMoney winningMoney;

	private WinningResult() {
		winningResult = new HashMap<>();
		winningMoney = new WinningMoney(WinningMoney.ZERO);
		Arrays.stream(Rank.values()).forEach(rank -> winningResult.put(rank, 0));
	}

	public static WinningResult of(WinningLotto winningLotto, Lottos lottos) {
		WinningResult result = new WinningResult();
		lottos.getLottos().forEach(lotto -> result.add(winningLotto.getRank(lotto)));
		return result;
	}

	private void add(Rank rank) {
		this.winningResult.put(rank, getWinningCount(rank) + 1);
		this.winningMoney.addWinningMoney(rank.getWinningMoney());
	}

	public int getWinningCount(Rank rank) {
		return this.winningResult.get(rank);
	}

	public WinningMoney getWinningMoney() {
		return this.winningMoney;
	}
}
