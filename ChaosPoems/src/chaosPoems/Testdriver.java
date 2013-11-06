package chaosPoems;

public class Testdriver {

public static void main(String[] args) {
	
	SearchEngine se = new SearchEngine(false, 50000, true);
	
	
	System.out.println("================================================");
	System.out.println("DRIVER PRINT:");
	
	
	
	for(String s : se.search("du er en sød hest")){
		
		System.out.println(s);
		
	}
	
	System.out.println("====================================================================");
	
}
	
}
