package com.hand.util;

/**
 * Created by wankun on 2017/7/11.
 */

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.util.Random;

/**
 * ttf字体文件
 * @author dsna
 *
 */
public class ImgFontByte {
    private String[] fontSequence = { "华文彩云", "宋体","微软雅黑","黑体","楷体","幼圆"};
    public Font getFont(int fontHeight){
        try {
            Font baseFont = Font.createFont(Font.TRUETYPE_FONT, new ByteArrayInputStream(hex2byte(getFontByteStr())));
            return baseFont.deriveFont(Font.PLAIN, fontHeight);
        } catch (Exception e) {
            Random random = new Random();
            String strRand = String.valueOf(fontSequence[random.nextInt(fontSequence.length)]);
            return new Font(strRand,Font.PLAIN, fontHeight);
            //return new Font("华文彩云",Font.PLAIN, fontHeight);
        }
    }

    private  byte[] hex2byte(String str) {
        if (str == null)
            return null;
        str = str.trim();
        int len = str.length();
        if (len == 0 || len % 2 == 1)
            return null;

        byte[] b = new byte[len / 2];
        try {
            for (int i = 0; i < str.length(); i += 2) {
                b[i / 2] = (byte) Integer
                        .decode("0x" + str.substring(i, i + 2)).intValue();
            }
            return b;
        } catch (Exception e) {
            return null;
        }
    } /**
     * ttf字体文件的十六进制字符串
     * @return
     */
    private String getFontByteStr(){ return null;
        //return str;//字符串太长 在附件中找
    }
}