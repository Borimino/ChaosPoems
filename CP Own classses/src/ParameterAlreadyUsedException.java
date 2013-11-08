/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package org.tabaserve.gigablast4j;

/**
 *
 * @author Tamas from TabaServe Solutions
 */
public class ParameterAlreadyUsedException extends Exception {

    /**
     * Creates a new instance of
     * <code>ParameterAlreadyUsedException</code> without detail message.
     */
    public ParameterAlreadyUsedException() {
    }

    /**
     * Constructs an instance of
     * <code>ParameterAlreadyUsedException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public ParameterAlreadyUsedException(String msg) {
        super("The "+ msg + " parameter has already been used in your current request. For further"
                + " information please visit http://gigablast.com/searchfeed.html");
        
    }
}
