package com.example.demo.file.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping(value = "/file")
public class FileUp {

    public final static Logger logger = LoggerFactory.getLogger(FileUp.class);

    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile multipartFile){


        try {
            if(multipartFile.isEmpty()){
                return "文件为空";
            }
            //获取文件名
            String fileName = multipartFile.getOriginalFilename();
            logger.info("上传的文件名：" + fileName);
            //获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            logger.info("文件的后缀名：" + suffixName);
            //设置文件的存储路径
            String filePath = "E://zhenshuo//";
            String path = filePath + fileName;

            File dest = new File(path);
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdir();//新建文件夹
            }
            multipartFile.transferTo(dest);
            return "上传成功";
        }catch (IllegalAccessError e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    @RequestMapping(value = "/download")
    public String downloadFile(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String fileName = "OTT-DMP标签体系1.5.xlsx";
        if(fileName != null){
            //设置文件路径
            String realPath = "E://zhenshuo//";
            File file = new File(realPath,fileName);
            if(file.exists()){
                httpServletResponse.setContentType("application/force-download");//设置强制下载不打开
                httpServletResponse.addHeader("Content-Disposition", "attachment;fileName=" + fileName);//设置文件名
                httpServletResponse.setHeader("content-type", "application/octet-stream");
                byte[] buffer = new byte[1024];
                FileInputStream fileInputStream = null;
                BufferedInputStream bufferedInputStream = null;
                try{
                    fileInputStream = new FileInputStream(file);
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    OutputStream os = httpServletResponse.getOutputStream();
                    int i = bufferedInputStream.read(buffer);
                    while (i != -1){
                        os.write(buffer,0,i);
                        i = bufferedInputStream.read(buffer);
                    }
                    logger.info("下载成功");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(bufferedInputStream != null){
                        try {
                            bufferedInputStream.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    if(fileInputStream != null){
                        try {
                            fileInputStream.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}
