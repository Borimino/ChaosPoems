import java.util.ArrayList;

public class SearchEngine extends Search {

	private Boolean fromleft;
	private Boolean withkeywords;
	private int numberofresults;

	public SearchEngine(Boolean fromleft, int numberofresults, Boolean withkeywords) {

		this.fromleft = fromleft;
		this.numberofresults = numberofresults;
		this.withkeywords = withkeywords;

	}

	public SearchEngine(int numberofresults) {

		this(true, numberofresults, false);

	}

	
	public ArrayList<String> Search(String keywords){
		
		ArrayList<String> res = new ArrayList<String>();
		
		
		createBasicRequest(keywords, false, true, true, numberofresults);
		
		//????? SKAL DETTE MED: setStartingResults(0);
		
		
		requireAllTerms(); //Secures that every keyword is present
		
		getRequest(); //Returns the request
		
		
		
		return res;
	}
	
	public Boolean getFromleft() {
		return fromleft;
	}

	public void setFromleft(Boolean fromleft) {
		this.fromleft = fromleft;
	}

	public Boolean getwithkeywords() {
		return withkeywords;
	}

	public void setwithkeywords(Boolean withkeywords) {
		this.withkeywords = withkeywords;
	}

	public int getNumberofresults() {
		return numberofresults;
	}

	public void setNumberofresults(int numberofresults) {
		this.numberofresults = numberofresults;
	}

}
