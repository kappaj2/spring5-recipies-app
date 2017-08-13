package za.co.ajk.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;
import za.co.ajk.recipe.commands.CategoryCommand;
import za.co.ajk.recipe.domain.Category;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
    
    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null) {
            return null;
        }
        
        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
