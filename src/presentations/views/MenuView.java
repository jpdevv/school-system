package presentations.views;

import business.services.IOService;

public class MenuView {
    private IOService ioService = new IOService();
    private ListView listView = new ListView();
    private RegisterView registerView = new RegisterView();
    private DeleteView deleteView = new DeleteView();
    private UpdateView updateView = new UpdateView();


    // Method to show the main menu
    public void showMainMenu() {
        ioService.print("--------------- SISTEMA ESCOLAR ---------------");
        ioService.print("1 - Cadastrar Disciplina");
        ioService.print("2 - Cadastrar Aluno");
        ioService.print("3 - Matricular Aluno na Disciplina");
        ioService.print("4 - Excluir Disciplina");
        ioService.print("5 - Excluir Aluno");
        ioService.print("6 - Desmatricular Aluno da Disciplina");
        ioService.print("7 - Atualizar Disciplina");
        ioService.print("8 - Atualizar Aluno");
        ioService.print("9 - Listar");
        ioService.print("0 - Sair");
        String option = ioService.read("Escolha uma opção: ");

        switch(option) {
            case "0" -> {
                ioService.print("Saindo da aplicação. Até mais!");
                System.exit(0);
            }
            case "1" -> registerView.showRegisterDisciplineMenu();
            case "2" -> registerView.showRegisterStudentMenu();
            case "3" -> registerView.showEnrollStudentMenu();
            case "4" -> deleteView.showDeleteDisciplineMenu();
            case "5" -> deleteView.showDeleteStudentMenu();
            case "6" -> deleteView.showUnenrollStudentMenu();
            case "7" -> updateView.showUpdateDisciplineMenu();
            case "8" -> updateView.showUpdateStudentMenu();
            case "9" -> listView.showListMenu();
            default -> ioService.print("[ERRO] - Opção inválida. Por favor, tente novamente.");
        }
    }
}
