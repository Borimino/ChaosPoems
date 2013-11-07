package chaosPoems;

public class Main
{
	public static String generate(String s)
	{
		String res = new String("");
		String[] lines = lines(s);
		for(int i = 0; i < lines.length; i++)
		{
			String[] line = end(lines[i]);
			res = res + " " + line[0] + Searcher.select(Searcher.search(line[1]));
		}
		return res;
	}
	
	public static String[] lines(String s)
	{
		/*
		 * Skal muligvis splitte på andre steder. Tror jeg dog ikke
		 */
		String[] res;
		res = s.split("\\! |\\? |\\. |\\n");
		return res;
	}
	
	private static boolean isSmall(String s)
	{
		return s.length() <= 3;
	}
	
	public static String[] end(String s)
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
			if(isSmall(s.substring(i, s.indexOf(" ", i))))
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
			res[0] = s.substring(0, i);
			int end = s.indexOf(" ", i+5);
			res[1] = s.substring(i, end);
			res[2] = s.substring(end);
		}
		
		return res;
	}
}
