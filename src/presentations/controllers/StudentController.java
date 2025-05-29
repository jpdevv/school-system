package presentations.controllers;

import business.services.StudentService;

public class StudentController {
    private static final StudentService studentService = new StudentService();

    public String register(String registration, String name, String email, String address) {
        if (registration == null || registration.isEmpty()) {
            return "[ERRO] - A matrícula não pode estar vazia.";
        }
        if (name == null || name.isEmpty()) {
            return "[ERRO] - O nome não pode estar vazio.";
        }
        if (email == null || email.isEmpty()) {
            return "[ERRO] - O email não pode estar vazio.";
        }
        if (address == null || address.isEmpty()) {
            return "[ERRO] - O endereço não pode estar vazio.";
        }

        boolean wasCreated = studentService.register(registration, name, email, address);
        if (!wasCreated) {
            return "[ERRO] - Já existe um aluno com esta matrícula ou email.";
        }
        return "Aluno cadastrado com sucesso.";
    }

    public String delete(String registration, String confirmation) {
        if (confirmation.equalsIgnoreCase("N") || confirmation.isEmpty()) 
            return "[INFO] - Exclusão do aluno cancelada.";

        if (registration == null || registration.isEmpty()) 
            return "[ERRO] - A matrícula não pode estar vazia.";

        boolean wasDeleted = studentService.delete(registration);
        if (!wasDeleted) 
            return "[ERRO] - Não existe aluno com esta matrícula.";
        return "Aluno excluído com sucesso.";
    }

    public String update(String registration, String name, String email, String address) {
        if (registration == null || registration.isEmpty()) 
            return "[ERRO] - A matrícula não pode estar vazia.";

        boolean wasUpdated = studentService.update(registration, name, email, address);
        if (!wasUpdated) 
            return "[ERRO] - Não existe aluno com esta matrícula ou nenhuma alteração foi feita.";
        return "Aluno atualizado com sucesso.";
    }

    public String list() {
        String result = studentService.findAll();
        if (result == null || result.isEmpty()) {
            return "[ERRO] - Nenhum aluno cadastrado.";
        }
        return result;
    }
}
