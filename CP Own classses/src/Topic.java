
//package org.tabaserve.gigablast4j;

import org.w3c.dom.*;

/**
 * Instances of this class are representing the so-called Giga Bits.
 *
 * @author Tamas from TabaServe Solutions
 */
public class Topic {

    private final int score;
    private final int docCount;
    private String name=null;

   /**
    * Standard constructor assigning the object values
    * from the org.w3c.dom.Element argument.
    * @param el
    * @throws ValueNotValidException 
    */
    public Topic(Element el) throws ValueNotValidException {
        NodeList nl = el.getElementsByTagName("score");

        try {
            score = Integer.parseInt(nl.item(0).getTextContent().toString());
        } catch (Exception ex) {
            throw new ValueNotValidException("score", "at site "+name);
        }


        nl = el.getElementsByTagName("docCount");
        try {
            docCount = Integer.parseInt(nl.item(0).getTextContent().toString());
        } catch (Exception ex) {
            throw new ValueNotValidException("docCount", "at site "+name);
        }

        nl = el.getElementsByTagName("name");

        try {
            name = nl.item(0).getTextContent().toString();
        } catch (Exception ex) {
            throw new ValueNotValidException("name", "at site "+name);
        }

    }

    /**
     * @return the docCount
     */
    public int getDocCount() {
        return docCount;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }
}
