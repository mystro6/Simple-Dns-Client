import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by Tunc on 3.07.2021.
 */
public class Query {
    private byte[] query;
    private byte[] headerPart;
    private byte[] questionPart;
    private byte[] qName;

    public byte[] getQuery() {
        return query;
    }

    public void setQuery(byte[] query) {
        this.query = query;
    }

    public byte[] getHeaderPart() {
        return headerPart;
    }

    public void setHeaderPart(byte[] headerPart) {
        this.headerPart = headerPart;
    }

    public byte[] getQuestionPart() {
        return questionPart;
    }

    public void setQuestionPart(byte[] questionPart) {
        this.questionPart = questionPart;
    }

    public byte[] getqName() {
        return qName;
    }

    public void setqName(byte[] qName) {
        this.qName = qName;
    }

    public byte[] createQuery(String name, String query){

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        byte[] headerBuffer = createHeaders();
        byte[] questionBuffer = createQuestion(name, query);

        try {
            byteArrayOutputStream.write(headerBuffer);
            byteArrayOutputStream.write(questionBuffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.query = byteArrayOutputStream.toByteArray();
        return this.query;
    }

    private byte[] createQuestion(String name, String query) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        //default "A"
        short qtype = 1;
        switch(query){
            case "MX":
                qtype = 15;
                break;
            case "NS":
                qtype = 2;
                break;
        }

        //1 == the Internet
        short qclass = 1;

        byte[] qname = createQName(name);

        try {
            byteArrayOutputStream.write(qname);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(qtype);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(qclass);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.questionPart = byteArrayOutputStream.toByteArray();
        return questionPart;
    }

    private byte[] createQName(String name) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        String[] domains = name.split("\\.");

        for(String domain : domains){
            byteArrayOutputStream.write(domain.length());
            for(int i = 0; i < domain.length(); i++){
                byteArrayOutputStream.write((byte) domain.charAt(i));
            }
        }

        byteArrayOutputStream.write(0);

        this.qName = byteArrayOutputStream.toByteArray();
        return qName;

    }

    //For DNS Headers
    //https://courses.cs.duke.edu//fall16/compsci356/DNS/DNS-primer.pdf
    private byte[] createHeaders() {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        Short headerId = 1337;
        Short flags = 128;//0000000010000000
        Short qdCount = 1;
        Short anCount = 0;
        Short nsCount = 0;
        Short arCount = 0;

        byte[] idArray = Utils.shortToByteArray(headerId);
        byte[] flagArray = Utils.shortToByteArray(flags);
        byte[] qdCountArray = Utils.shortToByteArray(qdCount);
        byte[] anCountArray = Utils.shortToByteArray(anCount);
        byte[] nsCountArray = Utils.shortToByteArray(nsCount);
        byte[] arCountArray = Utils.shortToByteArray(arCount);

        try {
            byteArrayOutputStream.write(idArray);
            byteArrayOutputStream.write(flagArray);
            byteArrayOutputStream.write(qdCountArray);
            byteArrayOutputStream.write(anCountArray);
            byteArrayOutputStream.write(nsCountArray);
            byteArrayOutputStream.write(arCountArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.headerPart = byteArrayOutputStream.toByteArray();
        return headerPart;
    }
}
