package domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinningResult calculateWinningResult(WinningLotto winningLotto) {
        WinningResult result = new WinningResult();
        lottos.forEach(lotto -> result.add(winningLotto.getRank(lotto)));
        return result;
    }

    public void add(List<Lotto> addedLottos) {
        this.lottos.addAll(addedLottos);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
