package presentations.views;

import business.services.IOService;
import presentations.controllers.DisciplineController;
import presentations.controllers.StudentController;

public class ListView {
    private IOService ioService = new IOService();
    private DisciplineController disciplineController = new DisciplineController();
    private StudentController studentController = new StudentController();
    private static MenuView menuView = new MenuView();

    public void showListMenu() {
        ioService.print("--------------- MENU DE LISTAGEM ---------------");
        ioService.print("1 - Listar Disciplinas");
        ioService.print("2 - Listar Alunos");
        ioService.print("0 - Voltar ao Menu Principal");
        String option = ioService.read("Escolha uma opção: ");
        switch(option) {
            case "0" -> menuView.showMainMenu();
            case "1" -> showListDisciplines();
            case "2" -> showListStudents();
            default -> ioService.print("Opção inválida. Por favor, tente novamente.");
        }
    }

    public void showListDisciplines() {
        ioService.print("--------------- LISTA DE DISCIPLINAS ---------------");
        String result = disciplineController.list();
        ioService.print(result);
    }

    public void showListStudents() {
        ioService.print("--------------- LISTA DE ALUNOS ---------------");
        String result = studentController.list();
        ioService.print(result);
    }
}
