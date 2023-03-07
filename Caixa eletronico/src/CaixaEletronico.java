
import java.util.Scanner;

public class CaixaEletronico {

    /* Aqui criamos uma variavel global. Global significa que o elemento pode ser acessado por qualquer método.
    Para tornar global, utilizamos a palavra static.*/
    static double saldo = 100;
    static int senha = 3589;
    static Scanner SC = new Scanner(System.in);
    static String nome;


    public static void main(String[] args) {
        System.out.println("Olá, qual é o seu nome?");
        nome = SC.nextLine();
        System.out.println("Olá " + nome + " é um prazer ter você por aqui!");
        System.out.println("Selecione uma opção 1.) Saldo 2.) Extratos 3.) Saque 4.) Depósito 5.) Transferencia 6.) Sair");

        Scanner entrar = new Scanner(System.in);
        int escolha = entrar.nextInt();

        switch (escolha){
            case 1:
                ver_saldo();
                break;
            case 2:
                extrato();
                break;
            case 3:
                fazer_saque();
                break;
            case 4:
                fazer_deposito();
                break;
            case 5:
                transferencia();
                break;
            case 6:
                sair();
                break;
            default:
                erro();
                break;
        }

        entrar.close();
    }

    public static void senha(){
        Scanner in = new Scanner(System.in);
        System.out.println("Ola " + nome + "Digite sua senha !!");
        int ver_senha = SC.nextInt();

        if (ver_senha != 2676){
            System.out.println("Senha incorreta, por favor tente novamente");
            senha();
        }
        else {
            System.out.println("Acesso liberado");
        }
    }

    /*  Um método simples que só exibe uma mensagem ao usuário e em seguida chama a função principal. */
    public static void ver_saldo() {
        senha();
        System.out.println("Seu saldo atual é: " + saldo);

        //O método "main" pode receber comandos diretamente da linha de comando. Quando isso não ocorre, usamos a palavra
        // "null" para avisar que nada será passado
        main(null);
    }

    /*  Método para receber informado pelo usuário, processar e levar a uma mensagem de sucesso ou a repetição da função */
    public static void fazer_deposito() {
        senha();
        System.out.println("Qual o valor a ser depositado?");
        Scanner valor = new Scanner(System.in);
        Double deposito = valor.nextDouble();

        // Not a Number
        boolean checaNumero = deposito.isNaN(); // o método isNaN retorna checa se o valor informado é um Não-Número e retorna verdadeiro ou falso.

        if (checaNumero || deposito <= 0) {
            System.out.println("Por favor, informe um número válido:");
            fazer_deposito();

        } else {
            saldo += deposito;
            System.out.println("Seu saldo atual é: " + saldo);
            main(null);
        }

        valor.close();
    }

    public static void transferencia(){
        senha();
        System.out.println("Olá " +nome+ ", Informe o numero da conta");
        Double transferir = SC.nextDouble();

        boolean verif = transferir.isNaN();

        if(verif || transferir <= 0){
            System.out.println("Por favor, informe um número válido:");
            transferencia();
        }else {
            System.out.println("Quanto deseja transferir?");
            Double valor = SC.nextDouble();
            boolean verificar = valor.isNaN();

            if(verificar || valor <= 0){
                System.out.println("Por favor, informe um número válido:");
                transferencia();
            } else if(valor > saldo){
                System.out.println("O valor nao pode exceder seu saldo na conta. Saldo atual: " + saldo);
                transferencia();
            } else{
                saldo -= valor;
                System.out.println("Transferencia para a conta: " + transferir + "Foi um sucesso. Saldo atual: " + saldo);
                main(null);
            }


        }

    }

    public static void extrato(){
        senha();
        System.out.println("|                  Olá " + nome + ", esse é seu extrato                    |");
        System.out.println("| Super mercado Tenda (Rocombole) R$ 13,50. Saldo atual: R$344             |");
        System.out.println("| Super mercado Santa clara (Sorvete Kibem) R$ 11,00. Saldo atual: R$135,50       |");
        System.out.println("| Super mercado Extra (Suco natural Vila) R$ 5,60. Saldo atual: R$164,50    |");
        System.out.println("| Kabao (Entrada de internet) R$ 20,00. Saldo atual: R$160,00              |");
        System.out.println("| Para trocar de pagina utilize (1, 2) Caso deseje sair digite (3)         |");

        main(null);
    }
    public static void fazer_saque(){
        senha();
        System.out.println("Ola " + nome + "quantos deseja retirar ?");
        Double saque = SC.nextDouble();

        boolean check = saque.isNaN();

        if (check || saque <= 0 ){
            System.out.println("Por favor, infome um numero valido.");
            fazer_saque();
        }
        else if (saque > saldo){
            System.out.println("Você não pode sacar esse valor, tente novamente outro numero.");
            fazer_saque();
        }
        else {
            saldo -= saque;
            System.out.println("Saque concluido com sucesso. Seu saldo atual é: " + saldo);
            main(null);
        }
    }

    public static void erro() {
        System.out.println("Por favor, informe um número entre 1 e 6");
        main(null);
    }

    public static void sair() {
        System.out.println("Você deseja sair? S/N");

        String escolha = SC.nextLine();

        if (escolha.equals("S" )) {
            System.out.println(nome + " Foi um prazer ter você por aqui");
            System.exit(0);
        } else if (escolha.equals("N")) {
            main(null);
        } else {
            System.out.println("Desculpe, mas não compreendi.");
            sair();
        }

    }
}
























