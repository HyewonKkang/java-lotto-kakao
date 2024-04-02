package controller;

import java.util.List;

import domain.EarningRate;
import domain.Lotto;
import domain.LottoBall;
import domain.LottoGenerator;
import domain.LottoMoney;
import domain.Lottos;
import domain.WinningLotto;
import domain.WinningResult;
import view.LottoGameView;

public class LottoGameController {
	private final LottoGameView lottoGameView;
	private final LottoGenerator lottoGenerator;

	public LottoGameController(LottoGameView lottoGameView, LottoGenerator lottoGenerator) {
		this.lottoGameView = lottoGameView;
		this.lottoGenerator = lottoGenerator;
	}

	public void play() {
		LottoMoney lottoMoney = new LottoMoney(lottoGameView.getLottoMoneyInput());
		Lottos lottos = lottoGenerator.generateLottos(lottoMoney.calculateLottoCount());

		lottoGameView.printPurchasedLottos(lottos);
		WinningLotto winningLotto = getWinningLotto();
		WinningResult winningResult = WinningResult.of(winningLotto, lottos);

		lottoGameView.printWinningRank(winningResult);
		lottoGameView.printEarningRate(EarningRate.of(lottoMoney, winningResult.getWinningMoney()));
	}

	private WinningLotto getWinningLotto() {
		List<LottoBall> winningLottos = lottoGameView.getWinningLottoNumbers();
		int bonusNumber = lottoGameView.getBonusNumber();

		return new WinningLotto(new Lotto(winningLottos), new LottoBall(bonusNumber));
	}


}
