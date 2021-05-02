package com.theindianmaharajatours.app.services;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Service
public class DownloadService {

    public void downloadFile(HttpServletResponse response,String fileName, InputStream inputStream){
        try {
            response.setHeader("Content-Disposition", "inline;filename=\"" + fileName + "\"");
            OutputStream out = response.getOutputStream();
            IOUtils.copy(inputStream, out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
