package domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoBall implements Comparable<LottoBall> {
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
		if (lottoBall < 1 || lottoBall > 45) {
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
