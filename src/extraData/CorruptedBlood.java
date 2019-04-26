package extraData;

import java.util.Collections;

import game.Player;

public class CorruptedBlood extends Card {

	public CorruptedBlood() {
		this.name = "Corrupted Blood";
	}

	@Override
	public void onentry(Player self, Player opponent) {

		self.getDeck().add(new CorruptedBlood());
		self.getDeck().add(new CorruptedBlood());
		self.lifeTotal -= (fibonacci((self.cardCount(self.getDeck(), "Corrupted Blood") / 2) + 1));

		self.draw();
		Collections.shuffle(self.getDeck());
	}

	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;

		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

}
