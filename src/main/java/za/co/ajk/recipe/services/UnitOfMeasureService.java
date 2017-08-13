package za.co.ajk.recipe.services;

import java.util.Set;

import za.co.ajk.recipe.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {
    
    Set<UnitOfMeasureCommand> listAllUoms();
}
