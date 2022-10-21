package guru.springframework.domain;

import junit.framework.TestCase;
import org.junit.Before;

public class CategoryTest extends TestCase {

    Category category;

    @Before
    public void setUp(){
        category = new Category();
    }

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