package jogo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static ArrayList<Jogo> listaJogos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;

        while (true) {
            exibirMenu();
            try {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        adicionarNovoJogo();
                        break;
                    case 2:
                        aplicarDescontoNoJogo();
                        break;
                    case 3:
                        aumentarPrecoDoJogo();
                        break;
                    case 4:
                        atualizarClassificacaoEtariaDoJogo();
                        break;
                    case 5:
                        mostrarDetalhesDosJogos();
                        break;
                    case 6:
                        System.out.println("Saindo do programa. Até mais!");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número correspondente à opção.");
                scanner.nextLine(); 
            }
            System.out.println(); 
        }
    }

    private static void exibirMenu() {
        System.out.println("===== Menu de Jogos =====");
        System.out.println("1. Adicionar novo jogo");
        System.out.println("2. Aplicar desconto no jogo");
        System.out.println("3. Aumentar preço do jogo");
        System.out.println("4. Atualizar classificação etária do jogo");
        System.out.println("5. Mostrar detalhes dos jogos");
        System.out.println("6. Sair");
    }

    private static void adicionarNovoJogo() {
        System.out.println("=== Adicionar Novo Jogo ===");
        System.out.print("Título do jogo: ");
        String titulo = scanner.nextLine();

        int classificacao = 0;
        while (true) {
            try {
                System.out.print("Classificação etária: ");
                classificacao = scanner.nextInt();
                scanner.nextLine(); 
                if (classificacao < 0) {
                    System.out.println("Classificação etária não pode ser negativa. Tente novamente.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro para a classificação etária.");
                scanner.nextLine(); 
            }
        }

        double preco = 0.0;
        while (true) {
            try {
                System.out.print("Preço do jogo: R$ ");
                preco = scanner.nextDouble();
                scanner.nextLine(); 
                if (preco < 0) {
                    System.out.println("Preço não pode ser negativo. Tente novamente.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um valor numérico para o preço.");
                scanner.nextLine(); 
            }
        }

        Jogo novoJogo = new Jogo(titulo, classificacao, preco);
        listaJogos.add(novoJogo);
        System.out.println("Jogo adicionado com sucesso!");
    }

    private static void aplicarDescontoNoJogo() {
        System.out.println("=== Aplicar Desconto no Jogo ===");
        if (listaJogos.isEmpty()) {
            System.out.println("Nenhum jogo disponível para aplicar desconto.");
            return;
        }
        int indice = selecionarJogo();
        if (indice == -1) {
            return;
        }

        double desconto = 0.0;
        while (true) {
            try {
                System.out.print("Digite o percentual de desconto (%): ");
                desconto = scanner.nextDouble();
                scanner.nextLine(); 
                if (desconto < 0 || desconto > 100) {
                    System.out.println("Percentual de desconto deve estar entre 0 e 100. Tente novamente.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um valor numérico para o desconto.");
                scanner.nextLine(); 
            }
        }

        listaJogos.get(indice).aplicarDesconto(desconto);
        System.out.println("Desconto aplicado com sucesso!");
    }

    private static void aumentarPrecoDoJogo() {
        System.out.println("=== Aumentar Preço do Jogo ===");
        if (listaJogos.isEmpty()) {
            System.out.println("Nenhum jogo disponível para aumentar o preço.");
            return;
        }
        int indice = selecionarJogo();
        if (indice == -1) {
            return;
        }

        double aumento = 0.0;
        while (true) {
            try {
                System.out.print("Digite o percentual de aumento (%): ");
                aumento = scanner.nextDouble();
                scanner.nextLine(); 
                if (aumento < 0 || aumento > 100) {
                    System.out.println("Percentual de aumento deve estar entre 0 e 100. Tente novamente.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um valor numérico para o aumento.");
                scanner.nextLine(); 
            }
        }

        listaJogos.get(indice).aumentarPreco(aumento);
        System.out.println("Aumento aplicado com sucesso!");
    }

    private static void atualizarClassificacaoEtariaDoJogo() {
        System.out.println("=== Atualizar Classificação Etária do Jogo ===");
        if (listaJogos.isEmpty()) {
            System.out.println("Nenhum jogo disponível para atualizar a classificação etária.");
            return;
        }
        int indice = selecionarJogo();
        if (indice == -1) {
            return;
        }

        int novaClassificacao = 0;
        while (true) {
            try {
                System.out.print("Digite a nova classificação etária: ");
                novaClassificacao = scanner.nextInt();
                scanner.nextLine(); 
                if (novaClassificacao < 0) {
                    System.out.println("Classificação etária não pode ser negativa. Tente novamente.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro para a classificação etária.");
                scanner.nextLine();
            }
        }

        listaJogos.get(indice).atualizarClassificacao(novaClassificacao);
        System.out.println("Classificação etária atualizada com sucesso!");
    }

    private static void mostrarDetalhesDosJogos() {
        System.out.println("=== Detalhes dos Jogos ===");
        if (listaJogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }
        int contador = 1;
        for (Jogo jogo : listaJogos) {
            System.out.println(contador + ". " + jogo);
            contador++;
        }
    }

    private static int selecionarJogo() {
        mostrarDetalhesDosJogos();
        if (listaJogos.isEmpty()) {
            return -1;
        }

        int escolha = -1;
        while (true) {
            try {
                System.out.print("Selecione o número do jogo: ");
                escolha = scanner.nextInt();
                scanner.nextLine(); 
                if (escolha < 1 || escolha > listaJogos.size()) {
                    System.out.println("Número inválido. Por favor, selecione um número entre 1 e " + listaJogos.size() + ".");
                    continue;
                }
                return escolha - 1; 
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.nextLine(); 
        }
    }
}
}