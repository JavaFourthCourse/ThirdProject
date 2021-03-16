package apps.text;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sentence
{
	private final List<Word> words;
	private char endOfSentenceSign;
	
	public Sentence()
	{
		this.words = new LinkedList<>();
	}
	
	public Sentence(char endOfSentenceSign, Word... words)
	{
		this.words = new LinkedList<>();
		this.endOfSentenceSign = endOfSentenceSign;
		
		if (words.length != 0)
		{
			words[0].setLetter(0, Character.toUpperCase(words[0].getLetter(0)));
		}
		
		this.words.addAll(Arrays.asList(words));
	}
	
	public void addWord(Word word)
	{
		words.add(word);
	}
	
	public void deleteWord(int index)
	{
		words.remove(index);
	}
	
	public void deleteWord(Word word)
	{
		words.remove(word);
	}
	
	public void setEndOfSentenceSign(char endOfSentenceSign)
	{
		this.endOfSentenceSign = endOfSentenceSign;
	}
	
	public char getEndOfSentenceSign()
	{
		return endOfSentenceSign;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		
		for (Word word : words)
		{
			builder.append(word).append(' ');
		}
		
		builder.setCharAt(builder.length() - 1, endOfSentenceSign);
		
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
		
		Sentence sentence = (Sentence) o;
		
		if (endOfSentenceSign != sentence.endOfSentenceSign)
		{
			return false;
		}
		
		return words.equals(sentence.words);
	}
	
	@Override
	public int hashCode()
	{
		int result = words.hashCode();
		result = 31 * result + (int) endOfSentenceSign;
		return result;
	}
}
