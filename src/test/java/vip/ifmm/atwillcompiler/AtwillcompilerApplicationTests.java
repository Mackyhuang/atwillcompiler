package vip.ifmm.atwillcompiler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vip.ifmm.atwillcompiler.ioUtil.IOUtil;
import vip.ifmm.atwillcompiler.service.AtWillCompilerService;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtwillcompilerApplicationTests {

    @Autowired
    private AtWillCompilerService compilerService;

    @Test
    public void contextLoads() {
//        String path = "C:/Users/MackyHuang/Desktop/Hello.java";
        String path = null;
            path = "public class Hello{\n" +
                    "    \n" +
                    "    public static void main(String[] args){\n" +
                    "        System.out.println(\"Hello World\");\n" +
                    "    }\n" +
                    "}";

//        System.out.println(path);
//        String prefix = path.substring(0, path.lastIndexOf(File.separator) + 1);
//        String suffix = path.substring(path.lastIndexOf(File.separator) + 1, path.lastIndexOf("."));
//        System.out.println(prefix + "__" + suffix);
//        compilerService.compile(path);
//        compilerService.runtime(prefix, suffix);
        String run = compilerService.run(path);
        System.out.println(run);
    }



}
