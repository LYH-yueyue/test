package com.liu.util;

import com.liu.pojo.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ClassUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.*;
import java.lang.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class Lv_util {

    private final static Boolean SUCCESS = true;

    private final static Boolean ERROR = false;

    public static String pathName;//项目的根目录

    static {
        try {
            pathName = URLDecoder.decode(ClassUtils.getDefaultClassLoader().getResource("").getPath(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    /**
     * 判断是否成功
     *
     * @param i
     * @return
     */
    public final static Boolean Judge(int i) {
        if (i > 0) return SUCCESS;
        return ERROR;
    }

    /**
     * 上传文件
     *
     * @param file:需要上传的文件的字节流
     * @param filePath:文件的路径
     * @param fileName:文件的名字
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);

        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 文本文件的读取
     *
     * @param fileName:路径字符串
     * @return
     */
    public static String readFileContent(String fileName) {
        File file = new File(fileName);//创建文件
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

}
