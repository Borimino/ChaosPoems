package chaosPoems;

public class Main
{
	private Searcher searcher;
	public boolean default_mode;
	private int numOfLines;
	
	public Main()
	{
		searcher = new Searcher();
		default_mode = true;
		numOfLines = 10;
	}
	
	public String generate(String s)
	{
		if(default_mode)
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
		String res = new String("");
		String line = lines(s)[0];
		for(int i = 0; i < numOfLines; i++)
		{
			String[] line2 = end2(line);
			String line3 = getSearcher().select(getSearcher().search(line2[1]));
			res = res + " " + line2[0] + end2(line3)[0];
			line = line3;
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
		//System.out.println(s);
		return s.matches("[\\D]{0,3}");
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
			i = s.indexOf(" ", i+1);
			if(i < 0 || (s.indexOf(" ", i+1) > 0 && isSmall(s.substring(i+1, s.indexOf(" ", i+1)))))
			{
				done = true;
			}
		}
		if(i > 0)
		{
			res[0] = s.substring(0, i);
			int end = s.indexOf(" ", i+20);
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
				int end = s.indexOf(" ", i+1);
				if(end < 0)
				{
					end = s.indexOf(".", i+1);
				}
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
	
	public String[] end2(String s)
	{
		/*
		 * Skal helt klart ændres
		 * Lige nu skriver den første ord, og sender andet ord til søgning og glemmer resten
		 */
		String[] res = new String[3];
		
		int i = (int) (Math.random()*(s.length()*0.2));
		boolean done = false;
		while(!done)
		{
			i = s.indexOf(" ", i+1);
			if(i < 0 || (s.indexOf(" ", i+1) > 0 && isSmall(s.substring(i+1, s.indexOf(" ", i+1)))))
			{
				done = true;
			}
		}
		if(i > 0)
		{
			res[0] = s.substring(0, i);
			int end = s.indexOf(" ", i+20);
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
				int end = s.indexOf(" ", i+1);
				if(end < 0)
				{
					end = s.indexOf(".", i+1);
				}
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
