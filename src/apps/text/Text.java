package apps.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Text
{
	private final List<Sentence> sentences;
	private String heading;
	
	public Text()
	{
		sentences = new ArrayList<>();
		heading = "";
	}
	
	public Text(String heading, Sentence... sentences)
	{
		this.sentences = new ArrayList<>();
		this.heading = heading;
		
		this.sentences.addAll(Arrays.asList(sentences));
	}
	
	public void setHeading(String heading)
	{
		this.heading = heading;
	}
	
	public void addSentence(Sentence sentence)
	{
		sentences.add(sentence);
	}
	
	public void deleteSentence(int index)
	{
		sentences.remove(index);
	}
	
	public void deleteSentence(Sentence sentence)
	{
		sentences.remove(sentence);
	}
	
	public Sentence getSentence(int index)
	{
		return sentences.get(index);
	}
	
	public String getHeading()
	{
		return heading;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder(heading);
		
		builder.append('\n');
		
		for (Sentence sentence : sentences)
		{
			builder.append(sentence).append(' ');
		}
		
		builder.deleteCharAt(builder.length() - 1);
		
		return builder.toString();
	}
	
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
		
		Text text = (Text) o;
		
		return sentences.equals(text.sentences);
	}
	
	@Override
	public int hashCode()
	{
		return sentences.hashCode();
	}
}
