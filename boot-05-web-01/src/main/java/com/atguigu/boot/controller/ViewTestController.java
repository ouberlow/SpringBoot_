package com.atguigu.boot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {
 /*
 不论控制器返回一个String,ModelAndView,View都会转换为ModelAndView对象，由视图解析器解析视图，然后，进行页面的跳转
  */
    @GetMapping("/atguigu")
    public String atguigu(Model model){

        //model中的数据会被放在请求域中 request.setAttribute("a",aa)
        model.addAttribute("msg","你好 guigu");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
