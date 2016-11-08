package com.javaweb.controller;


import com.javaweb.entity.Matrix;
import com.javaweb.annotations.MethodUsable;
import com.javaweb.view.View;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionRunner {
    private View view;

    public ReflectionRunner(View view) {
        this.view = view;
    }

    public void showMatrixReflection(Matrix matrixObject) {
        view.printlnMessage(View.REFLECTION_STRING);
        Class matrixClass = createInstanceFromConstructor(matrixObject);
        if (matrixClass == null) {
            view.printlnMessage(View.ERROR_STRING);
            return;
        }

        /* Name of class */
        view.printlnMessage(View.NAME_OF_CLASS_STRING + matrixClass.getName());

        /* Name of superclass */
        view.printlnMessage(View.SEPARATOR_STRING);
        view.printlnMessage(View.NAME_OF_SUPERCLASS_STRING +
                matrixClass.getSuperclass().getName());

        /* Interfaces that implements that class */
        showInterfacesOfClass(matrixClass);

        /* All fields in class */
        showFieldsOfClass(matrixClass);

        /* Call methods with annotation @MethodUsable(enabled == true) */
        callMethodsWithAnnotation(matrixObject, matrixClass);
        view.printlnMessage(View.SEPARATOR_STRING);
    }

    private Class createInstanceFromConstructor(Matrix matrixObject) {
        if (matrixObject == null) {

            try {
                Constructor constructor = Matrix.class.getConstructor(double[][].class);
                matrixObject = (Matrix) constructor.newInstance(
                        (Object) GlobalVariables.ARRAY_MATRIX);
                return matrixObject.getClass();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } else {
            return matrixObject.getClass();
        }
        return null;
    }

    private void showInterfacesOfClass(Class matrixClass) {
        view.printlnMessage(View.SEPARATOR_STRING);
        view.printMessage(View.LIST_OF_INTERFACES);
        if (matrixClass.getInterfaces().length == 0) {
            view.printlnMessage(View.EMPTY_STRING);
        } else {
            for (Class c : matrixClass.getInterfaces()) {
                view.printMessage(c.getSimpleName());
            }
            view.printMessage("\n");
        }
    }

    private String getModifierFromField(Field field) {
        switch (field.getModifiers()) {
            case Modifier.PUBLIC:
                return View.MODIFIER_PUBLIC;
            case Modifier.PRIVATE:
                return View.MODIFIER_PRIVATE;
            case Modifier.PROTECTED:
                return View.MODIFIER_PROTECTED;
            case Modifier.ABSTRACT:
                return View.MODIFIER_ABSTRACT;
            case Modifier.SYNCHRONIZED:
                return View.MODIFIER_SYNCHRONIZED;
            case Modifier.STATIC:
                return View.MODIFIER_STATIC;
            case Modifier.FINAL:
                return View.MODIFIER_FINAL;
            default:
                return "none";
        }
    }

    private void showFieldsOfClass(Class matrixClass) {
        view.printlnMessage(View.SEPARATOR_STRING);
        view.printlnMessage(View.LIST_OF_FIELDS);
        for (Field field : matrixClass.getDeclaredFields()) {
            String modifier = getModifierFromField(field);
            view.printlnMessage(String.format(
                    View.FIELD_FORMATTER,
                    field.getName(),
                    field.getType(),
                    modifier,
                    Arrays.toString(field.getAnnotations())));
        }
    }

    private void callMethodsWithAnnotation(Matrix matrixObject, Class matrixClass) {
        view.printlnMessage(View.SEPARATOR_STRING);
        view.printlnMessage(View.METHODS_STRING);
        for (Method method : matrixClass.getDeclaredMethods()) {
            if ((method.isAnnotationPresent(MethodUsable.class)) &&
                    (method.getAnnotation(MethodUsable.class).enabled())) {
                view.printlnMessage(String.format(
                        View.CALL_METHOD_WITH_ANNOTATION,
                        method.getName(),
                        MethodUsable.class.getName()));
                try {
                    method.setAccessible(true);
                    method.invoke(matrixObject, (Object[]) method.getParameters());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            } else {
                view.printlnMessage(method.getName());
            }
        }
    }
}
