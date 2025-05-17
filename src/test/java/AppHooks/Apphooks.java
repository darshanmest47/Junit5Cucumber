package AppHooks;

import com.tests.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import static com.tests.BaseTest.*;
import static com.testutilities.WaitUtilities.*;

public class Apphooks extends BaseTest {

    @Before(order = 0)
    public void setUp(){
        initMethod();
    }

    @After(order =1)
    public void tearDown() throws Throwable {
      waitForSeconds(5000);
      getDriverStatic().quit();
      removeDriver();
    }
}
