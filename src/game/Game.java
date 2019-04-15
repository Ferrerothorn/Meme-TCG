package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import cards.*;

public class Game {

	public static ArrayList<Player> players = new ArrayList<>();
	public static ArrayList<String> cardPool = new ArrayList<>();

	public static void main(String[] args) {
		instantiateCardpool();
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println("===Choose a command===");
			System.out.println("0: Run randomised tournament.");
			System.out.println("2: Run a multiplayer tournament.");
			System.out.println("5: Compare two decks.");
			System.out.println("6: Compare one deck against a multitude of other decks.");
			System.out.println("7: Generate a 'solution' to a deck.");
			System.out.println("999: Quit.");
			System.out.println();
			int choice = input.nextInt();
			input.nextLine();

			switch (choice) {

			case 0:
				System.out.println("Generating 500k decklists.");
				generateDecklists(500000);
				Collections.shuffle(players);
				System.out.println("Running tournament.");
				while (players.size() > 1) {
					Player p1 = players.remove(0);
					Player p2 = players.remove(0);
					Player winner = play(p1, p2);
					players.add(winner);
				}
				System.out.println(analyseTopCut());
				break;
			case 5:
				System.out
						.println("Enter player 1's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
				String p1info = input.nextLine();
				String[] parsename = p1info.split(":");
				Player p1 = new Player(parsename[0]);
				parseDeckFromLine(p1, parsename[1]);

				System.out
						.println("Enter player 2's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
				String p2info = input.nextLine();
				String[] parsename2 = p2info.split(":");
				Player p2 = new Player(parsename2[0]);
				parseDeckFromLine(p2, parsename2[1]);

				if (p2.getDeck().size() + p1.getDeck().size() != 60) {
					System.out.println("One or more decks isn't correct (@30 cards).");
					System.out.println(p1.name + ": " + p1.getDeck().size());
					System.out.println(p1.name + ": " + p1.showDecklist());
					System.out.println(p2.name + ": " + p2.getDeck().size());
					System.out.println(p2.name + ": " + p2.showDecklist());
					break;
				}
				System.out.println(p1.getName() + " wins " + grindGames(p1, p2, 25000) + "% of games against "
						+ p2.getName() + ".");
				break;

			case 6:
				System.out
						.println("Enter player 1's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
				String bossInfo = input.nextLine();
				String[] parseBossName = bossInfo.split(":");
				Player boss = new Player(parseBossName[0]);
				parseDeckFromLine(boss, parseBossName[1]);

				System.out.println("Enter any number of other decklists in the same format, separated by '/'.");
				String gauntletInfo = input.nextLine();
				System.out.println();
				String[] gauntlet = gauntletInfo.split("/");

				for (String s : gauntlet) {
					String[] parsedNames = s.split(":");
					Player opp = new Player(parsedNames[0]);
					parseDeckFromLine(opp, parsedNames[1]);

					if (boss.getDeck().size() + opp.getDeck().size() != 60) {
						System.out.println("One or more decks isn't correct (@30 cards).");
						System.out.println(boss.name + ": " + boss.getDeck().size());
						System.out.println(opp.name + ": " + opp.getDeck().size());
						break;
					}

					System.out.println(boss.getName() + " wins " + grindGames(boss, opp, 25000) + "% of games against "
							+ opp.getName() + ".");
				}
				break;

			case 7:
				System.out.println(
						"Enter the player+deck intended to beat. (Format should be 'Name:Zap-4,Life Zap-3,...')");
				String bossDeckInfo = input.nextLine();
				String[] parsebossname = bossDeckInfo.split(":");
				Player counterThisDeck = new Player(parsebossname[0]);
				parseDeckFromLine(counterThisDeck, parsebossname[1]);

				generateDecklists(1);
				int winrate = 0;
				while (winrate < 75) {
					players.clear();
					generateDecklists(1);
					winrate = grindGames(players.get(0), counterThisDeck, 3000);
					System.gc();
					if (winrate > 55) {
						System.out.println(winrate + ":" + analyseTopCut());
					}
				}
				System.out.println();
				break;

			case 999:
				input.close();
				System.exit(0);
				break;
			}
		}

	}

	private static int grindGames(Player p1, Player p2, int bestOf) {
		int p1winrate = 0;
		for (int i = 0; i < (bestOf / 2); i++) {
			if (play(p1, p2).equals(p1)) {
				p1winrate++;
			}
			p1.cleanup();
			p2.cleanup();
			if (play(p2, p1).equals(p1)) {
				p1winrate++;
			}
		}
		return (100 * p1winrate) / bestOf;
	}

	private static void parseDeckFromLine(Player p1, String p1deck) {
		String[] cards = p1deck.split(",");
		for (String s : cards) {
			String[] cardQty = s.split("-");
			for (int i = Integer.parseInt(cardQty[1]); i > 0; i--) {
				Card c = findCardByName(cardQty[0]);
				p1.getDeck().add(c);
			}
		}
		p1.shuffle();
	}

	private static Card findCardByName(String string) {
		for (String c : cardPool) {
			if (c.equals(string)) {
				return newCardByName(string);
			}
		}
		System.out.println("Can't find a card called: " + string);
		System.exit(0);
		return null;
	}

	private static String analyseTopCut() {
		System.out.println();
		System.out.println();
		HashMap<String, Integer> topCut = new HashMap<>();
		for (Player p : players) {
			for (Card c : p.getDeck()) {
				topCut.put(c.getName(), topCut.getOrDefault(c.getName(), 0) + 1);
			}
		}
		topCut = sortByValues(topCut);
		String decklist = "";
		Iterator it = topCut.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			decklist += pair.getKey() + "-" + pair.getValue() + ",";
		}
		return decklist;
	}

	private static HashMap sortByValues(HashMap map) {
		LinkedList list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
			}
		});
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}

	private static Player play(Player p1, Player p2) {
		p1.lifeTotal = 30;
		p2.lifeTotal = 30;
		p1.playsPerTurn = 2;
		p2.playsPerTurn = 2;

		if (p1.deck.cards.size() != 30 || p2.deck.cards.size() != 30) {
			System.out.println("Definitely a problem.");
			System.out.println("P1 deck: " + p1.deck.cards.size());
			System.out.println("P1 deck: " + p1.showDecklist());
			System.out.println("P2 deck: " + p2.deck.cards.size());
			System.out.println("P2 deck: " + p2.showDecklist());
		}
		p1.drawX(5);
		p2.drawX(5);
		while (p1.isAlive() && p2.isAlive()) {
			int p1playsPerTurn = p1.playsPerTurn;
			int p2playsPerTurn = p2.playsPerTurn;
			p1.draw();
			if (!p1.isAlive() || !p2.isAlive()) {
				break;
			}
			while (p1playsPerTurn > 0 && p1.getHand().size() > 0) {
				p1.makePlay(p2);
				p1playsPerTurn--;
				if (!p1.isAlive() || !p2.isAlive()) {
					break;
				}
			}

			ArrayList<Card> triggers = new ArrayList<>();
			triggers.addAll(p1.grave);
			for (Card c : triggers) {
				if (!p2.isAlive() || !p1.isAlive()) {
					break;
				}
				c.graveAbility(p1, p2);
			}
			triggers.clear();

			if (!p1.isAlive() || !p2.isAlive()) {
				break;
			}

			p2.draw();
			if (!p1.isAlive() || !p2.isAlive()) {
				break;
			}
			while (p2playsPerTurn > 0 && p2.getHand().size() > 0) {
				p2.makePlay(p1);
				p2playsPerTurn--;
				if (!p2.isAlive() || !p1.isAlive()) {
					break;
				}
			}
			triggers.addAll(p2.grave);
			for (Card c : triggers) {
				if (!p2.isAlive() || !p1.isAlive()) {
					break;
				}
				c.graveAbility(p2, p1);
			}
			triggers.clear();

			if (!p1.isAlive() || !p2.isAlive()) {
				break;
			}
		}
		if (p1.isAlive()) {
			p1.cleanup();
			p2.cleanup();
			return p1;
		}
		p1.cleanup();
		p2.cleanup();
		return p2;
	}

	private static void generateDecklists(int i) {
		for (int ps = 0; ps < i; ps++) {
			Player p = new Player("");
			while (p.getDeck().size() < 30) {
				Collections.shuffle(cardPool);
				String s = cardPool.get(0);
				Card c = findCardByName(s);
				if (cardCount(p.getDeck(), c.getName()) < 4) {
					p.getDeck().add(c);
				}
				if (cardCount(p.getDeck(), c.getName()) < 2 && p.getDeck().size() < 30) {
					p.getDeck().add(c);
				}
			}
			players.add(p);
		}
	}

	private static int cardCount(ArrayList<Card> deck, String name) {
		int i = 0;
		for (Card cs : deck) {
			if (cs.getName().equals(name)) {
				i++;
			}
		}
		return i;
	}

	private static void instantiateCardpool() {
		cardPool.add("Accumulated Knowledge");
		cardPool.add("Amnesia");
		cardPool.add("Ancestral Recall");
		cardPool.add("Apparition");
		cardPool.add("Body Swap");
		cardPool.add("Burial");
		cardPool.add("Charged Laser");
		cardPool.add("Colossal Junk Chucker");
		cardPool.add("Comeback Zap");
		cardPool.add("Corporate Shredder");
		cardPool.add("Cowardly Robot");
		cardPool.add("Damnation");
		cardPool.add("Dark Pact");
		cardPool.add("Dark Transfusion");
		cardPool.add("Dark Zap");
		cardPool.add("Donate");
		cardPool.add("Eternal Herb");
		cardPool.add("Gesper");
		cardPool.add("Giga Zap");
		cardPool.add("Grindstone");
		cardPool.add("Handy Robot");
		cardPool.add("Heal");
		cardPool.add("Ignite");
		cardPool.add("Junk Chucker");
		cardPool.add("Junk Hunter");
		cardPool.add("Life Zap");
		cardPool.add("Mend");
		cardPool.add("Mill");
		cardPool.add("Mulch Munch");
		cardPool.add("Parry");
		cardPool.add("Peace Treaty");
		cardPool.add("Poison Frog");
		cardPool.add("Regrow");
		cardPool.add("Robot Assassin");
		cardPool.add("Search the Darkness");
		cardPool.add("Sinkhole");
		cardPool.add("Sparkwave");
		cardPool.add("Sycamore");
		cardPool.add("Tempo Drain");
		cardPool.add("The Rack");
		cardPool.add("Thought Scour");
		cardPool.add("Timetwister");
		cardPool.add("Waifu");
		cardPool.add("Wicked Robot");
		cardPool.add("Zap");
		cardPool.add("Zap and Tap");
		cardPool.add("Zapstarter");
	}

	private static Card newCardByName(String string) {
		switch (string) {
		case "Accumulated Knowledge":
			return new AccumulatedKnowledge();
		case "Amnesia":
			return new Amnesia();
		case "Ancestral Recall":
			return new AncestralRecall();
		case "Apparition":
			return new Apparition();
		case "Body Swap":
			return new BodySwap();
		case "Burial":
			return new Burial();
		case "Charged Laser":
			return new ChargedLaser();
		case "Colossal Junk Chucker":
			return new ColossalJunkChucker();
		case "Comeback Zap":
			return new ComebackZap();
		case "Corporate Shredder":
			return new CorporateShredder();
		case "Cowardly Robot":
			return new CowardlyRobot();
		case "Damnation":
			return new Damnation();
		case "Dark Pact":
			return new DarkPact();
		case "Dark Transfusion":
			return new DarkTransfusion();
		case "Dark Zap":
			return new DarkZap();
		case "Donate":
			return new Donate();
		case "Eternal Herb":
			return new EternalHerb();
		case "Gesper":
			return new Gesper();
		case "Giga Zap":
			return new GigaZap();
		case "Grindstone":
			return new Grindstone();
		case "Handy Robot":
			return new HandyRobot();
		case "Heal":
			return new Heal();
		case "Ignite":
			return new Ignite();
		case "Junk Chucker":
			return new JunkChucker();
		case "Junk Hunter":
			return new JunkHunter();
		case "Life Zap":
			return new Lifezap();
		case "Mend":
			return new Mend();
		case "Mill":
			return new Mill();
		case "Mulch Munch":
			return new MulchMunch();
		case "Parry":
			return new Parry();
		case "Peace Treaty":
			return new PeaceTreaty();
		case "Poison Frog":
			return new PoisonFrog();
		case "Regrow":
			return new Regrow();
		case "Robot Assassin":
			return new RobotAssassin();
		case "Search the Darkness":
			return new SearchTheDarkness();
		case "Sinkhole":
			return new Sinkhole();
		case "Sparkwave":
			return new Sparkwave();
		case "Sycamore":
			return new Sycamore();
		case "Tempo Drain":
			return new TempoDrain();
		case "The Rack":
			return new TheRack();
		case "Thought Scour":
			return new ThoughtScour();
		case "Timetwister":
			return new Timetwister();
		case "Waifu":
			return new Waifu();
		case "Wicked Robot":
			return new WickedRobot();
		case "Zap":
			return new Zap();
		case "Zap and Tap":
			return new ZapAndTap();
		case "Zapstarter":
			return new Zapstarter();
		default:
			return new CorruptedBlood();
		}
	}
}
