package presentations.controllers;

import business.services.DisciplineService;

public class DisciplineController {
    private static final DisciplineService disciplineService = new DisciplineService();

    public String register(String name, String code, String workload) {
        if(name == null || name.isEmpty()) {
            return "[ERRO] - O nome da disciplina não pode estar vazio.";
        }
        if(code == null || code.isEmpty()) {
            return "[ERRO] - O código da disciplina não pode estar vazio.";
        }
        if(workload == null || workload.isEmpty()) {
            return "[ERRO] - A carga horária da disciplina não pode estar vazia.";
        }
        
        boolean wasCreated = disciplineService.registerDiscipline(name, code, workload);
        if(!wasCreated) return "[ERRO] - Já existe uma disciplina com este código.";
        return "Disciplina cadastrada com sucesso.";
    }

    public String enrollStudent(String code, String studentRegistration) {
        if(code == null || code.isEmpty()) return "[ERRO] - O código da disciplina não pode estar vazio.";
        if(studentRegistration == null || studentRegistration.isEmpty()) return "[ERRO] - A matrícula do aluno não pode estar vazia.";
        
        boolean wasEnrolled = disciplineService.enrollStudent(code, studentRegistration);
        if(!wasEnrolled) return "[ERRO] - Disciplina ou aluno não existe.";
        return "Aluno matriculado com sucesso.";
    }

    public String unenrollStudent(String code, String studentRegistration) {
        if(code == null || code.isEmpty()) return "[ERRO] - O código da disciplina não pode estar vazio.";
        if(studentRegistration == null || studentRegistration.isEmpty()) return "[ERRO] - A matrícula do aluno não pode estar vazia.";
        boolean wasUnenrolled = disciplineService.unenrollStudent(code, studentRegistration);
        if(!wasUnenrolled) return "[ERRO] - Disciplina ou aluno não existe.";
        return "Aluno desmatriculado com sucesso.";
    }

    public String delete(String code, String confirmation) {
        if(confirmation.equalsIgnoreCase("N") || confirmation.isEmpty()) return "[INFO] - Exclusão da disciplina cancelada.";

        if(code == null || code.isEmpty()) return "[ERRO] - O código da disciplina não pode estar vazio.";
        
        boolean wasDeleted = disciplineService.delete(code);
        if(!wasDeleted) return "[ERRO] - Não existe disciplina com este código.";
        return "Disciplina excluída com sucesso.";
    }

    public String update(String name, String code, String workload) {
        if(code == null || code.isEmpty()) return "[ERRO] - O código da disciplina não pode estar vazio.";
        
        boolean wasUpdated = disciplineService.update(name, code, workload);
        if(!wasUpdated) return "[ERRO] - Não existe disciplina com este código.";
        return "Disciplina atualizada com sucesso.";
    }

    public String list() {
        String result = disciplineService.findAll();
        if(result == null || result.isEmpty()) {
            return "[ERRO] - Nenhuma disciplina cadastrada.";
        }
        return result;
    }
}
