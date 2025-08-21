package org.example;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtil {
    public static void printFieldNamesAndValues(Object obj){
        try{
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();

            for(Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(obj);
                System.out.println(field.getName() + " = " + value);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void invokePrivateMethod(Object obj, String methodName, Object... args){
        try{
            Class<?> clazz = obj.getClass();

            Class<?>[] paramTypes = new Class[args.length];
            for(int i = 0; i < args.length; i++){
                paramTypes[i] = args[i].getClass();
            }

            Method method = clazz.getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            method.invoke(obj, args);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
