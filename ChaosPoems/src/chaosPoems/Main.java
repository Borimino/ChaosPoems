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
		res = s.split("\\. | \\n");
		return res;
	}
	
	public static String[] end(String s)
	{
		/*
		 * Skal helt klart ændres
		 * Lige nu skriver den første ord, og sender andet ord til søgning og glemmer resten
		 */
		String[] res = new String[3];
		int start = s.indexOf(" ");
		int end = s.indexOf(" ", start+1);
		res[0] = s.substring(0, start);
		res[1] = s.substring(start, end);
		res[2] = s.substring(end);
		return res;
	}
}
