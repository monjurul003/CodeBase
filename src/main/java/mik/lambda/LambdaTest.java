package mik.lambda;

public class LambdaTest {
    public static void getAdd(MyLambda a) {
        System.out.println(a.add(5,6));
    }
    public static void  main(String[] args) {
        MyLambda add = (a,b)-> a+b;
        getAdd(add);
    }
    @FunctionalInterface
    public interface MyLambda{
        public int add(int a, int b);
        public default int sub(int a, int b){
            return a-b;
        }
    };
}

