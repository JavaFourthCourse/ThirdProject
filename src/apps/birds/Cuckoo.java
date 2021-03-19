package apps.birds;

class Cuckoo extends Bird
{
	public Cuckoo()
	{
		super("Кукушка");
	}
	
	@Override
	public void fly()
	{
		System.out.println("Кукушка летит");
	}
	
	@Override
	public void sing()
	{
		System.out.println("Ку-ку");
	}
	
	@Override
	public void layEggs()
	{
		System.out.println("Кукушка подбросила яйца другой птице");
	}
}
