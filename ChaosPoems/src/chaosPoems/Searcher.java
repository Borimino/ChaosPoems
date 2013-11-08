package chaosPoems;

public class Searcher
{
	public static String language = "da";
	
	public static String[] search(String s)
	{
		/*
		 * Skal søge med G74un3's søgefunktion
		 */
		if(s.equals(""))
		{
			return new String[] {""};
		}
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
		int i = (int) (Math.random()*s.length);
		res = s[i];
		System.out.println(res);
		return res;
	}
}
