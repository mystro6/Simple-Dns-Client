import java.util.BitSet;

/**
 * Created by Tunc on 3.07.2021.
 */
public class Constants {

    public static BitSet QUERY_HEADER_TRUNCATION;
    public static BitSet QUERY_HEADER_ID;
    public static BitSet QUERY_HEADER_QR;
    public static BitSet QUERY_HEADER_OPCODE;
    public static BitSet QUERY_HEADER_AUTHORITATIVE_ANSWER;
    public static BitSet QUERY_HEADER_RECURSION_DESIRED;
    public static BitSet QUERY_HEADER_RECURSION_AVAILABLE;
    public static BitSet QUERY_HEADER_Z;
    public static BitSet QUERY_HEADER_RESPONSE_CODE;
    public static BitSet QUERY_HEADER_QDCOUNT;
    public static BitSet QUERY_HEADER_ANCOUNT;
    public static BitSet QUERY_HEADER_NSCOUNT;
    public static BitSet QUERY_HEADER_ARCOUNT;


    public static void initializeConstants(){
        initializeQueryHeaderId();
        initializeQueryHeaderQr();
        initializeQueryHeaderOPCode();
        initializeQueryHeaderAuthoritativeAnswer();
        initializeQueryTruncation();
        initializeQueryRecursionDesired();
        initializeQueryRecursionAvailable();
        initializeQueryZ();
        initializeQueryResponseCode();
        initializeQueryHeaderQDCount();
        initializeQueryHeaderANCount();
        initializeQueryHeaderNSCount();
        initializeQueryHeaderARCount();
    }

    private static void initializeQueryHeaderId(){
        //1337
        QUERY_HEADER_ID = new BitSet(16);
        QUERY_HEADER_ID.set(0);
        QUERY_HEADER_ID.clear(1);//
        QUERY_HEADER_ID.clear(2);//
        QUERY_HEADER_ID.set(3);
        QUERY_HEADER_ID.set(4);
        QUERY_HEADER_ID.set(5);
        QUERY_HEADER_ID.clear(6);
        QUERY_HEADER_ID.clear(7);
        QUERY_HEADER_ID.set(8);
        QUERY_HEADER_ID.clear(9);
        QUERY_HEADER_ID.set(10);
        QUERY_HEADER_ID.clear(11);
        QUERY_HEADER_ID.clear(12);
        QUERY_HEADER_ID.clear(13);
        QUERY_HEADER_ID.clear(14);
        QUERY_HEADER_ID.clear(15);
    }

    private static void initializeQueryHeaderQr(){
        //
        QUERY_HEADER_QR = new BitSet(1);
        QUERY_HEADER_QR.clear(0);
    }

    private static void initializeQueryHeaderOPCode(){
        QUERY_HEADER_OPCODE = new BitSet(4);
        QUERY_HEADER_OPCODE.clear(0);
        QUERY_HEADER_OPCODE.clear(1);
        QUERY_HEADER_OPCODE.clear(2);
        QUERY_HEADER_OPCODE.clear(3);

    }

    private static void initializeQueryHeaderAuthoritativeAnswer(){
        QUERY_HEADER_AUTHORITATIVE_ANSWER = new BitSet(1);
        QUERY_HEADER_AUTHORITATIVE_ANSWER.clear(0);
    }

    private static void initializeQueryTruncation(){
        QUERY_HEADER_TRUNCATION = new BitSet(1);
        QUERY_HEADER_TRUNCATION.clear(0);
    }

    private static void initializeQueryRecursionDesired(){
        QUERY_HEADER_RECURSION_DESIRED = new BitSet(1);
        QUERY_HEADER_RECURSION_DESIRED.set(0);
    }

    private static void initializeQueryRecursionAvailable(){
        QUERY_HEADER_RECURSION_AVAILABLE = new BitSet(1);
        QUERY_HEADER_RECURSION_AVAILABLE.set(0);
    }

    private static void initializeQueryZ(){
        QUERY_HEADER_Z = new BitSet(3);
        QUERY_HEADER_Z.clear(0);
        QUERY_HEADER_Z.clear(1);
        QUERY_HEADER_Z.clear(2);
    }

    private static void initializeQueryResponseCode(){
        QUERY_HEADER_RESPONSE_CODE = new BitSet(4);
        QUERY_HEADER_RESPONSE_CODE.clear(0);
        QUERY_HEADER_RESPONSE_CODE.clear(1);
        QUERY_HEADER_RESPONSE_CODE.clear(2);
        QUERY_HEADER_RESPONSE_CODE.clear(3);
    }

    private static void initializeQueryHeaderQDCount(){
        //1 question
        QUERY_HEADER_QDCOUNT = new BitSet(16);
        QUERY_HEADER_QDCOUNT.set(0);
        QUERY_HEADER_QDCOUNT.clear(1);//
        QUERY_HEADER_QDCOUNT.clear(2);//
        QUERY_HEADER_QDCOUNT.clear(3);
        QUERY_HEADER_QDCOUNT.clear(4);
        QUERY_HEADER_QDCOUNT.clear(5);
        QUERY_HEADER_QDCOUNT.clear(6);
        QUERY_HEADER_QDCOUNT.clear(7);
        QUERY_HEADER_QDCOUNT.clear(8);
        QUERY_HEADER_QDCOUNT.clear(9);
        QUERY_HEADER_QDCOUNT.clear(10);
        QUERY_HEADER_QDCOUNT.clear(11);
        QUERY_HEADER_QDCOUNT.clear(12);
        QUERY_HEADER_QDCOUNT.clear(13);
        QUERY_HEADER_QDCOUNT.clear(14);
        QUERY_HEADER_QDCOUNT.clear(15);
    }

    private static void initializeQueryHeaderANCount(){
        QUERY_HEADER_ANCOUNT = new BitSet(16);
        QUERY_HEADER_ANCOUNT.clear(0);
        QUERY_HEADER_ANCOUNT.clear(1);//
        QUERY_HEADER_ANCOUNT.clear(2);//
        QUERY_HEADER_ANCOUNT.clear(3);
        QUERY_HEADER_ANCOUNT.clear(4);
        QUERY_HEADER_ANCOUNT.clear(5);
        QUERY_HEADER_ANCOUNT.clear(6);
        QUERY_HEADER_ANCOUNT.clear(7);
        QUERY_HEADER_ANCOUNT.clear(8);
        QUERY_HEADER_ANCOUNT.clear(9);
        QUERY_HEADER_ANCOUNT.clear(10);
        QUERY_HEADER_ANCOUNT.clear(11);
        QUERY_HEADER_ANCOUNT.clear(12);
        QUERY_HEADER_ANCOUNT.clear(13);
        QUERY_HEADER_ANCOUNT.clear(14);
        QUERY_HEADER_ANCOUNT.clear(15);
    }

    private static void initializeQueryHeaderNSCount(){
        QUERY_HEADER_NSCOUNT = new BitSet(16);
        QUERY_HEADER_NSCOUNT.clear(0);
        QUERY_HEADER_NSCOUNT.clear(1);//
        QUERY_HEADER_NSCOUNT.clear(2);//
        QUERY_HEADER_NSCOUNT.clear(3);
        QUERY_HEADER_NSCOUNT.clear(4);
        QUERY_HEADER_NSCOUNT.clear(5);
        QUERY_HEADER_NSCOUNT.clear(6);
        QUERY_HEADER_NSCOUNT.clear(7);
        QUERY_HEADER_NSCOUNT.clear(8);
        QUERY_HEADER_NSCOUNT.clear(9);
        QUERY_HEADER_NSCOUNT.clear(10);
        QUERY_HEADER_NSCOUNT.clear(11);
        QUERY_HEADER_NSCOUNT.clear(12);
        QUERY_HEADER_NSCOUNT.clear(13);
        QUERY_HEADER_NSCOUNT.clear(14);
        QUERY_HEADER_NSCOUNT.clear(15);
    }

    private static void initializeQueryHeaderARCount(){
        QUERY_HEADER_ARCOUNT = new BitSet(16);
        QUERY_HEADER_ARCOUNT.clear(0);
        QUERY_HEADER_ARCOUNT.clear(1);//
        QUERY_HEADER_ARCOUNT.clear(2);//
        QUERY_HEADER_ARCOUNT.clear(3);
        QUERY_HEADER_ARCOUNT.clear(4);
        QUERY_HEADER_ARCOUNT.clear(5);
        QUERY_HEADER_ARCOUNT.clear(6);
        QUERY_HEADER_ARCOUNT.clear(7);
        QUERY_HEADER_ARCOUNT.clear(8);
        QUERY_HEADER_ARCOUNT.clear(9);
        QUERY_HEADER_ARCOUNT.clear(10);
        QUERY_HEADER_ARCOUNT.clear(11);
        QUERY_HEADER_ARCOUNT.clear(12);
        QUERY_HEADER_ARCOUNT.clear(13);
        QUERY_HEADER_ARCOUNT.clear(14);
        QUERY_HEADER_ARCOUNT.clear(15);
    }
}
