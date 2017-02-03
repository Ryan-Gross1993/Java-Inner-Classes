import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * Created by ryangross on 2/2/17.
 */
public class ConnectionManagerTest {
    ConnectionManager aCM;


    @Before
    public void setUp() {
        aCM = new ConnectionManager(1);

    }

    @Test
    public void closeTest() {
        aCM.getConnection("127.0.0.1", 8000);
        aCM.getConnection("127.0.0.1", 8000);
        Assert.assertEquals(null, aCM.getConnection("127.0.0.1", 8000));
        aCM.findConnection("127.0.0.1", 8000);
        Assert.assertEquals(0, aCM.getConnections().size());

    }
}
