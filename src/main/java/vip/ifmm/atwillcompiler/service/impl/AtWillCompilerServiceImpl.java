package vip.ifmm.atwillcompiler.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vip.ifmm.atwillcompiler.ioUtil.IOUtil;
import vip.ifmm.atwillcompiler.service.AtWillCompilerService;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;

/**
 * @author: MackyHuang
 * @eamil: 973151766@qq.com
 * @createTime: 2019/3/3 15:39
 */
@Service
public class AtWillCompilerServiceImpl implements AtWillCompilerService {

    public void compile(String filePath){
        if (StringUtils.isEmpty(filePath)){
            return;
        }
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
//        1 编译器参数 2 标准输出 3 标准错误输出
        int result = javaCompiler.run(null, null, null, filePath);

    }

    public String runtime(String classPath, String filePrefix){
        if (StringUtils.isEmpty(classPath) || StringUtils.isEmpty(filePrefix)){
            return null;
        }

        try {
            String command = "java -cp " + classPath + " " + filePrefix;
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(command);
            String result = IOUtil.Input2String(process.getInputStream());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String run(String codeInfo) {
        if (StringUtils.isEmpty(codeInfo)){
            return null;
        }
        try {
            String filePath = IOUtil.String2TempFile(codeInfo);
            String prefix = filePath.substring(0, filePath.lastIndexOf(File.separator) + 1);
            String suffix = filePath.substring(filePath.lastIndexOf(File.separator) + 1, filePath.lastIndexOf("."));
            compile(filePath);
            String runtime = runtime(prefix, suffix);
            return runtime;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
