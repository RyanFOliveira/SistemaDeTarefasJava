import java.io.*;
import java.util.*;

public class GerenciadorTarefas {
    private ArrayList<Tarefa> tarefas;
    private final String ARQUIVO = "tarefas.txt";  // Nome do arquivo onde as tarefas serão salvas

    // Construtor que carrega as tarefas do arquivo ao iniciar o programa
    public GerenciadorTarefas() {
        this.tarefas = new ArrayList<>();
        carregarTarefas();  // Carregar as tarefas do arquivo
    }

    // Método para carregar as tarefas do arquivo
    public void carregarTarefas() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Tarefa tarefa = new Tarefa(linha);  // Cria uma tarefa com a descrição lida do arquivo
                tarefas.add(tarefa);  // Adiciona a tarefa à lista
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar tarefas: " + e.getMessage());
        }
    }

    // Método para salvar as tarefas no arquivo
    public void salvarTarefas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Tarefa tarefa : tarefas) {
                bw.write(tarefa.getDescricao());  // Escreve a descrição de cada tarefa
                bw.newLine();  // Adiciona uma nova linha após cada tarefa
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    // Método para adicionar uma tarefa
    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);  // Adiciona a tarefa à lista
        salvarTarefas();  // Salva as tarefas no arquivo
        System.out.println("Tarefa adicionada: " + tarefa.getDescricao());
    }

    // Método para listar todas as tarefas
    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas cadastradas.");
            return;
        }
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println(i + 1 + ". " + tarefas.get(i).getDescricao());  // Exibe a tarefa
        }
    }

    // Método para remover uma tarefa
    public void removerTarefa(int indice) {
        if (indice < 1 || indice > tarefas.size()) {
            System.out.println("Índice inválido.");
            return;
        }
        Tarefa tarefaRemovida = tarefas.remove(indice - 1);  // Remove a tarefa do índice especificado
        salvarTarefas();  // Salva as tarefas atualizadas no arquivo
        System.out.println("Tarefa removida: " + tarefaRemovida.getDescricao());
    }

    // Método para obter a lista de tarefas
    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
}
