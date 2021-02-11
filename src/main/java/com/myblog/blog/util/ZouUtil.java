package com.myblog.blog.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


public class ZouUtil {
    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    public static Timestamp getTime() {return new Timestamp(new Date().getTime());}

    // 文件做base64编码
    public static String getData(String localurl) throws IOException {
        InputStream in = null;
        byte[] data = null;

        in = new FileInputStream(localurl);
        data = new byte[in.available()];
        in.read(data);
        in.close();
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
