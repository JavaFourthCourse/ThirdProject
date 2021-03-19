package apps.birds;

public abstract class Bird
{
	protected String name;
	
	public Bird(String name)
	{
		this.name = name;
	}
	
	public abstract void fly();
	
	public abstract void sing();
	
	public abstract void layEggs();
	
	public final void setName(String name)
	{
		this.name = name;
	}
	
	public final String getName()
	{
		return name;
	}
	
	@Override
	public final boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		
		Bird bird = (Bird) o;
		
		return name.equals(bird.name);
	}
	
	@Override
	public int hashCode()
	{
		return name.hashCode();
	}
	
	@Override
	public final String toString()
	{
		return name;
	}
}