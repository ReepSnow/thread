package com.reepsnow.io;


import org.apache.commons.io.IOUtils;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
public class CommonsIo {
    @Test
    public void testIOUtils1() throws Exception {
        InputStream in = new URL( "http://haishang.cn-bj.ufileos.com/promotions.tgz" ).openConnection().getInputStream();
        readInputStream(in);
    }
    public static void readInputStream(InputStream inStream) throws Exception{
        OutputStream op = new FileOutputStream("D:\\Users\\down\\promotions.tar.gz");
        //创建一个Buffer字符串  promotions.tar.gz
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
    @Test
    public void test3(){

    }


        /**
         * 改变图片的大小到宽为size，然后高随着宽等比例变化
         * @param is 上传的图片的输入流
         * @param os 改变了图片的大小后，把图片的流输出到目标OutputStream
         * @param size 新图片的宽
         * @param format 新图片的格式
         * @throws IOException
         */
        public static OutputStream resizeImage(InputStream is, OutputStream os, int size, String format) throws IOException {
            BufferedImage prevImage = ImageIO.read(is);
            double width = prevImage.getWidth();
            double height = prevImage.getHeight();
            double percent = size/width;
            int newWidth = 800;
            int newHeight = 800;
            BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);
            Graphics graphics = image.createGraphics();
            graphics.drawImage(prevImage, 0, 0, newWidth, newHeight, null);
            ImageIO.write(image, format, os);
            os.flush();
            is.close();
            os.close();
            ByteArrayOutputStream b = (ByteArrayOutputStream) os;
            return os;
        }

        public static void main(String[] args) {
            try {
                InputStream is = new URL( "http://106.75.50.51:8000/nscontent/ImageGallery/store/product/Zoom/17/_11397777.jpg?crop=pad&pad_color=FFF&format=jpeg&w=380&h=583").openConnection().getInputStream();
                OutputStream os = new FileOutputStream(new File("D:\\Users\\down\\qrcode_test_1.jpg"));
                resizeImage(is, os, 800, "png");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    @Test
    public void test4(){
        File root = new File("D:\\Users\\down\\2017-07-12\\promotions");
        List<File> files = new ArrayList<File>();
        if(!root.isDirectory()){
            files.add(root);
        }
    }
}
