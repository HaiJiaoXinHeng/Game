package space_colonization;

public class BattleSimulator {
	public static void singleBattleSim(ship a, ship b )
	{
		boolean done = false;
		while(!done)
		{
			System.out.println("ship a's HP remaining = " +a.getHP());
			System.out.println("ship b's HP remaining = " + b.getHP());
			if(a.getHP() == 0)
			{
				System.out.println("b wins");
				done = true;
			}
			if(b.getHP() == 0)
			{
				System.out.println("a wins");
				done = true;
			}
			ship.battle(a, b);
		}
		
	}
	public static void flotillaBattleSim(flotilla a, flotilla b )
	{
		int move = 0;
		boolean done = false;
		while(!done)
		{
			move++
			;
			System.out.println("move: " + move);
			System.out.println("ship a's HP remaining = " + a.getHP());
			System.out.println("ship b's HP remaining = " + b.getHP());
			if(a.getHP() == 0)
			{
				System.out.println("b wins");
				done = true;
			}
			if(b.getHP() == 0)
			{
				System.out.println("a wins");
				done = true;
			}
			a.battle(a, b);
		}
		System.out.println("move: " + move);
		
	}
	public static void main(String[] args)
	{
		ship one = new ship("strong");
		one.setEqualStats(179);
		ship two = new ship("weak");
		two.setEqualStats(180);
		singleBattleSim(one, two);
	}
}
