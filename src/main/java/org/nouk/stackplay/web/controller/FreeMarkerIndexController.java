package org.nouk.stackplay.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @author:
 * @date: 2021/7/16 18:40
 **/
@Controller //标示为controller层
public class FreeMarkerIndexController {
    @RequestMapping("/")//请求路径，会去templates下去寻找freemarkerindex
    public String freemarkerindexController() {
        return "/eova/login.html";//返回templates的结果
    }
}