package yatzy;

import java.util.Collections;
import java.util.Set;

public class YatzyScore {

	private YatzyScore() {
		throw new IllegalStateException();
	}

	public static int chance(Roll roll) {
		return roll.sum();
	}

	public static int yatzy(Roll roll) {
		if (!roll.isYatzy()) {
			return 0;
		}
		return 50;
	}

	public static int ones(Roll roll) {
		return roll.sumDicesOf(1);
	}

	public static int twos(Roll roll) {
		return roll.sumDicesOf(2);
	}

	public static int threes(Roll roll) {
		return roll.sumDicesOf(3);
	}

	public static int fours(Roll roll) {
		return roll.sumDicesOf(4);
	}

	public static int fives(Roll roll) {
		return roll.sumDicesOf(5);
	}

	public static int sixes(Roll roll) {
		return roll.sumDicesOf(6);
	}

	public static int onePair(Roll roll) {
		Set<Integer> pairs = roll.findPairs();
		if (!pairs.isEmpty()) {
			return Collections.max(pairs) * 2;
		}
		return 0;
	}

	public static int twoPair(Roll roll) {
		Set<Integer> pairs = roll.findPairs();
		if (pairs.size() < 2) {
			return 0;
		}
		return pairs.stream().map(d -> d * 2).reduce(0, Integer::sum);
	}

	public static int threeOfAkind(Roll roll) {
		return roll.getDiceWithCountGreaterThan(3) * 3;
	}

	public static int fourOfAkind(Roll roll) {
		return roll.getDiceWithCountGreaterThan(4) * 4;
	}

	public static int smallStraight(Roll roll) {
		if (roll.isSmallStraight()) {
			return 15;
		}
		return 0;
	}

	public static int largeStraight(Roll roll) {
		if (roll.isLargeStraight()) {
			return 20;
		}
		return 0;
	}

	public static int fullHouse(Roll roll) {
		if (roll.isFullHouse()) {
			return roll.sum();
		}
		return 0;
	}
}
