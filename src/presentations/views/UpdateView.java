package presentations.views;

import business.services.IOService;
import presentations.controllers.DisciplineController;
import presentations.controllers.StudentController;

public class UpdateView {
    private IOService ioService = new IOService();
    private DisciplineController disciplineController = new DisciplineController();
    private StudentController studentController = new StudentController();

    public void showUpdateDisciplineMenu() {
        ioService.print("--------------- ATUALIZAR DISCIPLINA ---------------");
        ioService.print("Se você não quiser alterar algum item abaixo, deixe-o em branco.");
        String code = ioService.read("Código da disciplina a ser atualizada: ");
        String name = ioService.read("Novo nome da disciplina: ");
        String workload = ioService.read("Nova carga horária da disciplina: ");
        String result = disciplineController.update(name, code, workload);
        ioService.print(result);
    }

    public void showUpdateStudentMenu() {
        ioService.print("--------------- ATUALIZAR ALUNO ---------------");
        ioService.print("Se você não quiser alterar algum item abaixo, deixe-o em branco.");
        String registration = ioService.read("Matrícula do aluno a ser atualizado: ");
        String name = ioService.read("Novo nome do aluno: ");
        String email = ioService.read("Novo email do aluno: ");
        String address = ioService.read("Novo endereço do aluno: ");
        String result = studentController.update(registration, name, email, address);
        ioService.print(result);
    }
}
