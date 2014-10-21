package space_colonization;

public class flotilla_creator {
	private static shipFactory first;
	private int money;
	private int people;
	private double baseX;
	private double baseY;
	public flotilla_creator()
	{
		money = 10000000;
		people = 1000000;
		first = new shipFactory(money, people, baseX, baseY);
	}
	public flotilla_creator(int Money, int People, double x, double y)
	{
		first = new shipFactory(Money, People, x, y);
		money = Money;
		people = People;
		baseX = x;
		baseY = y;
	}
	public void addPeople(int addedPeople)
	{
		people = people + addedPeople;
	}
	public void addMoney(int addedMoney)
	{
		money = money + addedMoney;
	}
	public static flotilla createBaseFlotilla(int fighters, int frigate, int cruiser, 
			 String Type, int level)//consists of one capital ship and an amount of fighters
	{
		flotilla one = new flotilla();
		ship bigest = new Specific_Ship("Capital", Type, level);
		ship small = new Specific_Ship("Fighter", Type, level);
		ship big = new Specific_Ship("Frigate", Type, level);
		ship biger = new Specific_Ship("Cruiser", Type, level);
		first.produceShip(bigest, one);
		for(int i = 0; i < fighters; i++)
		{
			first.produceShip(small, one);
		}
		for(int i = 0; i < frigate; i++)
		{
			first.produceShip(big, one);
		}
		for(int i = 0; i < cruiser; i++)
		{
			first.produceShip(biger, one);
		}
		return one;
	}
	public static flotilla[] createFleet(String type, int flotillas)
	{
		flotilla[] one = new flotilla[126];
		flotilla two = createBaseFlotilla(100, 5, 20, type, 1);
		for(int i = 0; i < flotillas; i++)
		{
			one[i] = two;
		}
		return one;
	}

}
