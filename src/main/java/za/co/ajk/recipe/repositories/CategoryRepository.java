package za.co.ajk.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import za.co.ajk.recipe.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
    
}
