package MetodoAbstrato;

public class Programmer extends Person{

    public Programmer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void hobby() {
        System.out.println("Climbing");
    }
}
