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
		LottoMoney lottoMoney = getLottoMoney();
		Lottos lottos = lottoGenerator.generateLottos(lottoMoney.calculateLottoCount());

		lottoGameView.printPurchasedLottos(lottos);
		Lotto winningLottoNumbers = getWinningLottoNumbers();
		WinningLotto winningLotto = getWinningLotto(winningLottoNumbers);
		WinningResult winningResult = WinningResult.of(winningLotto, lottos);

		lottoGameView.printWinningRank(winningResult);
		lottoGameView.printEarningRate(EarningRate.of(lottoMoney, winningResult.getWinningMoney()));
	}

	private LottoMoney getLottoMoney() {
		try {
			return new LottoMoney(lottoGameView.getLottoMoneyInput());
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
		return getLottoMoney();
	}

	private WinningLotto getWinningLotto(Lotto winningLottoNumbers) {
		try {
			LottoBall bonusNumber = new LottoBall(lottoGameView.getBonusNumber());
			return new WinningLotto(winningLottoNumbers, bonusNumber);
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			return getWinningLotto(winningLottoNumbers);
		}
	}

	private Lotto getWinningLottoNumbers() {
		try {
			List<LottoBall> winningLottos = lottoGameView.getWinningLottoNumbers();
			return new Lotto(winningLottos);
		} catch (NumberFormatException e) {
			System.out.println("[ERROR] \", \"로 구분되는 숫자를 입력해주세요!");
			return getWinningLottoNumbers();
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			return getWinningLottoNumbers();
		}
	}
}
