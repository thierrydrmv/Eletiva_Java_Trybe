package Interface;

public class Main {
    public static void main(String[] args) {
        Person thierry = new Person();
        System.out.println(thierry.trabalho());
        // Polimorfismo com interface
        Emprego bob = new Person();
        System.out.println(bob.trabalho());
        Student Robert = new Student();
        Robert.setLanguage("Java");
        System.out.println(Robert.mainSkill());
    }
}
