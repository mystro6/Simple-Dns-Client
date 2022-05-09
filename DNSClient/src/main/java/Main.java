import java.util.Scanner;

/**
 * Created by Tunc on 3.07.2021.
 */

//https://docstore.mik.ua/orelly/networking_2ndEd/dns/appa_02.htm
//https://courses.cs.duke.edu//fall16/compsci356/DNS/DNS-primer.pdf
//https://cabulous.medium.com/dns-message-how-to-read-query-and-response-message-cfebcb4fe817

public class Main {
    public static void main(String[] args) {


        DNSClient dnsClient = new DNSClient();
        Scanner scanner = new Scanner(System.in);

        Constants.initializeConstants();

        Response response = dnsClient.executeQuery("www.google.com", "A");

        response.generateResponseString();
        System.out.println(response.toString());
    }
}
