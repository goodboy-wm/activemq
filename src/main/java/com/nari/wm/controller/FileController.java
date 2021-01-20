package com.nari.wm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FileController {



    @PostMapping(value = "/upload")
    @ResponseBody
    public Map<String,Object> upload(@RequestBody Part file){

        try {
            String fileName = file.getSubmittedFileName();
            file.write(fileName);
            return restFul(true,"保存成功");
        } catch (IOException e) {
            e.printStackTrace();
            return restFul(false,"保存失败");
        }
    }


    private Map<String,Object> restFul(Boolean flage,String message){
        Map<String,Object> res = new HashMap<>();
        res.put("isSuccess",flage);
        res.put("message",message);
        return res;
    }



}
