import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.codec.binary.Hex;

public class CRC16A {
    public static byte[] crc(byte[] data) {
        byte[] temdata = new byte[data.length + 2];
        // unsigned char alen = *aStr – 2; //CRC16只计算前两部分
        int xda, genpoly;
        int i, j, xdabit;
        xda = 0xFFFF;
        genpoly = 0xA001; // (X**16 + X**15 + X**2 + 1)
        for (i = 0; i < data.length; i++) {
            xda ^= data[i];
            for (j = 0; j < 8; j++) {
                xdabit = (int) (xda & 0x01);
                xda >>= 1;
                if (xdabit == 1)
                    xda ^= genpoly;
            }
        }
        System.arraycopy(data, 0, temdata, 0, data.length);
        temdata[temdata.length - 2] = (byte) (xda & 0xFF);
        temdata[temdata.length - 1] = (byte) (xda >> 8);
        return temdata;
    }

    // 这个主函数用来测试用的
    public static void main(String args[]) throws Exception {
        byte[] data = new byte[4096];
        InputStream is = new FileInputStream("original");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while (is.read(data) != -1) {
            baos.write(data);
        }
        is.close();

        byte[] d1 = crc(baos.toByteArray());
        int i = 0;
        // for (byte b : d1) {
        // System.out.println(i + " " + d1[i] + " ");
        // i++;
        // }
        System.out.println();
        // for (byte b : d1) {
        System.out.println(Hex.encodeHex(new byte[] { d1[d1.length - 2], d1[d1.length - 1] }));
        // }
        byte[] d2 = crc(d1);
        // for (byte b : d2) {
        System.out.println(d2[d2.length - 2]);
        System.out.println(d2[d2.length - 1]);
        System.out.println(Hex.encodeHex(new byte[] { d2[d2.length - 2], d2[d2.length - 1] }));
        // }
        // i = 0;
        // for (byte b : d2) {
        // System.out.print(d2[i] + " ");
        // i++;
        // }
    }

}
