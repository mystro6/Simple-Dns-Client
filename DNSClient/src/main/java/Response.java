import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by Tunc on 4.07.2021.
 */
public class Response {

    private short id;
    private short flags;
    private short qdCount;
    private short anCount;
    private short nsCount;
    private short arCount;
    private String qName;
    private short type;
    private short queryClass;
    private int ttl;
    private short responseDataSize;
    private StringBuilder responseData;

    public String getqName() {
        return qName;
    }

    public void setqName(String qName) {
        this.qName = qName;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public short getFlags() {
        return flags;
    }

    public void setFlags(short flags) {
        this.flags = flags;
    }

    public short getQdCount() {
        return qdCount;
    }

    public void setQdCount(short qdCount) {
        this.qdCount = qdCount;
    }

    public short getAnCount() {
        return anCount;
    }

    public void setAnCount(short anCount) {
        this.anCount = anCount;
    }

    public short getNsCount() {
        return nsCount;
    }

    public void setNsCount(short nsCount) {
        this.nsCount = nsCount;
    }

    public short getArCount() {
        return arCount;
    }

    public void setArCount(short arCount) {
        this.arCount = arCount;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", flags=" + flags +
                ", qdCount=" + qdCount +
                ", anCount=" + anCount +
                ", nsCount=" + nsCount +
                ", arCount=" + arCount +
                ", qName='" + qName + '\'' +
                ", type=" + type +
                ", queryClass=" + queryClass +
                ", ttl=" + ttl +
                ", responseDataSize=" + responseDataSize +
                ", responseData=" + responseData +
                '}';
    }

    public void readResponse(byte[] responseArray, int quesryLength){
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(responseArray));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {

            //Read Headers
            this.id = dataInputStream.readShort();
            this.flags = dataInputStream.readShort();
            this.qdCount = dataInputStream.readShort();
            this.anCount = dataInputStream.readShort();
            this.nsCount = dataInputStream.readShort();
            this.arCount = dataInputStream.readShort();

            System.out.println(toString());
            //Read QName
            StringBuilder qNameStringBuilder = new StringBuilder();
            while(true){
                byte lengthByte = dataInputStream.readByte();
                int length = lengthByte;
                System.out.println(lengthByte);
                if(length == 0){
                    break;
//                    if(nextByte == 0){
//                        qNameStringBuilder.deleteCharAt(qNameStringBuilder.length() - 1);
//                        break;
//                    }
                }

                for(int i = 0; i < length; i++){
                    byte letterByte = dataInputStream.readByte();
                    char letter = (char) letterByte;
                    System.out.println(letterByte);
                    qNameStringBuilder.append(letter);
                }
                qNameStringBuilder.append(".");
            }
            qNameStringBuilder.deleteCharAt(qNameStringBuilder.length() - 1);

            this.type = dataInputStream.readShort();
            System.out.println(type);
            this.queryClass = dataInputStream.readShort();
            System.out.println(queryClass);

            this.qName = qNameStringBuilder.toString();
            System.out.println(qName);

            //answers
            System.out.println(dataInputStream.readShort());
//            short namePointer = dataInputStream.readShort();

//            System.out.println(namePointer);

            short answerType = dataInputStream.readShort();
            short answerQueryClass = dataInputStream.readShort();

            System.out.println(answerType);
            System.out.println(answerQueryClass);

            this.ttl = dataInputStream.readInt();
            System.out.println(ttl);
            long unsignedValue = ttl & 0xffffffffL;

            this.responseDataSize = dataInputStream.readShort();
            System.out.println(responseDataSize);

            responseData = new StringBuilder();
            if(type == 1){
                for(int i = 0; i < responseDataSize; i++){
                    byte responseDataByte = dataInputStream.readByte();
                    responseData.append(Byte.toUnsignedInt(responseDataByte));
                    responseData.append(".");
                }
                responseData.deleteCharAt(responseData.length() - 1);

                System.out.println(responseData.toString());
            }else if(type == 2){
                System.out.println("type == 2");
                for(int i = 0; i < responseDataSize; i++){
                    byte responseDataByte = dataInputStream.readByte();
                    System.out.println(responseDataByte);
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String generateResponseString(){

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(this.qName);

        return stringBuilder.toString();
    }
}
