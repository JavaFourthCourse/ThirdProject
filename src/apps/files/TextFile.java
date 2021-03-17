package apps.files;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import apps.text.Sentence;
import apps.text.Word;

public class TextFile extends File
{
	public TextFile(Directory path, String name)
	{
		super(path, name, "txt");
	}
	
	@Override
	public int append(byte[] bytes)
	{
		try
		{
			Files.write(systemRepresentation.getAbsoluteFile().toPath(), bytes, StandardOpenOption.APPEND);
			
			return bytes.length;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			
			return 0;
		}
	}
	
	public int append(Sentence sentence)
	{
		return this.append(sentence.toString().getBytes(StandardCharsets.UTF_8));
	}
	
	public int append(Word word)
	{
		return this.append(word.toString().getBytes(StandardCharsets.UTF_8));
	}
	
	@Override
	public String toString()
	{
		try
		{
			FileReader reader = new FileReader(systemRepresentation);
			long size = Files.size(Paths.get(systemRepresentation.getAbsolutePath()));
			char[] data = new char[(int) size];
			
			reader.read(data, 0, (int) size);
			
			reader.close();
			
			return new String(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			
			return "";
		}
	}
}
