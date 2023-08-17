package MetodoAbstrato;

public class Streamer extends Person{
    public Streamer(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public void hobby() {
        System.out.println("Walking");
    }
}
