package chaosPoems;

public class Main
{
	private Searcher searcher;
	
	public Main()
	{
		searcher = new Searcher();
	}
	
	public String generate(String s)
	{
		String res = new String("");
		String[] lines = lines(s);
		for(int i = 0; i < lines.length; i++)
		{
			String[] line = end(lines[i]);
			res = res + " " + line[0] + getSearcher().select(getSearcher().search(line[1]));
		}
		return res;
	}
	
	public String[] lines(String s)
	{
		/*
		 * Skal muligvis splitte på andre steder. Tror jeg dog ikke
		 */
		String[] res;
		res = s.split("\\! |\\? |\\. |\\n");
		return res;
	}
	
	private boolean isSmall(String s)
	{
		return s.length() <= 3;
	}
	
	public String[] end(String s)
	{
		/*
		 * Skal helt klart ændres
		 * Lige nu skriver den første ord, og sender andet ord til søgning og glemmer resten
		 */
		String[] res = new String[3];
		
		int i = 0;
		boolean done = false;
		while(!done)
		{
			i = s.indexOf(" ", i);
			if(i < 0 || isSmall(s.substring(i, s.indexOf(" ", i))))
			{
				done = true;
			}
		}
		if(i > 0)
		{
			res[0] = s.substring(0, i);
			int end = s.indexOf(" ", i+10);
			if(end > 0)
			{
				res[1] = s.substring(i, end);
				res[2] = s.substring(end);
			} else
			{
				res[1] = s.substring(i);
				res[2] = "";
			}
		} else
		{
			i = (int) (Math.random()*(s.length()*0.6));
			i = s.indexOf(" ", i);
			if(i > 0)
			{
				res[0] = s.substring(0, i);
				int end = s.indexOf(" ", i+5);
				res[1] = s.substring(i, end);
				res[2] = s.substring(end);
			} else
			{
				res[0] = s;
				res[1] = "";
				res[2] = "";
			}
		}
		
		return res;
	}

	public Searcher getSearcher()
	{
		return searcher;
	}
}
