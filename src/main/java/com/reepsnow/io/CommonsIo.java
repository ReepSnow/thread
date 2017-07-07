package com.reepsnow.io;


import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by Administrator on 2017/7/7.
 */
public class CommonsIo {
    @Test
    public void testIOUtils1() throws Exception {
        InputStream in = new URL( "https://img0.fengqucdn.com/sf/skuInfos/1129161/9306444e0d164cec46745fef9be26681.jpeg" ).openConnection().getInputStream();
        readInputStream(in);
    }
    public static void readInputStream(InputStream inStream) throws Exception{
        OutputStream op = new FileOutputStream("D:\\22.jpeg");
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inStream.read(buffer)) != -1 ){
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            op.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
    }
    @Test
    public void testIOUtils2() throws IOException {
        InputStream in = new URL( "https://img0.fengqucdn.com/sf/skuInfos/1129161/9306444e0d164cec46745fef9be26681.jpeg" ).openConnection().getInputStream();
        OutputStream op = new FileOutputStream("D:\\22.jpeg");

        try {
            IOUtils.copy(in,op);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(op);
        }

    }
}
