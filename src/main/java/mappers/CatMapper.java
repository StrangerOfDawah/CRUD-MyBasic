package mappers;

import domain.Cat;

import java.util.List;

public interface CatMapper {

    public void insertCat(Cat cat);

    public Cat getCatById(Integer catId);

    public List<Cat> getAll();

    public void updateCat(Cat cat);

    public void deleteCat(Integer catId);
}
