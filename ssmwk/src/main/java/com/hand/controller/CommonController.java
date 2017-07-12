package com.hand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wankun on 2017/7/6.
 */

@Controller
@RequestMapping("/common")
public class CommonController {

    /**
     * 跳转页面(pageName.jsp)
     * @param pageName
     * @return
     */
    @RequestMapping(value = "/toHtml",method = RequestMethod.GET)
    public String tohtml(String pageName){
        return pageName;
    }

}
