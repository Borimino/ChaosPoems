package chaosPoems;

import java.util.ArrayList;
import java.util.Iterator;

public class ResultCleaner {

	private String[] dirt;
	private String[] linesToBeKilled;

	public ResultCleaner() {

		// Array with strings to be removed
		dirt = new String[4];
		dirt[0] = "<span class='searchmatch'>";
		dirt[1] = "</span>";
		dirt[2] = "\"";
		dirt[3] = "<b>...</b>";

		// The lines which contains following strings will be deleted
		linesToBeKilled = new String[1];
		linesToBeKilled[0] = "Sindice search:";

	}

	/**
	 * Responisble for the overall cleaning
	 * @param dirtyresults An arraylist containg the results to be cleaned
	 * @param keywords The words which were used in the original search. Used to delete unsuccessful results
	 * @return An arraylist with strings containing the results without all of the formatting declared in dirt[] and without the Strings which contains strings from linesToBeKilled[]
	 */
	public ArrayList<String> clean(ArrayList<String> dirtyresults, String keywords) {

		ArrayList<String> res = new ArrayList<String>();

		for (String s : dirtyresults) {

			res.add(removeStrings(s)); // Removed unwanted caracters
		}

		// Kills results whichs doesnt live up to stadards
		Iterator<String> itr = res.iterator();
		while (itr.hasNext()) {
			String s = (String) itr.next();

			if (shouldLineBeKilled(s, keywords)) {
				itr.remove();
			}

		}

		return res;
	}

	/**
	 * Removes dirty strings from result
	 * @param dirtystring the string to be cleaned
	 * @return new clean string
	 */
	private String removeStrings(String dirtystring) {

		for (int i = 0; i < dirt.length; i++) {

			dirtystring = vacuum(dirtystring, dirt[i]);

		}

		return dirtystring;

	}

	/**
	 * 
	 * @param dirtystring the string to be cleaned
	 * @param unwantedstring the string to be removed from dirtystring
	 * @return A clean string
	 */
	private String vacuum(String dirtystring, String unwantedstring) {

		return dirtystring.replaceAll(unwantedstring, "");

	}

	/**
	 * Decides weather or not a string should be killed
	 * @param containingline the whole string 
	 * @return true if the lines contains strings from the linesTobeKilled list
	 */
	private Boolean shouldLineBeKilled(String containingline, String keywords) {
		Boolean res = false;

		for (String s : linesToBeKilled) {
			if (containingline.toLowerCase().contains(s.toLowerCase())) {
				res = true;
			}
		}
		
		if(!containingline.toLowerCase().contains(keywords.toLowerCase())){
			res = true;
			
		}

		return res;

	}

}
