import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;


/**
  * @author windheaven(mail) 2013-5-20
  * @version 1.0
  * @modifyed by windheaven(mail) description
  * @Function remove the exif information form the image
  */
public class RemoveExif {

    /**
      * main(这里用一句话描述这个方法的作用)
      * @param args
     * @throws IOException 
     * @throws SQLException 
     * @throws ClassNotFoundException 
      */
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        // getConn();

        String folderName = "ALL-2013-5-20";
        String a = new String("D:/tmp/" + folderName);
        String dst = new String("D:/tmp/logo/" + folderName);
        File sampleFolder = new File(a);
        File dstFolder = new File(dst);

        if (!dstFolder.exists()) {
            dstFolder.mkdirs();
        }

        for (File f : sampleFolder.listFiles()) {
            if (f.getName().endsWith("jpg")) {
                BufferedImage src = ImageIO.read(f);
                BufferedImage dstImg = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());
                File copyImg = new File(dst + File.separator + f.getName());
                dstImg.getGraphics().drawImage(src, 0, 0, null);
                dstImg.getGraphics().dispose();
                if (!ImageIO.write(dstImg, "jpg", copyImg)) {

                    System.out.printf("error copying file: \n" + f.getName());
                }
            } else {
                System.out.printf("error suffix of file: \n" + f.getName());
            }
        }
        System.out.printf("done!\n");

    }
}
