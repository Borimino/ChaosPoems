
//package org.tabaserve.gigablast4j;

/**
 *
 * @author Tamas from TabaServe Solutions
 */
public class ValueNotValidException extends Exception {

    /**
     * Creates a new instance of
     * <code>ValueNotValidException</code> without detail message.
     */
    public ValueNotValidException() {
    }

    /**
     * Constructs an instance of
     * <code>ValueNotValidException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ValueNotValidException(String msg, String msg2) {
        super("XML-element "+msg+" at "+msg2+"  cannot be parsed into the object for some reason - standard XML-tag could be missing for some reason or it has an unusual value." );
    }
}
