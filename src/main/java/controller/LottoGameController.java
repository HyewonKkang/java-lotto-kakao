package controller;

import java.util.List;
import java.util.function.Supplier;

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
        Lottos lottos = purchaseLottos(lottoMoney);
        Lotto winningLottoNumbers = getWinningLottoNumbers();
        WinningLotto winningLotto = getWinningLotto(winningLottoNumbers);

        WinningResult winningResult = lottos.calculateWinningResult(winningLotto);
        printResult(winningResult, lottoMoney);
    }

    private Lottos purchaseLottos(LottoMoney paid) {
        int lottoCount = paid.calculateLottoCount();
        int manualCount = getManualLottoCount(lottoCount);
        Lottos lottos = lottoGenerator.generateLottos(lottoCount - manualCount);

        if (manualCount > 0) {
            List<Lotto> manualLottos = getManualLottoNumbers(manualCount);
            lottos.add(manualLottos);
        }
        lottoGameView.printPurchasedLottos(manualCount, lottos);
        return lottos;
    }

    private void printResult(WinningResult winningResult, LottoMoney lottoMoney) {
        lottoGameView.printWinningRank(winningResult);
        lottoGameView.printEarningRate(winningResult.calculateEarningRate(lottoMoney));
    }

    private LottoMoney getLottoMoney() {
        return requestInput(() -> new LottoMoney(lottoGameView.getLottoMoneyInput()));
    }

    private WinningLotto getWinningLotto(Lotto winningLottoNumbers) {
        return requestNumberInput(() -> {
            LottoBall bonusNumber = new LottoBall(lottoGameView.getBonusNumber());
            return new WinningLotto(winningLottoNumbers, bonusNumber);
        }, "숫자를 입력해주세요");
    }

    private Lotto getWinningLottoNumbers() {
        return requestNumberInput(lottoGameView::getWinningLottoNumbers, "\", \"로 구분되는 숫자를 입력해주세요.");
    }

    private int getManualLottoCount(int maxLottoCount) {
        return requestNumberInput(() -> {
            int manualCount = lottoGameView.getManualLottoCount();
            if (manualCount > maxLottoCount) {
                throw new IllegalArgumentException("수동으로 구매할 로또 수는 총 로또 수보다 작아야 합니다.");
            }
            return manualCount;
        }, "숫자를 입력해주세요.");
    }

    private List<Lotto> getManualLottoNumbers(int count) {
        return requestNumberInput(() -> {
            List<Lotto> manualLottos =  lottoGameView.getManualLottos(count);
            if (manualLottos.size() != count) {
                throw new IllegalArgumentException(count + "개의 로또 번호를 입력해주세요.");
            }
            return manualLottos;
        }, "\", \"로 구분되는 숫자를 입력해주세요.");
    }

    private <T> T requestInput(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get(); // 입력을 받아 검증하는 로직
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return requestNumberInput(inputSupplier, e.getMessage());
        }
    }

    private <T> T requestNumberInput(Supplier<T> inputSupplier, String errorMessage) {
        try {
            return inputSupplier.get(); // 입력을 받아 검증하는 로직
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] " + errorMessage);
            return requestNumberInput(inputSupplier, errorMessage);
        }  catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return requestNumberInput(inputSupplier, errorMessage);
        }
    }
}
