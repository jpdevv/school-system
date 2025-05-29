package presentations.views;

import business.services.IOService;
import presentations.controllers.DisciplineController;
import presentations.controllers.StudentController;

public class DeleteView {
    private IOService ioService = new IOService();
    private DisciplineController disciplineController = new DisciplineController();
    private StudentController studentController = new StudentController();

    public void showDeleteDisciplineMenu() {
        ioService.print("--------------- EXCLUIR DISCIPLINA ---------------");
        String code = ioService.read("Código da disciplina a ser excluída: ");
        String confirmation = ioService.read("Tem certeza que deseja excluir esta disciplina? (y/N): ");
        String result = disciplineController.delete(code, confirmation);
        ioService.print(result);
    }

    public void showDeleteStudentMenu() {
        ioService.print("--------------- EXCLUIR ALUNO ---------------");
        String registration = ioService.read("Matrícula do aluno a ser excluído: ");
        String confirmation = ioService.read("Tem certeza que deseja excluir este aluno? (y/N): ");
        String result = studentController.delete(registration, confirmation);
        ioService.print(result);
    }

    public void showUnenrollStudentMenu() {
        ioService.print("--------------- DESMATRICULAR ALUNO DA DISCIPLINA ---------------");
        String code = ioService.read("Código da disciplina: ");
        String registration = ioService.read("Matrícula do aluno: ");
        String result = disciplineController.unenrollStudent(code, registration);
        ioService.print(result);
    }
}
