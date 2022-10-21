package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    public void findByDescription() {

        Optional<UnitOfMeasure> optional = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", optional.get().getDescription());

    }

    @Test
    @DirtiesContext
    public void findByDescriptionCup() {

        Optional<UnitOfMeasure> optional = unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", optional.get().getDescription());

    }
}