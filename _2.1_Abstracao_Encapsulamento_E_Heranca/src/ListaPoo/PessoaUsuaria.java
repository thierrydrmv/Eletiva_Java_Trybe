package ListaPoo;

public class PessoaUsuaria extends Pessoa {
    public PessoaUsuaria(String nome, String sobrenome) {
       super(nome, sobrenome);
    }
    public String getPessoaUsuaria() {
        if (nome == null || nome.isEmpty() || sobrenome == null || sobrenome.isEmpty()) {
            return "Pessoa usuária inválida";
        }
        return this.nome + '.' + this.sobrenome;
    }
}
