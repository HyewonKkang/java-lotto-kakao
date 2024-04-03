package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> winningResult;
    private WinningMoney winningMoney;

    public WinningResult() {
        winningResult = new HashMap<>();
        winningMoney = new WinningMoney(WinningMoney.ZERO);
        Arrays.stream(Rank.values()).forEach(rank -> winningResult.put(rank, 0));
    }

    public void add(Rank rank) {
        this.winningResult.put(rank, getWinningCount(rank) + 1);
        this.winningMoney = this.winningMoney.addWinningMoney(rank.getWinningMoney());
    }

    public EarningRate calculateEarningRate(LottoMoney lottoMoney) {
        return EarningRate.of(lottoMoney, this.winningMoney);
    }

    public int getWinningCount(Rank rank) {
        return this.winningResult.get(rank);
    }

    public WinningMoney getWinningMoney() {
        return this.winningMoney;
    }
}
