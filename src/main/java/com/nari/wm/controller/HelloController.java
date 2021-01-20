package com.nari.wm.controller;

import com.nari.wm.brl.ExportPdfService;
import com.nari.wm.brl.impl.ExportPdfServiceImpl;
import com.nari.wm.entity.Sc;
import com.nari.wm.model.User;
import com.nari.wm.util.PdfView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    @Autowired
    ExportPdfService exportPdfService;

    @RequestMapping(path = "/hello")
    @ResponseBody
    public  Map<String,String> hello(@RequestParam("name") String aa, String age, String [] arrys){
        Map<String,String> res = new HashMap<>();
        res.put("name",aa);
        res.put("age",age);
        for(String itme :arrys){
            System.out.println(itme+itme.getClass());
        }
        return res;
    }

    @GetMapping("/rest/{id}/{time}")
    public Date getRest(@PathVariable("id") String id,@PathVariable("time") Date time){
        return time;
    }

    @GetMapping(value = "/getUser")
    public User getUser(@Validated User user){
        return user;
    }


    @GetMapping(value = "/getPdf")
    public ModelAndView getPdf(){
        List<Sc> all = exportPdfService.getAll();
        View view = new PdfView(new ExportPdfServiceImpl());

        ModelAndView mv = new ModelAndView();
        mv.setView(view);
        mv.addObject("data",all);
        return mv;
    }

    @GetMapping(value = "/interceptor/hello")
    public String testInterceptor(){
        return "测试拦截器";
    }

    @GetMapping("/getModelData")
    public Map<String,Object> getModelData(@SessionAttribute("token") String na,@RequestHeader("User-Agent") String name,@RequestHeader("Content-Type") String type){
        Map<String,Object> map = new HashMap<>();
        map.put("agent",name);
        map.put("cookie",type);
        return map;
    }


}
