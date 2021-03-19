package apps.birds;

public class BroodHen extends Bird implements HatchingChicks
{
	public BroodHen()
	{
		super("Наседка");
	}
	
	@Override
	public void fly()
	{
		System.out.println("Курица летит на небольшое расстояние");
	}
	
	@Override
	public void sing()
	{
		System.out.println("Кудахчет");
	}
	
	@Override
	public void layEggs()
	{
		System.out.println("Курица снесла яйца");
	}
	
	@Override
	public void hatchingChicks()
	{
		System.out.println("Курица высиживает яйца");
	}
}
