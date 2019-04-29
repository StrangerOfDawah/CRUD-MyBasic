
public class Main {

    public static void main(String[] args) {

        CadDao dao = new CadDao();
        dao.create();
        dao.readOne();
        dao.readAll();
        dao.update();
        dao.delete();
    }
}
