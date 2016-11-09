package com.javaweb.entity;


import com.javaweb.controller.GlobalVariables;
import com.javaweb.entity.interfaces.IMatrix;
import com.javaweb.proxy.InvocationHandlerMatrix;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public class TestProxy {
    private Matrix matrix;
    private IMatrix matrixProxy;

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp(){
        matrix = new Matrix();
        matrixProxy = (IMatrix) Proxy.newProxyInstance(
                Matrix.class.getClassLoader(),
                Matrix.class.getInterfaces(),
                new InvocationHandlerMatrix(matrix));
    }

    @Test
    public void testProxyMatrix(){
        thrown.expect(UndeclaredThrowableException.class);
        matrixProxy.setMatrix(GlobalVariables.ARRAY_MATRIX);
    }
}
