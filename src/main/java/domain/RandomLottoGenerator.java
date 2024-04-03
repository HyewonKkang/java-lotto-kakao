package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {
    private static final List<Integer> numbers =
        IntStream.rangeClosed(Lotto.LOTTO_LOWER_BOUND, Lotto.LOTTO_UPPER_BOUND)
            .boxed().collect(Collectors.toList());

    @Override
    public Lottos generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(generateLotto());
        }
        return new Lottos(lottos);
    }

    private Lotto generateLotto() {
        Collections.shuffle(numbers);
        List<LottoBall> lottoBalls = numbers.subList(0, Lotto.LOTTO_NUMBER_SIZE)
            .stream().map(LottoBall::new).collect(Collectors.toList());
        return new Lotto(lottoBalls);
    }
}
