public class SubClasse extends SuperClasse {
    public String nome = "SubClasse";
    public SubClasse() {
        System.out.println(super.nome);
        System.out.println(this.nome);
    }
}
