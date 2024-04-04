package controller;

import java.util.List;

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
        int lottoCount = lottoMoney.calculateLottoCount();
        int manualCount = getManualLottoCount(lottoCount);
        Lottos lottos = lottoGenerator.generateLottos(lottoCount - manualCount);

        if (manualCount > 0) {
            List<Lotto> manualLottos = getManualLottoNumbers(manualCount);
            lottos.add(manualLottos);
        }

        lottoGameView.printPurchasedLottos(manualCount, lottos);
        Lotto winningLottoNumbers = getWinningLottoNumbers();
        WinningLotto winningLotto = getWinningLotto(winningLottoNumbers);
        WinningResult winningResult = lottos.calculateWinningResult(winningLotto);

        lottoGameView.printWinningRank(winningResult);
        lottoGameView.printEarningRate(winningResult.calculateEarningRate(lottoMoney));
    }

    private LottoMoney getLottoMoney() {
        try {
            int money = lottoGameView.getLottoMoneyInput();
            if (money < 1000) {
                throw new IllegalArgumentException("돈은 1000원 이상이어야 합니다.");
            }
            return new LottoMoney(money);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getLottoMoney();
        }
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
            return lottoGameView.getWinningLottoNumbers();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] \", \"로 구분되는 숫자를 입력해주세요.");
            return getWinningLottoNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getWinningLottoNumbers();
        }
    }

    private int getManualLottoCount(int maxLottoCount) {
        try {
            int manualCount = lottoGameView.getManualLottoCount();
            if (manualCount > maxLottoCount) {
                throw new IllegalArgumentException("수동으로 구매할 로또 수는 총 로또 수보다 작아야 합니다.");
            }
            return manualCount;
        } catch (NumberFormatException e) {
            System.out.print("[ERROR] 숫자를 입력해주세요.");
            return getManualLottoCount(maxLottoCount);
        } catch (IllegalArgumentException e) {
            System.out.print("[ERROR] " + e.getMessage());
            return getManualLottoCount(maxLottoCount);
        }
    }

    private List<Lotto> getManualLottoNumbers(int count) {
        try {
            List<Lotto> manualLottos =  lottoGameView.getManualLottos(count);
            if (manualLottos.size() != count) {
                throw new IllegalArgumentException(count + "개의 로또 번호를 입력해주세요.");
            }
            return manualLottos;
        } catch (NumberFormatException e) {
            System.out.print("[ERROR] \", \"로 구분되는 숫자를 입력해주세요.");
            return getManualLottoNumbers(count);
        } catch (IllegalArgumentException e) {
            System.out.print("[ERROR] " + e.getMessage());
            return getManualLottoNumbers(count);
        }
    }
}
