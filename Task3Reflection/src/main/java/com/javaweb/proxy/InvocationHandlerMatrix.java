package com.javaweb.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Class, that implements InvocationHandler.
 * It is used by proxy.
 * It throws exceptions to setters.
 *
 * @author Andrii Chernysh
 * @version 1.0
 * @since 09 Nov 2016
 */
public class InvocationHandlerMatrix implements InvocationHandler {
    Object object;

    public InvocationHandlerMatrix(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set")) {
            throw new InvocationException();
        } else {
            return method.invoke(object, args);
        }
    }
}
