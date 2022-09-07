package practic;

public class StringReverse 
{
	public static void main(String []agrs)
	{
	String name = "RAMAN ";
	String str="";
	for(int i=0; i<name.length(); i++)
	{
		str = name.charAt(i)+str;
	}
	System.out.println("Revers of "+name+" is "+str);
	}

}
