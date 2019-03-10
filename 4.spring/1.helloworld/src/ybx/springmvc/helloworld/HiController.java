package ybx.springmvc.helloworld;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // 这里导入了一个Model类
import org.springframework.web.bind.annotation.RequestMapping;
//http://localhost:8080/hi/say.form
@Controller
@RequestMapping("/hi")
public class HiController {
    @RequestMapping("/say")
    public String say(Model model) {// 参数中传入Model
        model.addAttribute("name","wormday"); // 指定Model的值
        model.addAttribute("url","http://www.cnblogs.com/wormday/p/8435617.html"); // 指定Model的值
        //return "/WEB-INF/jsp/say.jsp";
        return "say";
    }
}
