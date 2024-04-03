package domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoBall implements Comparable<LottoBall> {

    public static final int LOTTO_UPPER_BOUND = 45;
    public static final int LOTTO_LOWER_BOUND = 1;

    private final int lottoBall;

    public LottoBall(int lottoBall) {
        validateLottoBall(lottoBall);
        this.lottoBall = lottoBall;
    }

    public static Lotto toLotto(int ...lottoBalls) {
        return new Lotto(Arrays.stream(lottoBalls)
            .mapToObj(LottoBall::new)
            .collect(Collectors.toList()));
    }

    private void validateLottoBall(int lottoBall) {
        if (lottoBall < LOTTO_LOWER_BOUND || lottoBall > LOTTO_UPPER_BOUND) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 까지여야 합니다.");
        }
    }

    public int getLottoBall() {
        return lottoBall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoBall lottoBall1 = (LottoBall)o;
        return lottoBall == lottoBall1.lottoBall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoBall);
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottoBall);
    }

    @Override
    public int compareTo(LottoBall lottoBall) {
        return Integer.compare(this.lottoBall, lottoBall.lottoBall);
    }
}
