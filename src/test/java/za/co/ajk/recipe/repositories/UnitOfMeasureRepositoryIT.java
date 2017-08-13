package za.co.ajk.recipe.repositories;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import za.co.ajk.recipe.domain.UnitOfMeasure;

import static org.junit.Assert.*;

/**
 * Integration test as we will be bring up DB and use Sping injection
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
    
    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;
    
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void findByDescriptionTeaspoon() throws Exception {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        assertEquals("Teaspoon", uomOptional.get().getDescription());
    }
    
    /**
     * This will run must faster as Spring context already up. Not reloading context.
     * Add @DirtiesContext to above method which will cause a context reload when finished. Will show increase in test time!
     * @throws Exception
     */
    @Test
    public void findByDescriptionCup() throws Exception {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
        assertEquals("Cup", uomOptional.get().getDescription());
    }
}