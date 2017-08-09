package za.co.ajk.recipe.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import za.co.ajk.recipe.domain.Category;
import za.co.ajk.recipe.domain.UnitOfMeasure;
import za.co.ajk.recipe.repositories.CategoryRepository;
import za.co.ajk.recipe.repositories.UnitOfMeasureRepository;

@Controller     
public class IndexController {
    
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    
    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }
    
    /**
     * Map multiple request endpoints. Return index.html thymeleaf file.
     * @return
     */
    @RequestMapping({"", "/", "index"})
    public String getIndexPage(){
        System.out.println("Requested index 34");
    
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
    
        System.out.println("Cat id is : "+categoryOptional.get().getId());
        System.out.println("UOM id is : "+unitOfMeasureOptional.get().getId());
      
        return "index";
    }

}
