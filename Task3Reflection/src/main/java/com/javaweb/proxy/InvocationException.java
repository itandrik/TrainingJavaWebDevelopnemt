package com.javaweb.proxy;

import com.javaweb.view.View;

/**
 * Custom exception, that will use in {@link InvocationHandlerMatrix}
 * in order to throw it to setters
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 09 Nov 2016
 */
public class InvocationException extends Exception {
    public InvocationException() {
        System.err.println(View.INVOCATION_EXCEPTION_MESSAGE);
    }
}
