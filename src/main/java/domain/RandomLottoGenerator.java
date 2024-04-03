package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomLottoGenerator implements LottoGenerator {
    private static final List<Integer> numbers =
        IntStream.rangeClosed(LottoBall.LOTTO_LOWER_BOUND, LottoBall.LOTTO_UPPER_BOUND)
            .boxed().collect(Collectors.toList());

    @Override
    public Lottos generateLottos(int lottoCount) {
        return Stream.generate(this::generateLotto)
            .limit(lottoCount)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }

    private Lotto generateLotto() {
        Collections.shuffle(numbers);
        List<LottoBall> lottoBalls = numbers.subList(0, Lotto.LOTTO_NUMBER_SIZE)
            .stream().map(LottoBall::valueOf).collect(Collectors.toList());
        return new Lotto(lottoBalls);
    }
}
