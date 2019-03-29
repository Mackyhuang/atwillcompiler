package vip.ifmm.atwillcompiler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.ifmm.atwillcompiler.service.AtWillCompilerService;
import vip.ifmm.atwillcompiler.vo.Result;

/**
 * @author: MackyHuang
 * @eamil: 973151766@qq.com
 * @createTime: 2019/3/3 21:26
 */
@Controller
public class CompilerController {

    @Autowired
    private AtWillCompilerService compilerService;

    @PostMapping("/run")
    @ResponseBody
    public Result compiler(String codeinfo){
        String runResult = compilerService.run(codeinfo);
        Result result = new Result();
        result.setInfo(runResult);
        return result;
    }
}
