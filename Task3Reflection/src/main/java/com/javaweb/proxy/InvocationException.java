package com.javaweb.proxy;

import com.javaweb.view.View;


public class InvocationException extends Exception {
    public InvocationException(){
        System.err.println(View.INVOCATION_EXCEPTION_MESSAGE);
    }
}
