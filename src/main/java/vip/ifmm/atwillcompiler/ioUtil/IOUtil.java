package vip.ifmm.atwillcompiler.ioUtil;

import org.apache.logging.log4j.util.Strings;

import java.io.*;

/**
 * @author: MackyHuang
 * @eamil: 973151766@qq.com
 * @createTime: 2019/3/3 16:04
 */
public class IOUtil {

    public static String Input2String(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String result = "";
        String info = "";
        while ((info = bufferedReader.readLine()) != null){
            System.out.println(info);
            result += info;
        }
        return result;
    }

    public static String String2TempFile(String codeInfo) throws IOException {
        final File tempFile = File.createTempFile("Hello", ".java");
        //获取真实地文件名，为了后面将类名改成这个
        String realFileName = tempFile.getName().substring(0, tempFile.getName().lastIndexOf("."));
        String code = IOUtil.modifyClassName(codeInfo, realFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile)));
        bufferedWriter.write(code, 0, code.length());
        bufferedWriter.flush();
        bufferedWriter.close();
        tempFile.deleteOnExit();
        return tempFile.getCanonicalPath();
    }

    public static String modifyClassName(String codeInfo, String className){
        String result = codeInfo.replaceFirst("public class (.+)\\{", "public class " + className + "{");
        return result;
    }
}
