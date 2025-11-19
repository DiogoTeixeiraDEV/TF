```java
import java.util.Scanner;

public class Application {
    private static Agenda agenda = new Agenda();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        
        do{
            System.out.println("===========Menu:===========");
            System.out.println("Opção 1 - Incluir Consulta:");
            System.out.println("Opção 2 - Remover consulta:");
            System.out.println("Opção 3 - Mostrar consultas:");
            System.out.println("Opção 4 - Consultas de um médico:");
            System.out.println("Opção 5 - Data da consulta de um paciente:");
            System.out.println("Opção 6 - Consultas por data:");
            System.out.println("Opção 7 - Valor das consultas por especialidade médica");
            System.out.println("Opção 8 - Alterar médico da consulta");
            System.out.println("Opção 9 - Consulta com o menor valor cobrado");
            System.out.println("Opção 10 - Sair do programa");
            System.out.println("===========================");
            System.out.println("Escolha uma opção:");
            option = in.nextInt();
            in.nextLine();
            switch (option) {
                case 1 -> incluirConsulta();
                case 2 -> removerConsulta();
                case 3 -> agenda.mostraAgenda();
                case 4 -> buscarConsultaMedico();
                case 5 -> buscarConsultaPaciente();
                case 6 -> buscarConsultaData();
                case 7 -> buscarValorPorEspecialidade();
                case 8 -> alterarMedico();
                case 9 -> buscarConsultaMaisBarata();
                case 10 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida!");
            }

        }while(option != 10);
    }

    private static void incluirConsulta() {
        System.out.println("Digite o número da consulta:");
        int nro = in.nextInt();
        System.out.println("Digite o dia da consulta:");
        int dia = in.nextInt();
        System.out.println("Digite o mês da consulta:");
        int mes = in.nextInt();
        System.out.println("Digite o ano da consulta:");
        int ano = in.nextInt();
        in.nextLine(); 

        Data data = new Data(dia, mes, ano);
        if (!data.verificarData()) {
            System.out.println("Data inválida!");
            return;
        }

        System.out.println("Digite o CRM do médico:");
        int crm = in.nextInt();
        in.nextLine(); 
        System.out.println("Digite o nome do médico:");
        String nomeMedico = in.nextLine();
        System.out.println("Digite a especialidade do médico:");
        String especialidade = in.nextLine();
        Medico medico = new Medico(crm, nomeMedico, especialidade);

        System.out.println("Digite o código do paciente:");
        int codigoPaciente = in.nextInt();
        in.nextLine(); 
        System.out.println("Digite o nome do paciente:");
        String nomePaciente = in.nextLine();
        Paciente paciente = new Paciente(codigoPaciente, nomePaciente);

        System.out.println("Digite o valor da consulta:");
        double valor = in.nextDouble();
        in.nextLine(); 

        Consulta consulta = new Consulta(nro, data, medico, paciente, valor);
        if (agenda.adicionarConsulta(consulta)) {
            System.out.println("Consulta adicionada com sucesso!");
        } else {
            System.out.println("Erro ao adicionar consulta. Agenda cheia ou número de consulta já existe.");
        }
    }

    private static void removerConsulta() {
        System.out.println("Digite o número da consulta a ser removida:");
        int nro = in.nextInt();
        in.nextLine(); 
        if (agenda.removerConsulta(nro)) {
            System.out.println("Consulta removida com sucesso!");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }

    private static void buscarConsultaMedico() {
        System.out.println("Digite o nome do médico:");
        String nome = in.nextLine();
        Consulta[] consultas = agenda.buscarConsultaMedico(nome);
        if (consultas.length == 0) {
            System.out.println("Nenhuma consulta encontrada para este médico.");
        } else {
            for (Consulta c : consultas) {
                System.out.println(c);
            }
        }
    }

    private static void buscarConsultaPaciente() {
        System.out.println("Digite o código do paciente:");
        int codigo = in.nextInt();
        in.nextLine(); 
        String data = agenda.buscarConsultaPaciente(codigo);
        if (data != null) {
            System.out.println("Data da consulta: " + data);
        } else {
            System.out.println("Paciente não possui consulta agendada.");
        }
    }

    private static void buscarConsultaData() {
        System.out.println("Digite o dia:");
        int dia = in.nextInt();
        System.out.println("Digite o mês:");
        int mes = in.nextInt();
        System.out.println("Digite o ano:");
        int ano = in.nextInt();
        in.nextLine();
        Consulta[] consultas = agenda.buscarConsultaData(dia, mes, ano);
        if (consultas.length == 0) {
            System.out.println("Nenhuma consulta encontrada nesta data.");
        } else {
            for (Consulta c : consultas) {
                System.out.println(c);
            }
        }
    }

    private static void buscarValorPorEspecialidade() {
        System.out.println("Digite a especialidade:");
        String especialidade = in.nextLine();
        double valor = agenda.buscarValorConsultasPorEspecialidadeMedica(especialidade);
        System.out.println("Valor total das consultas da especialidade " + especialidade + ": R$" + String.format("%.2f", valor));
    }

    private static void alterarMedico() {
        System.out.println("Digite o número da consulta:");
        int nro = in.nextInt();
        in.nextLine(); 
        
        
        if (agenda.buscarConsultaPorNro(nro) == null) {
             System.out.println("Consulta não encontrada.");
             return;
        }

        System.out.println("Digite o novo CRM do médico:");
        int crm = in.nextInt();
        in.nextLine();
        System.out.println("Digite o novo nome do médico:");
        String nome = in.nextLine();
        System.out.println("Digite a nova especialidade do médico:");
        String especialidade = in.nextLine();
        
        Medico novoMedico = new Medico(crm, nome, especialidade);
        if (agenda.alterarMedico(nro, novoMedico)) {
            System.out.println("Médico alterado com sucesso!");
        } else {
            System.out.println("Erro ao alterar médico.");
        }
    }

    private static void buscarConsultaMaisBarata() {
        Consulta c = agenda.buscarConsultaMaisBarata();
        if (c != null) {
            System.out.println("Consulta mais barata: " + c);
        } else {
            System.out.println("Nenhuma consulta cadastrada.");
        }
    }
}

