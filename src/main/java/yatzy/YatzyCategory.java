package yatzy;

import java.util.function.Function;

public enum YatzyCategory {

	CHANCE(YatzyScore::chance),
	YATZY(YatzyScore::yatzy), 
	ONES(YatzyScore::ones), 
	TWOS(YatzyScore::twos), 
	THREES(YatzyScore::threes),
	FOURS(YatzyScore::fours), 
	FIVES(YatzyScore::fives), 
	SIXES(YatzyScore::sixes), 
	ONE_PAIR(YatzyScore::onePair), 
	TWO_PAIRS(YatzyScore::twoPair),
	THREE_OF_A_KIND(YatzyScore::threeOfAkind),
	FOUR_OF_A_KIND(YatzyScore::fourOfAkind),
	SMALL_STRAIGHT(YatzyScore::smallStraight),
	LARGE_STRAIGHT(YatzyScore::largeStraight), 
	FULL_HOUSE(YatzyScore::fullHouse);

	private Function<Roll, Integer> score;
	
	YatzyCategory(Function<Roll, Integer> score) {
		this.score = score;
	}

	public int score(Roll roll) {
		return this.score.apply(roll);
	}
}
