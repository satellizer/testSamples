import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class test2_encrypt {

    private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
        if (raw == null || clear == null) {
            return null;
        }
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(clear);
        return encrypted;
    }

    private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }

    private static byte[] shadecrypt(byte[] raw) throws Exception {

        MessageDigest sha = MessageDigest.getInstance("SHA");
        sha.update(raw);

        return sha.digest();
    }

    private static byte[] shaencrypt(byte[] raw) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA");
        sha.update(raw);

        byte[] encrypted = sha.digest();
        String hexstr = new String(Hex.encodeHex(encrypted, false));
        return Base64.encodeBase64(hexstr.getBytes("utf-8"));
    }

    public static void main(String[] args) throws Exception {
        BASE64Decoder dec = new BASE64Decoder();
        BASE64Encoder enc = new BASE64Encoder();
        Base64 base = new Base64();

        // {
        // byte[] decoded = base.decode("6M9RobM3BtI6V8YxNxNVyQ==");
        // byte[] trydecrypt = decrypt("BY2012@gbiac.com".getBytes(), decoded);
        // System.out.println("trydecrypt ==>" + new String(trydecrypt));
        // System.out.println(base.encodeAsString(encrypt("BY2012@gbiac.com".getBytes(),
        // "".getBytes())));
        // }
        {
            byte[] encryptedBuffer = encrypt("BY2012@gbiac.com".getBytes(), "13800138000".getBytes());
            System.out.println(base.encodeAsString(encryptedBuffer));
            String encodedstring = base.encodeAsString(new String(Hex.encodeHex(encryptedBuffer,
                    false)).getBytes("utf-8"));
            System.out.println("encodedstring ==>" + encodedstring);

            byte[] decoded = base.decode("pbztXqjIJgq6LGClyRdgjw==");
            byte[] trydecrypt = decrypt("BY2012@gbiac.com".getBytes(), decoded);
            System.out.println("trydecrypt ==>" + new String(trydecrypt));
            String hexstr = new String(decoded);
            System.out.println("hexstr ==>" + hexstr);

            byte[] buff = new byte[hexstr.length() >> 1];
            for (int i = 0; i < hexstr.length();) {
                buff[i / 2] = (byte) (Character.digit(hexstr.charAt(i++), 16) << 4 | Character
                        .digit(hexstr.charAt(i++), 16));
            }
            for (byte b : buff) {
                System.out.print(b + " ");
            }
            System.out.print("\n");
            System.out.println(new String(decrypt("BY2012@gbiac.com".getBytes(), buff)));
        }

        // {
        //
        // byte[] decodeBuffer = dec.decodeBuffer("EaF4VKykaGrzEjHbgtXkxw==");
        // System.out.println(new String(decrypt("BY2012@gbiac.com".getBytes(), decodeBuffer)));
        // System.out.println(new String(decrypt("BY2012@gbiac.com".getBytes(),
        // base.decode("EaF4VKykaGrzEjHbgtXkxw=="))));
        // System.out.println(new String(decrypt("BY2012@gbiac.com".getBytes(),
        // Base64.decodeBase64("EaF4VKykaGrzEjHbgtXkxw=="))));
        //
        // byte[] encryptedBuffer = encrypt("BY2012@gbiac.com".getBytes(), "123456798".getBytes());
        // System.out.println("AES：" + enc.encode(encryptedBuffer));
        // System.out.println("AES：" + new String(base.encode(encryptedBuffer)));
        // System.out.println("AES：" + base.encodeAsString(encryptedBuffer));
        // System.out.println("AES：" + base.encodeToString(encryptedBuffer));
        // System.out.println("AES：" + base.encodeBase64String(encryptedBuffer));
        // System.out.println("==============================================");
        //
        // byte[] b = new byte[1024];
        // int length;
        // byte[] encodedBuffer = base.encode(encryptedBuffer);
        // ByteArrayInputStream bis3 = new ByteArrayInputStream(encodedBuffer);
        // length = bis3.read(b);
        // for (int i = 0; i < length; i++) {
        // System.out.print(b[i] + " ");
        // }
        // System.out.println();
        // System.out.println(new String(b, 0, length));
        //
        // Base64InputStream bis1 = new Base64InputStream(new ByteArrayInputStream(encodedBuffer),
        // false);
        //
        // length = bis1.read(b);
        // for (int i = 0; i < length; i++) {
        // System.out.print(b[i] + " ");
        // }
        // byte[] bb = Arrays.copyOfRange(b, 0, length);
        //
        // System.out.println();
        // System.out.println(new String(decrypt("BY2012@gbiac.com".getBytes(), bb)));
        //
        // System.out.println();
        // }

        // System.out.println("SHA：" + base.encodeAsString(shadecrypt("123456".getBytes())));

        // {
        // InputStream is = new FileInputStream(new File("D:\\baiyun\\logo\\108006(1).jpg"));
        // ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // IOUtils.copy(is, baos);
        //
        // String base64img = enc.encode(baos.toByteArray());
        // File output = new File("e:/o.txt");
        // FileOutputStream fos = new FileOutputStream(output);
        // fos.write(base64img.getBytes("utf-8"));
        // fos.flush();
        // fos.close();
        // System.out.println(base64img);
        //
        // BufferedImage bi = ImageIO.read(new ByteArrayInputStream(dec.decodeBuffer(base64img)));
        // ImageIO.write(bi, "jpg", new File("e:/a.jpg"));
        // }

        // {
        // MessageDigest md5 = MessageDigest.getInstance("md5");
        // md5.update("510470".getBytes("utf-8"));
        // byte b[] = md5.digest();
        // System.out.println(enc.encode(new String(Hex.encodeHex(b, false)).getBytes("utf-8")));
        // for (byte i : b) {
        // System.out.printf("%02X", i);
        // }
        // System.out.printf("\n");
        // System.out.println(Hex.encodeHex(b, false));
        // System.out.println();
        // }

    }
}
