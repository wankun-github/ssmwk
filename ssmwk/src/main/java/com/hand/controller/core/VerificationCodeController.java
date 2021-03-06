package com.hand.controller.core;

import com.hand.util.ValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by wankun on 2017/7/11.
 */

@Controller
@RequestMapping(value="/validateCode")
public class VerificationCodeController {
    /**
     * 响应验证码页面
     * @return
     */
    @RequestMapping(value="/creatValidateCode")
    public String creatValidateCode(HttpServletRequest request,HttpServletResponse response) throws Exception{
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();

        ValidateCode vCode = new ValidateCode(120,44,5,10);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
        return null;
    }
}
