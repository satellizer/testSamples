import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

public class NameService {

	/**
	 * @param args
	 */

	private InputStream fileNames;
	private Map<String, String> kv = null;
	private boolean isInitialed = false;
	private static Logger logger = Logger.getLogger("info");
	private static Pattern pattern = Pattern.compile("(\\d+)=(.*)");
	private static Pattern seq = Pattern.compile("(\\d+)");

	private void init() {

		if (isInitialed) {
			return;
		} else {
			isInitialed = true;

			BufferedInputStream bufis = null;
			ByteArrayOutputStream bos = null;
			Matcher matcher = null;
			try {
				kv = new HashMap<String, String>();
				InputStream is = fileNames;

				bufis = new BufferedInputStream(is);
				bos = new ByteArrayOutputStream();
				IOUtils.copy(bufis, bos);
				byte[] dataBuff = bos.toByteArray();

				String data = new String(dataBuff, "utf-8");
				// System.out.println(data);
				matcher = pattern.matcher(data);
				while (matcher.find()) {

					kv.put(matcher.group(1), matcher.group(2));

				}

			} catch (FileNotFoundException e) {

				logger.info(e.getMessage());
			} catch (IOException e) {
				logger.info(e.getMessage());
			} finally {
				try {
					bufis.close();
				} catch (IOException e) {
					logger.info(e.getMessage());
				}
				try {
					bos.close();
				} catch (IOException e) {
					logger.info(e.getMessage());
				}
			}
		}

	}

	public NameService(InputStream is) {
		fileNames = is;
		init();
	}

	public String findName(String fileName) {

		Matcher matcher = seq.matcher(fileName);
		if (matcher.find())
			return kv.get(matcher.group(0));
		return null;
	}

	public void sort() throws IOException {
		File opt = new File("5_sort.txt");
		if (!opt.exists()) {
			opt.createNewFile();
		}
		FileWriter fw = new FileWriter(opt);
		if (null != kv || !kv.isEmpty()) {
			Object[] keySet = kv.keySet().toArray();
			Arrays.sort(keySet);
			fw.write("#key=value#\n");
			for (Object key : keySet) {
				fw.write(key + "=" + kv.get(key) + "\n");
			}
		}

		fw.close();
	}

	public static void main(String[] args) throws FileNotFoundException {

		InputStream is = new FileInputStream(new File("resources/1.txt"));
		NameService ns = new NameService(is);
		for (String s : ns.kv.keySet()) {
			System.out
					.println("insert into shopmember(id,shopname,buildid) values("
							+ s + ",'" + ns.kv.get(s).replace("'", "''") + "'," + 2 + ");");
		}

	}

}
