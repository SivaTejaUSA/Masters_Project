package testcases;

import java.lang.reflect.Method;

public class TestCaseExecutor {
    public static boolean executeTestCase(String methodName, Object... args) {
        boolean passed = false;
        try {
            Class<?> c = Class.forName("testcases.TestMethods");
            Object obj = c.getDeclaredConstructor().newInstance();

            // Get the types of the arguments
            Class<?>[] argTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argTypes[i] = args[i].getClass();
            }

            // Get the method with the specified name and argument types
            Method method = c.getDeclaredMethod(methodName, argTypes);

            // Invoke the method with the provided arguments
            passed=(boolean) method.invoke(obj, args);
        } catch (Exception e) {
            e.printStackTrace();
            passed = false;
        }
        return passed;
    }
}

