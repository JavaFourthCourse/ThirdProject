package apps.files;

public class Directory
{
	private String path;
	private String name;
	
	public Directory(String path)
	{
		if (path.indexOf('\\') != -1)
		{
			this.path = path.substring(0, path.lastIndexOf('\\'));
			name = path.substring(path.indexOf('\\') + 1);
		}
		else
		{
			this.path = "";
			name = path;
		}
	}
	
	public void setPath(String path)
	{
		this.path = path;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getPath()
	{
		return path;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean isEmpty()
	{
		return path.isEmpty() && name.isEmpty();
	}
	
	@Override
	public String toString()
	{
		return path.isEmpty() ? name : path + '\\' + name;
	}
}
