import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option;
        
        do{
            System.out.println("===========Menu:===========");
            System.out.println("Opção 1 - Incluir Consulta:");
            System.out.println("Opção 2 - Remover consulta:");
            System.out.println("Opção 3 - Mostrar consultas:");
            System.out.println("Opção 4 - Consultas de um médico:");
            System.out.println("Opção 5 - Data da consulta de um paciente:");
            System.out.println("Opção 6 - Consultas por data:");
            System.out.println("Opção 7 - – Valor das consultas por especialidade médica");
            System.out.println("Opção 8 - Alterar médico da consulta");
            System.out.println("Opção 9 - Consulta com o menor valor cobrado");
            System.out.println("Opção 10 - Sair do programa");
            System.out.println("===========================");
            System.out.println("Escolha uma opção:");
            option = in.nextInt();
            switch (option) {
                case 1 -> incluirConsulta();
                case 2 -> removerConsulta();
                case 3 -> System.out.println(agenda);
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
}
