package chaosPoems;

public class Searcher
{
	public static String[] search(String s)
	{
		/*
		 * Skal søge med G74un3's søgefunktion
		 */
		String[] res;
		res = new String[]{s};
		return res;
	}
	
	public static String select(String[] s)
	{
		/*
		 * Skal udvælge fra søgeresultaterne
		 */
		String res;
		res = s[0];
		System.out.println(res);
		return res;
	}
}
