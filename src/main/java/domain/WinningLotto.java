package domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winnigLotto;
    private final LottoBall bonusNumber;

    public WinningLotto(Lotto winnigLotto, LottoBall bonusNumber) {
        if (winnigLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
        this.winnigLotto = winnigLotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank(Lotto lotto) {
        return Rank.findRank(countSameNumber(lotto), hasBonusNumber(lotto));
    }

    private int countSameNumber(Lotto lotto) {
        List<LottoBall> targetLottoNumbers = lotto.getLottoNumbers();
        return (int) targetLottoNumbers.stream().filter(winnigLotto::contains).count();
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
