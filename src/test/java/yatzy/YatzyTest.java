package yatzy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class YatzyTest {

	@Test
	public void chance() {
		assertEquals(15, YatzyCategory.CHANCE.score((new Roll(2, 3, 4, 5, 1))));
		assertEquals(16, YatzyCategory.CHANCE.score(new Roll(3, 3, 4, 5, 1)));
	}

	@Test
	public void yatzy() {
		assertEquals(50, YatzyCategory.YATZY.score(new Roll(4, 4, 4, 4, 4)));
		assertEquals(50, YatzyCategory.YATZY.score(new Roll(6, 6, 6, 6, 6)));
		assertEquals(0, YatzyCategory.YATZY.score(new Roll(6, 6, 6, 6, 3)));
	}

	@Test
	public void ones() {
		assertEquals(1, YatzyCategory.ONES.score(new Roll(1, 2, 3, 4, 5)));
		assertEquals(2, YatzyCategory.ONES.score(new Roll(1, 2, 1, 4, 5)));
		assertEquals(0, YatzyCategory.ONES.score(new Roll(6, 2, 2, 4, 5)));
		assertEquals(4, YatzyCategory.ONES.score(new Roll(1, 2, 1, 1, 1)));
	}

	@Test
	public void twos() {
		assertEquals(4, YatzyCategory.TWOS.score(new Roll(1, 2, 3, 2, 6)));
		assertEquals(10, YatzyCategory.TWOS.score(new Roll(2, 2, 2, 2, 2)));
		assertEquals(0, YatzyCategory.TWOS.score(new Roll(5, 5, 5, 5, 5)));

	}

	@Test
	public void threes() {
		assertEquals(6, YatzyCategory.THREES.score(new Roll(1, 2, 3, 2, 3)));
		assertEquals(12, YatzyCategory.THREES.score(new Roll(2, 3, 3, 3, 3)));
		assertEquals(0, YatzyCategory.THREES.score(new Roll(5, 5, 5, 5, 5)));

	}

	@Test
	public void fours() {
		assertEquals(12, YatzyCategory.FOURS.score(new Roll(4, 4, 4, 5, 5)));
		assertEquals(8, YatzyCategory.FOURS.score(new Roll(4, 4, 5, 5, 5)));
		assertEquals(4, YatzyCategory.FOURS.score(new Roll(4, 5, 5, 5, 5)));
		assertEquals(0, YatzyCategory.FOURS.score(new Roll(5, 5, 5, 5, 5)));
	}

	@Test
	public void fives() {
		assertEquals(10, YatzyCategory.FIVES.score(new Roll(4, 4, 4, 5, 5)));
		assertEquals(15, YatzyCategory.FIVES.score(new Roll(4, 4, 5, 5, 5)));
		assertEquals(20, YatzyCategory.FIVES.score(new Roll(4, 5, 5, 5, 5)));
		assertEquals(0, YatzyCategory.FIVES.score(new Roll(1, 1, 1, 1, 1)));
	}

	@Test
	public void sixes() {
		assertEquals(0, YatzyCategory.SIXES.score(new Roll(4, 4, 4, 5, 5)));
		assertEquals(6, YatzyCategory.SIXES.score(new Roll(4, 4, 6, 5, 5)));
		assertEquals(18, YatzyCategory.SIXES.score(new Roll(6, 5, 6, 6, 5)));
	}

	@Test
	public void onePair() {
		assertEquals(6, YatzyCategory.ONE_PAIR.score(new Roll(3, 4, 3, 5, 6)));
		assertEquals(10, YatzyCategory.ONE_PAIR.score(new Roll(5, 3, 3, 3, 5)));
		assertEquals(12, YatzyCategory.ONE_PAIR.score(new Roll(5, 3, 6, 6, 5)));
		assertEquals(2, YatzyCategory.ONE_PAIR.score(new Roll(1, 1, 1, 1, 1)));
		assertEquals(0, YatzyCategory.ONE_PAIR.score(new Roll(1, 2, 3, 4, 5)));
	}

	@Test
	public void twoPairs() {
		assertEquals(16, YatzyCategory.TWO_PAIRS.score(new Roll(3, 3, 5, 4, 5)));
		assertEquals(16, YatzyCategory.TWO_PAIRS.score(new Roll(3, 3, 5, 5, 5)));
		assertEquals(0, YatzyCategory.TWO_PAIRS.score(new Roll(1, 1, 1, 1, 1)));
		assertEquals(0, YatzyCategory.TWO_PAIRS.score(new Roll(1, 1, 5, 1, 1)));
	}

	@Test
	public void threeOfAkind() {
		assertEquals(9, YatzyCategory.THREE_OF_A_KIND.score(new Roll(3, 3, 3, 4, 5)));
		assertEquals(15, YatzyCategory.THREE_OF_A_KIND.score(new Roll(5, 3, 5, 4, 5)));
		assertEquals(9, YatzyCategory.THREE_OF_A_KIND.score(new Roll(3, 3, 3, 3, 5)));
		assertEquals(9, YatzyCategory.THREE_OF_A_KIND.score(new Roll(3, 3, 3, 3, 3)));
		assertEquals(0, YatzyCategory.THREE_OF_A_KIND.score(new Roll(1, 2, 2, 3, 3)));
	}

	@Test
	public void fourOfAKind() {
		assertEquals(12, YatzyCategory.FOUR_OF_A_KIND.score(new Roll(3, 3, 3, 3, 5)));
		assertEquals(20, YatzyCategory.FOUR_OF_A_KIND.score(new Roll(5, 5, 5, 4, 5)));
		assertEquals(0, YatzyCategory.FOUR_OF_A_KIND.score(new Roll(1, 5, 5, 4, 5)));
	}

	@Test
	public void smallStraight() {
		assertEquals(15, YatzyCategory.SMALL_STRAIGHT.score(new Roll(1, 2, 3, 4, 5)));
		assertEquals(15, YatzyCategory.SMALL_STRAIGHT.score(new Roll(2, 3, 4, 5, 1)));
		assertEquals(15, YatzyCategory.SMALL_STRAIGHT.score(new Roll(5, 3, 4, 2, 1)));
		assertEquals(15, YatzyCategory.SMALL_STRAIGHT.score(new Roll(3, 5, 4, 1, 2)));
		assertEquals(0, YatzyCategory.SMALL_STRAIGHT.score(new Roll(1, 2, 2, 4, 5)));
	}

	@Test
	public void largeStraight() {
		assertEquals(20, YatzyCategory.LARGE_STRAIGHT.score(new Roll(6, 2, 3, 4, 5)));
		assertEquals(20, YatzyCategory.LARGE_STRAIGHT.score(new Roll(2, 3, 4, 5, 6)));
		assertEquals(0, YatzyCategory.LARGE_STRAIGHT.score(new Roll(1, 2, 2, 4, 5)));
	}

	@Test
	public void fullHouse() {
		assertEquals(18, YatzyCategory.FULL_HOUSE.score(new Roll(6, 2, 2, 2, 6)));
		assertEquals(0, YatzyCategory.FULL_HOUSE.score(new Roll(2, 3, 4, 5, 6)));
		assertEquals(0, YatzyCategory.FULL_HOUSE.score(new Roll(2, 2, 2, 2, 2)));
	}
}
