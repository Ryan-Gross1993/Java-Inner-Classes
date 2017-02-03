import java.io.Closeable;

/**
 * Created by ryangross on 2/2/17.
 */
public interface Connection extends Closeable {

    String getIP();

    int getPort();

    String getProtocol();

    String connect();

    void close();

}
