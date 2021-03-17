package apps.text;

public class Word
{
	private String letters;
	private String sign;
	
	public Word()
	{
		letters = "";
		sign = "";
	}
	
	public Word(String letters)
	{
		this.letters = letters;
		sign = "";
	}
	
	public Word(String letters, String sign)
	{
		this.letters = letters;
		this.sign = sign;
	}
	
	void setLetter(int index, char letter)
	{
		StringBuilder builder = new StringBuilder(letters);
		
		builder.setCharAt(index, letter);
		
		letters = builder.toString();
	}
	
	public void setSign(String sign)
	{
		this.sign = sign;
	}
	
	char getLetter(int index)
	{
		return letters.charAt(index);
	}
	
	public String getSign()
	{
		return sign;
	}
	
	int length()
	{
		return letters.length();
	}
	
	@Override
	public String toString()
	{
		return sign.length() == 0 ? letters : letters + sign;
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
		
		Word word = (Word) o;
		
		if (!letters.equals(word.letters))
		{
			return false;
		}
		
		return sign.equals(word.sign);
	}
	
	@Override
	public int hashCode()
	{
		int result = letters.hashCode();
		result = 31 * result + sign.hashCode();
		return result;
	}
}
