public class Cat {
    String name;
    String catType;
    int age;

    public Cat (String name, int age, String catType){
        this.name = name;
        this.age = age;
        this.catType = catType;
    }

    public Cat(String name, int age){
        this(name,age,"Без породы");
    }

    private String getAllInfo() {
        return "Name - " + this.name + ", возраст - " + this.age + ", порода - " + this.catType;
    }

    public void printAllCatInfo() {
        String info = this.getAllInfo();
        System.out.println(info);
    }

    public void changeName (String newName) {
        this.name = newName;
    }
}
