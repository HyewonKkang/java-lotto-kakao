package domain;

import java.util.List;

import domain.Lotto;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public int getLottoCount() {
		return lottos.size();
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
