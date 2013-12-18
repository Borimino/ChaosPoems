package chaosPoems;

import java.util.ArrayList;

public class Searcher
{
	SearchEngine se;
	
	public Searcher()
	{
		se = new SearchEngine("da", false, 20, true);
	}
	
	public ArrayList<String> search(String s)
	{
		/*
		 * Skal søge med G74un3's søgefunktion
		 */
		if(s.equals(""))
		{
			ArrayList<String> res = new ArrayList<String>();
			res.add(" ");
			return res;
		}
		ArrayList<String> res;
		res = se.search(s);
		return res;
	}
	
	public String select(ArrayList<String> s)
	{
		/*
		 * Skal udvælge fra søgeresultaterne
		 */
		String res;
		int i = (int) (Math.random()*s.size());
		res = s.get(i);
		if(s.size() > 1 && res.matches(".*\\.\\..*"))
		{
			s.remove(i);
			res = select(s);
		}
		System.out.println(res);
		return res;
	}
	
	public SearchEngine getSe()
	{
		return se;
	}
}
