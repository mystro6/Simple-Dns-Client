import java.io.IOException;
import java.net.*;

/**
 * Created by Tunc on 3.07.2021.
 */
public class DNSClient {

    private DatagramSocket socket;
    private InetAddress address;
    private final String ADDRESS_NAME = "8.8.8.8";
    private final int PORT = 3132;
    private final int DNS_SERVER_PORT = 53;


    public DNSClient(){
        try {
            socket = new DatagramSocket(PORT);
            address = InetAddress.getByName(ADDRESS_NAME);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    public Response executeQuery(String name, String queryType){
        Query query = new Query();
        Response response = new Response();
        byte[] byteQuery = query.createQuery(name, queryType);
        DatagramPacket packet = new DatagramPacket(byteQuery, byteQuery.length, address, DNS_SERVER_PORT);

        try {
            socket.send(packet);
            byte[] reponseBuffer = new byte[1024];

            DatagramPacket responsePacket = new DatagramPacket(reponseBuffer, reponseBuffer.length);
            socket.receive(responsePacket);


            byte[] responseArray = responsePacket.getData();
            response.readResponse(responseArray, byteQuery.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
