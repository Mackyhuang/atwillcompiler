package vip.ifmm.atwillcompiler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: MackyHuang
 * @eamil: 973151766@qq.com
 * @createTime: 2019/3/3 15:34
 */
@Controller
public class IndexController {

//    @GetMapping({"/", "/index"})
//    public String index(){
//        return "index";
//    }

    @GetMapping({"/", "/compiler"})
    public String compiler(){
        return "compiler";
    }
}
