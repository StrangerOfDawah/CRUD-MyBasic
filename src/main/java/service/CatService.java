package service;

import domain.Cat;
import mappers.CatMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CatService {

    public void insertCat(Cat cat) {
        //TO DO: long id = UUID.randomUUID().getLeastSignificantBits();
        SqlSession sqlSession = MyBatisUtil.getFactory().openSession();
        try {
            CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
            catMapper.insertCat(cat);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    public Cat getCatById(Integer catId) {
        SqlSession sqlSession = MyBatisUtil.getFactory().openSession();
        try{
            CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
            return catMapper.getCatById(catId);
        }finally {
            sqlSession.close();
        }
    }


    public List<Cat> getAllCats() {
        SqlSession sqlSession = MyBatisUtil.getFactory().openSession();
        try {
            CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
            return catMapper.getAll();
        } finally {
            sqlSession.close();
        }
    }

    public void updateCat(Cat cat) {
        SqlSession sqlSession = MyBatisUtil.getFactory().openSession();
        try {
            CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
            catMapper.updateCat(cat);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteCat(Integer catId) {
        SqlSession sqlSession = MyBatisUtil.getFactory().openSession();
        try {
            CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
            catMapper.deleteCat(catId);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
