package com.javaweb.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class InvocationHandlerMatrix implements InvocationHandler {
    Object object;

    public InvocationHandlerMatrix(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set")) {
            try {
                throw new InvocationException();
            }catch (InvocationException e){
                e.printStackTrace();
            }
        } else {
            return method.invoke(object, args);
        }
        return null;
    }
}
