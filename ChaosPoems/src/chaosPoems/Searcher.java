package chaosPoems;

public class Searcher
{
	public static String language = "da";
	
	public static String[] search(String s)
	{
		/*
		 * Skal søge med G74un3's søgefunktion
		 */
		String[] res;
		SearchEngine se = new SearchEngine(false, 20, true);
		res = se.search(s).toArray(new String[0]);
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
