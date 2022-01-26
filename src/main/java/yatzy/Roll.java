package yatzy;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Roll {

	private final List<Integer> dices;

	public Roll(int d1, int d2, int d3, int d4, int d5) {
		this.dices = Arrays.asList(d1, d2, d3, d4, d5);
	}

	public int sum() {
		return dices.stream().reduce(0, Integer::sum);
	}

	public boolean isYatzy() {
		return dices.stream().allMatch(d -> d.equals(dices.get(0)));
	}

	public int sumDicesOf(int dice) {
		return dices.stream().filter(d -> d.equals(dice)).reduce(0, Integer::sum);
	}

	public Set<Integer> findPairs() {
		return dices.stream().filter(d -> (countDiceOf(d) >= 2)).collect(Collectors.toSet());
	}

	public int getDiceWithCountGreaterThan(int dice) {
		return dices.stream().filter(d -> countDiceOf(d) >= dice).findFirst().orElse(0);
	}

	public boolean isSmallStraight() {
		return dices.containsAll(Arrays.asList(1, 2, 3, 4, 5));
	}

	public boolean isLargeStraight() {
		return dices.containsAll(Arrays.asList(2, 3, 4, 5, 6));
	}

	public boolean isFullHouse() {
		return getDiceWithCountGreaterThan(3) != 0 && findPairs().size() == 2;
	}

	private int countDiceOf(int dice) {
		return (int) dices.stream().filter(d -> d.equals(dice)).count();
	}
}
