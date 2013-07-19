import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Hex;

/*
 * @(#) test14_cutfile.java
 * @Author:windheaven(mail) 2013-6-26
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */

/**
  * @author windheaven(mail) 2013-6-26
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function 类功能说明
  */
public class test14_cutfile {

    /**
      * 创建一个新的实例 
      */
    public test14_cutfile() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        try {
            File file = new File("original.LOD");
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] data = new byte[(int) (file.length() - 4)];
            bis.read(data);

            File newFile = new File("original");
            FileOutputStream fos = new FileOutputStream(newFile);
            File newFileX = new File("originalX");
            FileOutputStream fosX = new FileOutputStream(newFileX);

            fosX.write(new String(Hex.encodeHex(data)).toUpperCase().getBytes("utf-8"));
            fosX.close();

            fos.write(data);
            fos.flush();
            fos.close();
            bis.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
