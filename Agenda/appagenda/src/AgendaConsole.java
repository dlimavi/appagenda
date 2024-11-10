import java.util.Scanner;

public class AgendaConsole {
    private Agenda agenda;
    private Scanner scanner;

    public AgendaConsole() {
        agenda = new Agenda();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Telefone: ");
                String telefone = scanner.nextLine();
                agenda.adicionarContato(new Contato(nome, telefone));
            } else if (opcao == 2) {
                for (Contato contato : agenda.listarContatos()) {
                    System.out.println(contato);
                }
            } else if (opcao == 3) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}