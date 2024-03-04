package feb3;
 
public class Sample {
	public static void add(int x, int y)
	{
		int z = x+y;
		System.out.println(z);
	}
	public static String verify_strings(String str1, String str2)
	{
		String res = "";
		if (str1.equalsIgnoreCase(str2)) 
		{
			res = "strings are equal";	
		}
		else
		{
			res = "strings are not equal";
		}
		return res;
	}
	public static boolean compare_values(int a, int b)
	{
		if (a==b) {
		return true;	
		}
		else
		{
			return false;
		}
		
	}

	public static void main(String[] args) {
		Sample.add(100, 450);
	String res = Sample.verify_strings("", "");
	System.out.println(res);
	boolean x = Sample.compare_values(100, 100);
	System.out.println(x);

	}

}
