import com.java.reflexion.SomeBean;
import com.java.reflexion.Injector;

public class Main {
    public static void main(String[] args) {
        SomeBean bean = (SomeBean) (new Injector("reflexion.properties")).inject(new SomeBean());
        bean.doSomething();
    }
}