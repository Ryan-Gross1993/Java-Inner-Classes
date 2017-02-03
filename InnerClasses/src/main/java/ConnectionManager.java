import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryangross on 2/2/17.
 */
public class ConnectionManager {
    private List<ManagedConnection> connections = new ArrayList();
    private int limit;


    public ConnectionManager(int limit) {
        this.limit = limit;
    }

    public List<ManagedConnection> getConnections() {
        return this.connections;
    }


    public ManagedConnection getConnection(String anIP, int aPort) {
        if (limit != 0) {
            ManagedConnection aMC = new ManagedConnection(anIP, aPort, "HTTP");
            limit--;
            return aMC;
        } else {
            return null;
        }
    }

    public void findConnection(String ip, int port) {
        for (int i = 0; i < connections.size(); i++) {
            if ( (connections.get(i).getIP().equals(ip)) && (connections.get(i).getPort() == port) ) {
                connections.get(i).close();
            }
        }
    }


    private class ManagedConnection implements Connection {
        private String ipAddress;
        private int port;
        private String protocol;


        public ManagedConnection(String ip, int port, String protocol) {
            this.ipAddress = ip;
            this.port = port;
            this.protocol = protocol;
        }

        public String getIP() {
            return this.ipAddress;
        }

        public int getPort() {
            return this.port;
        }


        public String getProtocol() {
            return this.protocol;
        }

        public String connect() {
            return "Connected to " + getIP() + ":" + getPort() + " via " + getProtocol();
        }

        public void close() {
            for(int i = 0; i < connections.size(); i++) {
                if (connections.get(i) == this) {
                    connections.remove(i);
                    limit++;
                }
            }
        }
    }

}
