import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Main {

    static String resource = "mybatis-config.xml";
    static InputStream inputStream = null;
    static SqlSession session = null;
    Main() {
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();

        } catch (Exception e) {
            throw ExceptionFactory.wrapException("Error committing transaction.  Cause: " + e, e);
        }
    }

    public static void main(String[] args) {

        Main work = new Main();
        work.create();
        work.readOne();
        work.readAll();
        work.update();
        work.delete();
    }


    private void create(){
        try{

            Cat cat = new Cat("persian","female", 3);  //Create a new Cat object
            session.insert("Cat.create", cat);                     //Insert Cat data
            System.out.println("Record inserted successfully");
            session.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readOne(){
        //Select a particular cat  by  id
        Cat cat = (Cat) session.selectOne("Cat.getById", 2);
        System.out.println(cat);
    }


    private void readAll(){
        //Select all cats
        List<Cat> cat = session.selectList("Cat.getAll");
        for(Cat theCat : cat ){
            System.out.println(theCat);
        }

        System.out.println("Records Read Successfully ");
        session.commit();
        session.close();
    }

    private void update(){
        //Select a particular cat using id
        Cat cat = (Cat) session.selectOne("Cat.getById", 1);
        System.out.println("Current details of the cat are" );
        System.out.println(cat.toString());

        //Set new values to the breed, sex and age for the cat
        cat.setBreed("british");
        cat.setSex("male");
        cat.setAge(3);

        //Update the cat record
        session.update("Cat.update",cat);
        System.out.println("Record updated successfully");
        session.commit();
        session.close();

        //Verifying the record
        cat = (Cat) session.selectOne("Cat.getById", 1);
        System.out.println("Details of the cat after update operation" );
        System.out.println(cat.toString());
        session.commit();
        session.close();
    }

    private void delete(){
        //Delete operation
        session.delete("Cat.deleteById", 2);
        session.commit();
        session.close();
        System.out.println("Record deleted successfully");
    }
}
