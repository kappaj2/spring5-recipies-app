package za.co.ajk.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller     
public class IndexController {
    
    /**
     * Map multiple request endpoints. Return index.html thymeleaf file.
     * @return
     */
    @RequestMapping({"", "/", "index"})
    public String getIndexPage(){
        System.out.println("Requested index 34");
        return "index";
    }

}
