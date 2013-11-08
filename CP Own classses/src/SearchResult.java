/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package org.tabaserve.gigablast4j;
import org.w3c.dom.*;
import java.util.Map;
import java.util.HashMap;
/**
 * Instances of this class are representing the hits of a search results.
 * @author Tamas from TabaServe Solutions
 */
public class SearchResult {

    
    private Map<String, String> resultAttributes;
    
    /**
     * Standard constructor overloaded with an Element object in order to 
     * process its nodes. The "dmoz" tag is not returned as it has further child nodes
     * and I don't really require dmoz info, hence I just omited this feature.
     * @param el 
     */
    public SearchResult(Element el)
    {
      resultAttributes = new HashMap<String, String>();
      NodeList nl = el.getChildNodes();
      for(int i=0; i<nl.getLength();i++)
      {
         
          resultAttributes.put(nl.item(i).getNodeName(), nl.item(i).getTextContent());
         
      }
      resultAttributes.remove("#text");
      resultAttributes.remove("dmoz");
    }

    /**
     * @return the resultAttributes containing the map object with
     * the corresponding XML-tags and their values.
     */
    public Map<String, String> getResultAttributes() {
        return resultAttributes;
    }
}
