import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Object boo = Boo.class.getDeclaredConstructor();
        Method[] methods = boo.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(TestAnnotation.class)) {
                int mods = method.getModifiers();
                if (!Modifier.isPublic(mods)) method.setAccessible(true);
                TestAnnotation ta = method.getAnnotation(TestAnnotation.class);
                System.out.println(method.invoke(boo, ta.param1(), ta.param2()));
            }
        }
    }
}