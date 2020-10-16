package solutionstojava;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectReflection {
    public static void main(String[] args) {


        /* Parameters */
        Object[] doubleArgs = new Object[]{4.2, 3.9};

        /* Get class */
        Class rectangleDefinition = null;
        try {
            rectangleDefinition = Class.forName("MyProj.Rectangle");
            /* Equivalent: Rectangle rectangle = new Rectangle(., .); */
            Class[] doubleArgsClass = new Class[]{double.class, double.class};
            Constructor doubleArgsConstructor =
                    rectangleDefinition.getConstructor(doubleArgsClass);
            Rectangle rectangle = (Rectangle) doubleArgsConstructor.newInstance(doubleArgs);

            /* Equivalent: Double area = rectangle.area(); */
            Method m = rectangleDefinition.getDeclaredMethod("arean");
            Double area = (Double) m.invoke(rectangle);
    /*
    Rectangle rectangle = new Rectangle(.,.);
    Double area = rectangle.area();*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
