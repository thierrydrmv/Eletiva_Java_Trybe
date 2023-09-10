import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
            listas();
            sets();
    }

    public static void listas() {
        List<Integer> numeros = new ArrayList<Integer>();
        numeros.add(7);
        numeros.add(2);
        numeros.add(1);
        numeros.add(9);
        System.out.println(numeros);
        Collections.sort(numeros);
        System.out.println(numeros);
        numeros.add(3);
        System.out.println(numeros);
        System.out.println("Implementações de List");
        List<String> estudantes = Arrays.asList("João","Maria","Pedro","Rosa");
        System.out.println(estudantes);
        System.out.println("Lista imutavel");
        List<String> fixedStudents = List.of("João","Maria","Pedro","Rosa");
        String estudanteDoIndice2 = fixedStudents.get(2);
        System.out.println(estudanteDoIndice2);
        System.out.println("removendo elementos");
        estudantes.remove(1);
        System.out.println(estudantes);
        estudantes.remove("Pedro");
        System.out.println(estudantes);
        System.out.println("Verificando o tamanho com o size");
        System.out.println(estudantes.size());
        System.out.println("Verificando se possui o elemento com o contains(T)");
        System.out.println(estudantes.contains("João"));
    }
    public static void sets() {

    }
}

