/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package org.tabaserve.gigablast4j;

/**
 *
 * @author Tamas from TabaServe Solutions
 */
public class ArrayTooLargeException extends Exception {

    /**
     * Creates a new instance of
     * <code>ArrayTooLargeException</code> without detail message.
     */
    public ArrayTooLargeException() {
        super("Array over the GigaBlast API limit. For more info please visit http://gigablast.com/searchfeed.html");
    }

    /**
     * Constructs an instance of
     * <code>ArrayTooLargeException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ArrayTooLargeException(String msg) {
        super(msg);
    }
}
