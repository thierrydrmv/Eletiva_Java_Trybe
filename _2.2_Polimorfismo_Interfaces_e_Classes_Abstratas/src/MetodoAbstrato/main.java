package MetodoAbstrato;

public class main {
    public static void main(String[] args) {
        Programmer Robert = new Programmer("Robert", 33);
        Robert.hobby();
        System.out.println(Robert.getAge());
        Streamer Nath = new Streamer("Nath", 22);
        Nath.hobby();
    }
}
