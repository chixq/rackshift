import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class I18NTest {

    public static void main(String[] args) throws IOException {
        File file = new File("E:\\rackshift\\rackshift-web\\src\\rackparams");
        File file2 = new File("E:\\rackshift\\rackshift-web\\src\\i18n\\zh-CN.json");
        BufferedReader reader = new BufferedReader(new FileReader(file2));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        JSONObject i18n = JSONObject.parseObject(sb.toString());
        i18n = new JSONObject();
        sb.setLength(0);
        if (file.isDirectory()) {
            for (File listFile : file.listFiles()) {
                if (listFile.isDirectory()) {
                    for (File file11 : listFile.listFiles())
                        extract(file11, i18n);
                } else {
                    extract(listFile, i18n);
                }
            }
        }

        for (Map.Entry o : i18n.entrySet()) {
            System.out.println("\"" + o.getKey() + "\"" + ":" + "\"" + o.getValue() + "\",");
        }
    }

    private static void extract(File listFile, JSONObject i18n) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(listFile));
        String line = null;
        StringBuffer sb = new StringBuffer();

        if (listFile.getName().contains("js") || listFile.getName().contains("vue")) {
            line = null;
            sb = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            Pattern p = Pattern.compile("\\$t\\('([\\w]+)'\\)");
//                            Pattern p = Pattern.compile("^\\w+'(i18n_[\\w]+)' | translator :'([\\u4e00-\\u9fa5]+)'");
            Matcher m = p.matcher(sb.toString());
            while (m.find()) {
                if (!i18n.containsKey(m.group(1).trim())) {
                    i18n.put(m.group(1), null);
                }
            }
        }
    }
}
