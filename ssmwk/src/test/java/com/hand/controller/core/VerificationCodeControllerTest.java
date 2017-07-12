package com.hand.controller.core;

import com.hand.util.ValidateCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by wankun on 2017/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class VerificationCodeControllerTest {
    @Test
    public void createCode1() throws IOException {
        ValidateCode vCode = new ValidateCode(120,40,5,100);
        try {
            String path="D:/t/"+new Date().getTime()+".png";
            System.out.println(vCode.getCode()+" >"+path);
            vCode.write(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}