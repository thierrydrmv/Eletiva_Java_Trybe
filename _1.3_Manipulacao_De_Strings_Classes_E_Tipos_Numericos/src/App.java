public class App {

  public static void main(String[] args) {
    String info = "noreply@mycompany.com;onetaxi@company.com;a;De {de} para {para};Bom dia amigo!";
    Email email = new Email();
    email.enviar(info);
  }
}
