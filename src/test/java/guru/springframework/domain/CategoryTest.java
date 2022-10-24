package guru.springframework.domain;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    Category category;

    @Before
    public void setUp(){
        category = new Category();
    }

    @Test
    public void testGetId() {
        Long id = 5L;

        category.setId(id);

        assertEquals(id, category.getId());
    }

    public void testGetDescription() {
    }

    public void testGetRecipes() {
    }
}