package presentations.views;

import business.services.IOService;
import presentations.controllers.DisciplineController;
import presentations.controllers.StudentController;

public class RegisterView {
    private IOService ioService = new IOService();
    private DisciplineController disciplineController = new DisciplineController();
    private StudentController studentController = new StudentController();

    public void showRegisterDisciplineMenu() {
        ioService.print("--------------- CADASTRAR DISCIPLINA ---------------");
        String name = ioService.read("Nome da disciplina: ");
        String code = ioService.read("Código da disciplina: ");
        String workload = ioService.read("Carga horária da disciplina: ");
        String result = disciplineController.register(name, code, workload);
        ioService.print(result);
    }

    public void showRegisterStudentMenu() {
        ioService.print("--------------- CADASTRAR ALUNO ---------------");
        String registration = ioService.read("Matrícula do aluno: ");
        String name = ioService.read("Nome do aluno: ");
        String email = ioService.read("Email do aluno: ");
        String address = ioService.read("Endereço do aluno: ");
        String result = studentController.register(registration, name, email, address);
        ioService.print(result);
    }

    public void showEnrollStudentMenu() {
        ioService.print("--------------- MATRICULAR ALUNO NA DISCIPLINA ---------------");
        String code = ioService.read("Código da disciplina: ");
        String registration = ioService.read("Matrícula do aluno: ");
        String result = disciplineController.enrollStudent(code, registration);
        ioService.print(result);
    }
}
