import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();  // Inicia o gerenciador, que carrega as tarefas do arquivo

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Remover Tarefa");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a linha em branco após o número

            switch (opcao) {
                case 1:
                    // Validação da descrição da tarefa
                    String descricao;
                    while (true) {
                        System.out.print("Digite a descrição da tarefa: ");
                        descricao = scanner.nextLine().trim();  // Remover espaços extras

                        if (descricao.isEmpty()) {
                            System.out.println("A descrição da tarefa não pode ser vazia. Tente novamente.");
                        } else {
                            break;  // Se a descrição for válida, sai do loop
                        }
                    }

                    Tarefa tarefa = new Tarefa(descricao);
                    gerenciador.adicionarTarefa(tarefa);
                    break;
                case 2:
                    System.out.println("Tarefas:");
                    gerenciador.listarTarefas();
                    break;
                case 3:
                    // Validação do índice de remoção
                    int indice;
                    while (true) {
                        System.out.print("Digite o índice da tarefa para remover: ");
                        indice = scanner.nextInt();

                        if (indice < 1 || indice > gerenciador.getTarefas().size()) {
                            System.out.println("Índice inválido. Tente novamente.");
                        } else {
                            break;  // Se o índice for válido, sai do loop
                        }
                    }
                    gerenciador.removerTarefa(indice);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
