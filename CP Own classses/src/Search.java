
//package org.tabaserve.gigablast4j;

/**
 * This abstract class implements the various parameter set-ups of the Gigablast API call
 * as well as providing functionality to make the call. The XMLParsing concrete class directly inherits from this one.
 *
 * @author Tamas from TabaServe Solutions
 */
public abstract class Search {

    private final String startUrl;
    private String request;

    /**
     *
     */
    public Search() {

        startUrl = "http://www.gigablast.com/search?q=";

    }

    /**
     * This method creates a basic GigaBlast Request. You need to put some basic
     * parameters in such as keyword, number of returned GigaBits, you wish your
     * search result duplicates to be removed, enable/disable site clustering
     * and set the returned XML to utf-8 or raw XML.
     *
     * @param keyword
     * @param siteClustering
     * @param duplicateRemoval
     * @param utf8
     * @param numberofgigabits
     */
    public void createBasicRequest(String keyword, boolean siteClustering, boolean duplicateRemoval, boolean utf8, int numberofgigabits) {
        int a = 1;
        int b = 9;
        int c = 1;
        if (!siteClustering) {
            a = 0;
        }
        if (!utf8) {
            b = 8;
        }
        if (!duplicateRemoval) {
            c = 0;
        }
        request = "http://www.gigablast.com/search?q=" + keyword + "&sc=" + a + "&dr=" + c + "&raw=" + b + "&nrt=" + numberofgigabits;
    }

    /**
     * Sets the number of results returned by the request. If you set it over
     * fifty it will count as 50. Values less than 1 will be counted as 1.
     *
     * @param a
     * @throws ParameterAlreadyUsedException
     */
    public void addNumberOfResults(int a) throws ParameterAlreadyUsedException {
        if (a > 50) {
            a = 50;
        }
        if (a < 1) {
            a = 1;
        }
        String local = "n=";
        if (request.contains(local)) {
            throw new ParameterAlreadyUsedException(local);
        } else {
            request = request + "&n=" + a;
        }
    }

    /**
     * Sets the starting point of the results. If it is over 499, it will be
     * counted as 499, if it is less than 0 then it will be counted as 0.
     *
     * @param a
     * @throws ParameterAlreadyUsedException
     */
    public void setStartingResults(int a) throws ParameterAlreadyUsedException {
        if (a > 499) {
            a = 499;
        }
        if (a < 0) {
            a = 0;
        }
        String local = "s=";
        if (request.contains(local)) {
            throw new ParameterAlreadyUsedException(local);
        } else {
            request = request + "&s=" + a;
        }
    }

    /**
     * Sets the number of summary excerpts for each result.
     *
     * @param a
     * @throws ParameterAlreadyUsedException
     */
    public void setSummaryExcerpts(int a) throws ParameterAlreadyUsedException {

        String local = "ns=";
        if (request.contains(local)) {
            throw new ParameterAlreadyUsedException(local);
        } else {
            request = request + "&ns=" + a;
        }
    }

    /**
     * Sets a website from the search results will be coming from. The argument
     * string is not checked for validity, so please use valid site address.
     *
     * @param a
     * @throws ParameterAlreadyUsedException
     */
    public void setSite(String a) throws ParameterAlreadyUsedException {

        String local = "site=";
        if (request.contains(local)) {
            throw new ParameterAlreadyUsedException(local);
        } else {
            request = request + "&site=" + a;
        }
    }

    /**
     * Sets several websites from the keyword query should be coming from. The
     * input array max length is 500 - see GigaBlast API docs for more.
     *
     * @param a
     * @throws ParameterAlreadyUsedException
     * @throws ArrayTooLargeException
     */
    public void setSites(String[] a) throws ParameterAlreadyUsedException, ArrayTooLargeException {
        String local = "sites=";
        if (a.length > 500) {
            throw new ArrayTooLargeException();
        }

        if (request.contains(local)) {
            throw new ParameterAlreadyUsedException(local);
        } else {
            String helper = "";
            for (String s : a) {
                helper = helper + " " + s;
            }
            request = request + "&sites=" + helper;
        }
    }

    /**
     * Adds another keyword to the search query with the logical AND operator.
     * This method can be called several times upon one search string, thus
     * adding more keywords to it. The maximum number of search keywords is not
     * known.
     *
     * @param keyword
     */
    public void addAnotherKeyword(String a) {
        String local = "plus=";


        request = request + "&plus=" + a;

    }

    /**
     * Adds a negative keyword to the search query - something like the NOT
     * logical operator. This method can be called several times upon one search
     * string, thus adding more negative keywords to it.
     *
     * @param a
     */
    public void negativeKeyword(String a) {
        String local = "minus=";


        request = request + "&minus=" + a;
    }

    /**
     * With this parameter the returned results will have ALL query terms.
     *
     * @throws ParameterAlreadyUsedException
     */
    public void requireAllTerms() throws ParameterAlreadyUsedException {

        String local = "rat=";
        if (request.contains(local)) {
            throw new ParameterAlreadyUsedException(local);
        } else {
            request = request + "&rat=1";
        }
    }

    /**
     * Sets up the percentage ratio which will required to be met by the search
     * result similarity in order to be streamed/viewed. In short, better search
     * result matching can be achieved by higher percentage. Default is 80%.
     *
     * @param a
     */
    public void cutOffPercentage(int a) throws ParameterAlreadyUsedException {

        String local = "psc=";
        if (request.contains(local)) {
            throw new ParameterAlreadyUsedException(local);
        } else {
            if (a < 1) {
                a = 1;
            }
            if (a > 100) {
                a = 100;
            }
            request = request + "&psc=" + a;
        }
    }

    /**
     * As far as I understand this parameter sets that the query is NOT boolean.
     * There is an auto-detect option, which is default, if you wish to use that
     * then please do not call this method.
     * There is no mean to change the previously added settings, you need to start rebuilding 
     * your query string if you wish to change it.
     *
     * @param b
     */
    public void setBooleanOperator(boolean b) throws ParameterAlreadyUsedException {
        String local = "bq=";
        if (request.contains(local)) {
            throw new ParameterAlreadyUsedException(local);
        } else {
            if (b) {
                request = request + "&bq=1";
            }
            if (!b) {
                request = request + "&bq=0";
            }
        }
    }
    /**
     * This method will add the necessary language code to your query.
     * You need to use the two letter language code, but the method does not check for 
     * this, so whatever you put here as argument will be passed to GigaBlast for processing,
     * so please try to use the right language code.
     * @param a
     * @throws ParameterAlreadyUsedException 
     */
    
    
    public void setLanguage(String a) throws ParameterAlreadyUsedException
    {
          String local = "lang=";
        if (request.contains(local)) {
            throw new ParameterAlreadyUsedException(local);
        } else {
            request = request + "&lang="+a;
        }
        
        
    }
/**
 * Returns the request object.
 * @return 
 */
    public String getRequest() {
        return request;
    }
}
