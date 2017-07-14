package com.reepsnow.compr;

/**
 * Created by Administrator on 2017/7/10.
 */
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        //需要下载commons-net-ftp-2.0.jar包下载地址：http://download.csdn.net/detail/u010696272/8006739

        //第一步：获取一个文件夹下的所有的文件
        List<File> files = FileMy.getFiles("D:\\test");
        List<File> sources = new ArrayList<File>();
        for(File f : files){
            System.out.println(f.getName());
            System.out.println(f.toURI());
            sources.add(f);
        }
        //第二步：把获取的文件下的文件压缩成一个tar文件 ，sources：要压缩的文件，target压缩的路径
        File target = new File("D:\\test2\\release_package.tar");
        FileMy.compress(GZIPUtil.pack(sources, target));

        try {
            //第三步把tar文件压缩成tar.gz文件也就是gzip文件，siuress:要压缩的tar文件，gzget：压缩后的gz文件
            String siuress ="D:/test2/release_package.tar";
            String gzget = "D:/test2/release_package.tar.gz";
            GZipUtils.compress(siuress, gzget);
            //第四步解压：把gz文件解压成tar文件,sougz:要解压的gz,tar：解压后的tar文件
            String sougz= "D:/test2/release_package.tar.gz";
            String tar ="D:/test2/123.tar";
            GZipUtils.decompress(sougz, tar);
            //第五步，解压tar文件，soufile:要解压的tar路径,srcfile：后放的路径
            String soufile = "D:\\test2\\release_package.tar";
            String srcfile = "D:\\test2\\text";
            TarUtils.dearchive(soufile,srcfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test1(){
        try {
            //第四步解压：把gz文件解压成tar文件,sougz:要解压的gz,tar：解压后的tar文件
            String sougz= "D:\\Users\\down\\promotions.tar.gz";
            String tar ="D:\\Users\\down\\promotions.tar";
            GZipUtils.decompress(sougz, tar);
            //第五步，解压tar文件，soufile:要解压的tar路径,srcfile：后放的路径
            String soufile = "D:\\Users\\down\\promotions.tar";
            String srcfile = "D:\\Users\\down\\promotions";
            TarUtils.dearchive(soufile,srcfile);
            List<File> fileList = FileMy.getFiles(srcfile);
            for (File file:fileList){
                if(!file.getName().contains("._")){
                    InputStream inputStream = new FileInputStream(file);
                    String str = IOUtils.toString(inputStream);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}