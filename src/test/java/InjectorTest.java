import com.java.reflexion.SomeBean;
import com.java.reflexion.Injector;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class InjectorTest {
    @Test
    public void inject() {
        ByteArrayOutputStream output_stream = new ByteArrayOutputStream();
        PrintStream system_out = System.out;

        System.setOut(new PrintStream(output_stream));

        SomeBean bean = (SomeBean) (new Injector("reflexion.properties")).inject(new SomeBean());
        bean.doSomething();
        assertEquals("OtherImpl\r\nSODoer\r\n", output_stream.toString());

        System.setOut(system_out);
    }
}
