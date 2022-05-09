import java.nio.ByteBuffer;
import java.util.BitSet;

/**
 * Created by Tunc on 3.07.2021.
 */
public class Utils {

    public static int bitSetToInt(BitSet bitSet) {
        int bitInteger = 0;

        for (int i = 0; i < 32; i++){
            if (bitSet.get(i)) {
                bitInteger |= (1 << i);
            }
        }
        return bitInteger;
    }

    public static BitSet longToBitset(long value) {
        BitSet bits = new BitSet();
        int index = 0;
        while (value != 0L) {
            if (value % 2L != 0) {
                bits.set(index);
            }
            ++index;
            value = value >>> 1;
        }
        return bits;
    }


    public static byte[] shortToByteArray(Short headerId) {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.putShort(headerId);
        return buffer.array();
    }

}
