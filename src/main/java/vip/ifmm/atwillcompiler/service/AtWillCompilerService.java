package vip.ifmm.atwillcompiler.service;

/**
 * @author: MackyHuang
 * @eamil: 973151766@qq.com
 * @createTime: 2019/3/3 16:21
 */
public interface AtWillCompilerService {

    void compile(String filePath);

    String runtime(String classPath, String filePrefix);

    String run(String codeInfo);
}
