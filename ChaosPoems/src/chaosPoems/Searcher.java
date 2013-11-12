package chaosPoems;

public class Searcher
{
	SearchEngine se;
	
	public Searcher()
	{
		se = new SearchEngine(false, 20, true);
	}
	
	public String language = "da";
	
	public String[] search(String s)
	{
		/*
		 * Skal søge med G74un3's søgefunktion
		 */
		if(s.equals(""))
		{
			return new String[] {""};
		}
		String[] res;
		res = se.search(s).toArray(new String[0]);
		return res;
	}
	
	public String select(String[] s)
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
