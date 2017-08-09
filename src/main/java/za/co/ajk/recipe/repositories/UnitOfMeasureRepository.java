package za.co.ajk.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import za.co.ajk.recipe.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    
}
