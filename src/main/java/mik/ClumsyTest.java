package mik;

public class ClumsyTest {
    private static final String FUBAR = "fubar";

    public boolean myMethod(MyObject bar) {
        if (bar != null) {
        }
        return false;
    }

    public interface MyObject {
        String getFoo();

        void setFoo(String o);
    }

    public static void main(String[] args) {

        ClumsyTest obj = new ClumsyTest();
        System.out.println(obj.myMethod(new MyObject() {
            @Override
            public String getFoo() {
                return FUBAR;
            }

            @Override
            public void setFoo(String o) {

            }
        }));
    }
}
