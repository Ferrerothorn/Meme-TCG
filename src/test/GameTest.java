package test;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import game.Game;
import game.Player;

class GameTest {

	Player p1;
	Player p2;
	
	@Before
	public void setup() {
		p1 = new Player("P1");
		p2 = new Player("P2");
		Game.parseDeckFromLine(p1, "Zaps:Zap-30");
	}
	
	@Test
	void testDeckIsFullOfZaps() {
		p1.draw();
		assertEquals("Zap", p1.getHand().get(0).getName());
		assertEquals(29, p1.getDeck().size());
	}
	
	
	void testDeckLoadsFromString() {
		
	}

}
