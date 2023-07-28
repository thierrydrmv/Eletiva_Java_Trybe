public class Email {
  public void enviar(String email) {
    // TODO
    String[] campos = email.split(";");

    String de = campos[0];
    String para = campos[1];
    String copiaOcultaPara = campos[2];
    String assunto = campos[3];
    String mensagem = campos[4];

    // Simular o envio do email
    System.out.println("De: " + de + "\n" +
        "Para: " + para + "\n" +
        "CC: " + copiaOcultaPara + "\n" +
        "Assunto: " + assunto + "\n" +
        "Mensagem: " + mensagem);
  }
}
