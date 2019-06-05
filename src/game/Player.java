package game;

/*
Needham Burn:Zap-4,Zap and Tap-4,Sparkwave-4,Giga Zap-4,Comeback Zap-4,Mend-4,Handy Robot-3,Wicked Robot-2,Zapstarter-1/Body Swap Anti Burn:Heal-3,Mulch Munch-3,Ignite-3,Tempo Drain-3,Wicked Robot-2,Sparkwave-2,Zapstarter-2,Body Swap-2,Comeback Zap-2,Giga Zap-2,Burial-2,Life Zap-2,Eternal Herb-2/Dark x Light:Zap-3,Mulch Munch-3,Dark Zap-3,Amnesia-3,Peace Treaty-2,Zapstarter-2,Body Swap-2,Sinkhole-2,Mend-2,The Rack-2,Zap and Tap-2,Sycamore-2,Parry-2/Peaceful Waifu:Peace Treaty-4,Waifu-4,Repair-4,Donate-3,Mill-3,Grindstone-1,Charged Laser-1,Mighty Wrench-1,Sparkwave-1,Zap-1,Body Swap-1,Increasing Heal-1,Dark Zap-1,Dark Contract-1,Locke-1,Eventual Zap-1,Damnation-1/Healer Demon:Increasing Heal-4,Greater Demon-4,Eventual Zap-4,Damnation-4,Vitality Artifact-3,Gesper-2,Lesser Demon-1,Mass Grave-1,Mend-1,Mulch Munch-1,Eternal Herb-1,Burst Heal-1,Ignite-1,Amnesia-1,Parry-1/Peace Treaty:Mend-4,Grindstone-2,Peace Treaty-4,Wicked Robot-2,Damnation-3,Junk Chucker-1,Dark Zap-3,Handy Robot-2,Apparition-2,Mill-3,Tempo Drain-2,Corporate Shredder-2/Seemingly Good Random:Ignite-3,Grindstone-2,Zap-2,Zapstarter-2,Poison Frog-2,Sinkhole-2,Mend-2,Regrow-2,Life Zap-2,Mulch Munch-2,Handy Robot-2,Mill-2,Amnesia-2,Colossal Junk Chucker-2,Parry-1/Burst Transfusion:Mulch Munch-3,Damnation-3,Doomsday Device-3,Peace Treaty-2,Robot Assassin-2,Dark Pact-2,Comeback Zap-2,Dark Transfusion-2,Vitality Artifact-3,Handy Robot-2,Zap Magnifier-2,Burst Heal-2,Apparition-2/Assassin Burn:Zap-4,Giga Zap-4,Ignite-4,Robot Assassin-4,Mill-4,Grindstone-4,Amnesia-4,The Rack-2/Big Draw Doomsday:Sycamore-4,Doomsday Device-3,Corporate Shredder-3,Tempo Drain-3,Robot Assassin-2,Heal-2,Comeback Zap-2,Giga Zap-2,Time Stop-2,Dark Zap-2,Ignite-2,Colossal Junk Chucker-2,Body Swap-1/Steve's Storm:Handy Robot-4,Eternal Flame-3,Ancestral Recall-4,Royal Robot-4,Vitality Artifact-3,Recycle-4,Timetwister-4,Dark Contract-2,Damnation-2/Eternal Mill:Grindstone-4,Eternal Herb-4,Parry-3,Life Zap-2,Handy Robot-2,Mill-4,Heal-3,Regrow-3,Thought Scour-3,Burial-2/Frog Loaf:Poison Frog-4,Tasty Bread-4,Slow Flare-4,Damnation-4,Parry-3,Peace Treaty-1,Royal Robot-1,Mass Grave-1,Sinkhole-1,Heal-1,Junk Chucker-1,Checkmate-1,Handy Robot-1,Sycamore-1,Repair-1,Pylon-1/Dredge Slayer:Timetwister-3,Corporate Shredder-3,Mend-3,Mulch Munch-3,Handy Robot-3,Poison Frog-2,Sinkhole-2,The Rack-2,Burial-2,Sycamore-2,Apparition-2,Mill-2,Grindstone-1/Dark.dek:Poison Frog-4,Dark Transfusion-4,Corporate Shredder-2,Donate-3,Junk Chucker-4,Dark Pact-4,Comeback Zap-1,The Rack-2,Giga Zap-2,Handy Robot-2,Apparition-1,Damnation-1/Handy Shredder:Handy Robot-4,Corporate Shredder-4,Zap and Tap-3,Mend-3,Regrow-3,Burial-2,Cowardly Robot-2,Apparition-2,Comeback Zap-2,Parry-2,Tempo Drain-2,Peace Treaty-1/The Uncounterable:Grindstone-3,Burial-3,Corporate Shredder-2,Wicked Robot-2,Body Swap-2,The Rack-2,Comeback Zap-2,Ancestral Recall-2,Giga Zap-2,Mulch Munch-2,Life Zap-2,Mill-2,Amnesia-2,Damnation-2/Dredge:Gesper-4,Mend-4,Thought Scour-4,Cowardly Robot-4,Grindstone-4,Eternal Herb-4,Poison Frog-2,The Rack-4/Corrupted Blood:Dark Transfusion-4,Dark Zap-4,Search the Darkness-2,Dark Pact-1,Wicked Robot-2,Handy Robot-3,Amnesia-3,Tempo Drain-2,Charged Laser-2,Mend-4,Timetwister-3/Corporate Peace Frog:Corporate Shredder-4,Poison Frog-4,Zap-3,Wicked Robot-3,Peace Treaty-2,Heal-2,Comeback Zap-2,The Rack-2,Handy Robot-3,Eternal Herb-2,Mill-3/Steve's Transfusion Stall:Dark Transfusion-4,Waifu-3,Mend-3,Remembrance-3,Eternal Herb-4,Vitality Artifact-3,Apparition-2,Heal-2,Time Stop-2,Burst Heal-4/Junky Pylons:Junk Hunter-4,Donate-4,Pylon-4,Regrow-3,Vitality Artifact-3,Junk Chucker-2,Royal Robot-1,Dark Pact-1,Mend-1,Remembrance-1,The Rack-1,Dark Transfusion-1,Giga Zap-1,Eternal Herb-1,Recycle-1,Tempo Drain-1/Wicked Robot Control:Wicked Robot-3,Thought Scour-2,Gesper-2,Zap-2,Poison Frog-2,Mend-2,Junk Chucker-2,The Rack-2,Ancestral Recall-2,Mulch Munch-2,Zap and Tap-2,Handy Robot-2,Eternal Herb-2,Tempo Drain-2,Comeback Zap-1/Turbo Discard:Tempo Drain-4,Amnesia-4,Poison Frog-4,Burial-4,The Rack-4,Locke-3,Damnation-3,Wicked Robot-3,Ancestral Recall-1/Jund:Poison Frog-4,Accumulated Knowledge-3,Giga Zap-3,Sparkwave-2,Mulch Munch-2,Burial-2,Eternal Herb-2,Sycamore-2,Cowardly Robot-4,Dark Zap-4,Damnation-2/Oddity:Amnesia-1,Apparition-1,Checkmate-1,Damnation-4,Dark Transfusion-1,Gesper-1,Giga Zap-1,Handy Robot-1,Heal-1,Locke-1,Mass Grave-1,Mill-1,Mulch Munch-4,Poison Frog-1,Repair-4,Robot Assassin-1,Royal Robot-1,Sinkhole-3,Zap and Tap-1/Robot Pigeon:Robot Assassin-4,Tasty Bread-4,Damnation-4,Accumulated Knowledge-3,Channel the Depths-3,Checkmate-2,Thought Scour-1,Charged Laser-1,Peace Treaty-1,Royal Robot-1,Dark Pact-1,Increasing Heal-1,Eternal Herb-1,Mill-1,Eventual Zap-1,Colossal Junk Chucker-1/Pylon Alignment:Pylon-4,Sycamore-4,Mend-4,Thought Scour-4,Handy Robot-4,Eternal Herb-4,Gesper-4,Apparition-2/Doomsday Combo:Robot Assassin-4,Doomsday Device-3,Corporate Shredder-3,Peace Treaty-3,Poison Frog-3,Sycamore-2,Donate-2,Body Swap-2,Sinkhole-2,Comeback Zap-2,Colossal Junk Chucker-2,Tempo Drain-2/Steve's Stall:Grindstone-4,Damnation-3,Heal-4,Tent-4,Heal-3,Tempo Drain-2,Corporate Shredder-2,Eternal Herb-4,Burst Heal-4/Adam Lifegain:Eternal Herb-4,Sycamore-2,Accumulated Knowledge-4,Junk Chucker-4,Handy Robot-2,Sinkhole-4,Colossal Junk Chucker-2,Mend-4,Mulch Munch-4/Doomsday Stall:Doomsday Device-3,Charged Laser-3,Colossal Junk Chucker-3,Parry-3,Thought Scour-2,Sparkwave-2,Heal-2,Ancestral Recall-2,Slow Flare-2,Eternal Herb-2,Cowardly Robot-2,Amnesia-2,Tempo Drain-2/Assassin Control:Robot Assassin-3,Damnation-3,Grindstone-2,Peace Treaty-2,Sparkwave-2,Wicked Robot-2,The Rack-2,Dark Transfusion-2,Mulch Munch-2,Donate-2,Dark Zap-2,Waifu-2,Colossal Junk Chucker-2,Channel the Depths-2/Damn Peaceful:Mend-4,Grindstone-3,Peace Treaty-4,Wicked Robot-1,Damnation-3,Zap-4,Handy Robot-2,Giga Zap-2,Mill-3,Tempo Drain-2,Corporate Shredder-2/Waifu Control:Apparition-3,Dark Pact-2,The Rack-2,Junk Chucker-2,Comeback Zap-2,Dark Transfusion-3,Zap and Tap-2,Burial-2,Mulch Munch-2,Waifu-3,Colossal Junk Chucker-2,Tempo Drain-2,Damnation-3/Burn Slayer:Zap-4,Heal-4,Sparkwave-4,Giga Zap-4,Comeback Zap-4,Mend-4,Handy Robot-3,Wicked Robot-2,Zapstarter-1/Zap Magnifier:Zap Magnifier-4,Zap-4,Dark Zap-4,Zap Cannon-4,Eventual Zap-4,Ancestral Recall-3,Waifu-3,Life Zap-4/Burial Mill:Burial-4,Wicked Robot-4,Amnesia-3,Grindstone-4,Miller-1,Recycle-1,Apparition-2,Vitality Artifact-2,Eternal Flame-1,Handy Robot-4,Ancestral Recall-4
 */

import java.util.ArrayList;
import java.util.Collections;

import extraData.Card;

public class Player {

	Deck deck = new Deck();
	ArrayList<Card> hand = new ArrayList<Card>();
	public ArrayList<Card> grave = new ArrayList<Card>();
	public ArrayList<Card> rfg = new ArrayList<Card>();
	String name;
	public int maxLifeTotal = 30;
	public int lifeTotal;
	public int playsPerTurn = 2;
	public int fatigue = 1;

	public Player(String newName) {
		name = newName;
		lifeTotal = maxLifeTotal;
	}

	public ArrayList<Card> getDeck() {
		return deck.cards;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public ArrayList<Card> getGrave() {
		return grave;
	}

	public void setGrave(ArrayList<Card> grave) {
		this.grave = grave;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void draw() {
		if (deck.size() > 0) {
			Card c = deck.remove(0);
			c.whenDrawn(this);
			hand.add(c);
		} else {
			this.lifeTotal = lifeTotal - fatigue;
			fatigue++;
		}
	}

	public void shuffle() {
		deck.shuffle();
	}

	public void randomDiscard() {
		if (hand.size() > 0) {
			Collections.shuffle(hand);
			grave.add(hand.remove(0));
		}
	}

	public void millX(int x) {
		for (int i = 0; i < x; i++) {
			if (deck.size() > 0) {
				grave.add(deck.remove(0));
			}
		}
	}

	public void add(Card c) {
		deck.add(c);
	}

	public void drawX(int x) {
		for (int i = 0; i < x; i++) {
			draw();
		}
	}

	public boolean isAlive() {
		return lifeTotal > 0;
	}

	public void makePlay(Player opponent, Boolean debug) {
		if (hand.size() > 0) {
			Collections.shuffle(hand);
			Card c = hand.remove(0);
			grave.add(c);
			c.onentry(this, opponent);
			c.afterResolving(this, opponent);
			if (debug) {
				debug(this.name + " casts " + c.getName() + ". (" + lifeTotal + ")-(" + opponent.getLife() + ")");
			}
		}
	}

	private static void debug(String string) {
		System.out.println(string);
	}

	public void cleanup() {
		this.deck.addAll(this.grave);
		this.grave.clear();
		this.deck.addAll(this.rfg);
		this.rfg.clear();
		this.deck.addAll(this.hand);
		this.hand.clear();
		this.deck.remove("Corrupted Blood");
		this.deck.remove("Holy Grail");
		this.deck.remove("Cable");
		this.deck.remove("Pigeon");
		this.deck.remove("Copycard");
		this.fatigue = 1;
		for (Card c : this.getDeck()) {
			c.setCounters(0);
		}
		this.lifeTotal = 30;

	}

	public int getLife() {
		return lifeTotal;
	}

	public int cardCount(ArrayList<Card> grave2, String string) {
		int i = 0;
		for (Card cs : grave2) {
			if (cs.getName().equals(string)) {
				i++;
			}
		}
		return i;
	}

	public void movePile(ArrayList<Card> targetPile, ArrayList<Card> sourcePile) {
		targetPile.addAll(sourcePile);
		sourcePile.clear();
	}

	public void rfgFromDeck(int x) {
		for (int i = 0; i < x; i++) {
			if (getDeck().size() > 0) {
				rfg.add(getDeck().remove(0));
			}
		}
	}

	public Card rfgTop() {
		if (getDeck().size() > 0) {
			Card c = getDeck().remove(0);
			rfg.add(c);
			return c;
		}
		return null;
	}

	public String showDecklist() {
		ArrayList<String> cards = new ArrayList<String>();
		for (Card c : getDeck()) {
			cards.add(c.getName());
		}
		Collections.sort(cards);
		return cards.toString();
	}
}
