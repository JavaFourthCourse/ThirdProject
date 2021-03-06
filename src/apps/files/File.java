package apps.files;

import java.io.Closeable;
import java.io.IOException;

public abstract class File
{
	protected String name;
	protected Directory path;
	protected String extension;
	protected java.io.File systemRepresentation;
	
	private void initSystemRepresentation()
	{
		if (path.isEmpty())
		{
			systemRepresentation = new java.io.File(name + '.' + extension);
		}
		else
		{
			systemRepresentation = new java.io.File(path.toString() + '\\' + name + '.' + extension);
		}
	}
	
	public File(Directory path, String name, String extension)
	{
		this.path = path;
		this.name = name;
		this.extension = extension;
		
		this.initSystemRepresentation();
	}
	
	public void setName(String name)
	{
		this.name = name;
		
		this.initSystemRepresentation();
	}
	
	public void setPath(Directory path)
	{
		this.path = path;
		
		this.initSystemRepresentation();
	}
	
	public void setExtension(String extension)
	{
		this.extension = extension;
		
		this.initSystemRepresentation();
	}
	
	public String getName()
	{
		return name;
	}
	
	public Directory getPath()
	{
		return path;
	}
	
	public String getExtension()
	{
		return extension;
	}
	
	public void createFile() throws IOException
	{
		systemRepresentation.createNewFile();
	}
	
	public void rename(String newName) throws IOException
	{
		java.io.File newFile = new java.io.File(path.toString() + '\\' + newName + '.' + extension);
		
		if (newFile.exists())
		{
			throw new IOException("Файл с таким именем уже существует");
		}
		
		name = newName;
		
		systemRepresentation.renameTo(newFile);
	}
	
	abstract public int append(byte[] bytes);
	
	public boolean delete()
	{
		if (systemRepresentation.exists())
		{
			return systemRepresentation.delete();
		}
		
		return false;
	}
	
	public abstract String toString();
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		
		File file = (File) o;
		
		if (!name.equals(file.name))
		{
			return false;
		}
		if (!path.equals(file.path))
		{
			return false;
		}
		if (!extension.equals(file.extension))
		{
			return false;
		}
		
		return systemRepresentation.equals(file.systemRepresentation);
	}
	
	@Override
	public int hashCode()
	{
		int result = name.hashCode();
		result = 31 * result + path.hashCode();
		result = 31 * result + extension.hashCode();
		result = 31 * result + systemRepresentation.hashCode();
		return result;
	}
}
