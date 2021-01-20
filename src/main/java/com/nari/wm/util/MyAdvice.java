package com.nari.wm.util;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.util.Date;


@ControllerAdvice(basePackages = "com.nari.wm.controller",annotations = Controller.class)
public class MyAdvice {

    @InitBinder
    public void initBander(WebDataBinder dataBinder){
        System.out.println("格式化日期了");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor customDateEditor = new CustomDateEditor(sf,true);
        dataBinder.registerCustomEditor(Date.class,customDateEditor);
    }

    // model的参数只能在，jsp里面获取吧

    @ModelAttribute
    public void editeModel(Model model){
        model.addAttribute("name","wm");
    }

    @ExceptionHandler
    public String exceptionHandler(Model model,Exception ex){
        model.addAttribute("erroe",ex.getMessage());
        return ex.getMessage();
    }

}
