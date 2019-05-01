package service;

import domain.Cat;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CatServiceTest {
    private static CatService catService;
    @BeforeClass
        public static void setup(){
        catService = new CatService();
    }
    @AfterClass
        public static void turnDown(){
        catService = null;
    }

        @Test
    public void testGetCatById(){
        Cat cat = catService.getCatById(1);
        assertNotNull(cat);
        System.out.println(cat);
    }

    @Test
    public void testGetAllCats(){
        List<Cat> cats = catService.getAllCats();
        assertNotNull(cats);
        for(Cat cat: cats){
            System.out.println(cat);
        }
    }

    @Test
    public void testInsertCat(){
        Cat cat = new Cat();
        cat.setBreed("half-breed");
        cat.setSex("female");
        cat.setAge(1);


        catService.insertCat(cat);
        assertTrue(cat.getId()!= 0);
        Cat createdCat = catService.getCatById(cat.getId());
        assertNotNull(createdCat);
        assertEquals(cat.getAge(), createdCat.getAge());
        assertEquals(cat.getSex(), createdCat.getSex());
        assertEquals(cat.getBreed(), createdCat.getBreed());
    }

    @Test
    public void testUpdateCat(){
        long timestamp = System.currentTimeMillis();
        Cat cat = catService.getCatById(2);
        cat.setBreed("TestBritish"+timestamp);
        cat.setSex("TestMale"+timestamp);
        catService.updateCat(cat);
        Cat updatedUser = catService.getCatById(2);
        Assert.assertEquals(cat.getBreed(), updatedUser.getBreed());
        Assert.assertEquals(cat.getSex(), updatedUser.getSex());
    }
}