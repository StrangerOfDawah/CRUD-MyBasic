public class Cat {
    private int id;
    private String breed;
    private String sex;
    private int age;

    public Cat() {
    }

    public Cat(String breed, String sex, int age) {
        super();
        this.breed = breed;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "InfoOfCats: \n" +
                "Cat's Id: "    + getId()    + "\n" +
                "Cat's breed: " + getBreed() + "\n" +
                "Cat's sex: "   + getSex()   + "\n" +
                "Cat's age: "   + getAge();
    }
}
