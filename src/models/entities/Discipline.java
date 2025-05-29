package models.entities;

import java.util.ArrayList;
import java.util.List;

public class Discipline {
    private String name, code, workload;
    private List<Student> students;

    public Discipline(String name, String code, String workload) {
        this.name = name;
        this.code = code;
        this.workload = workload;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWorkload() {
        return workload;
    }

    public void setWorkload(String workload) {
        this.workload = workload;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Disciplina [nome=").append(name)
          .append(", código=").append(code)
          .append(", carga horária=").append(workload)
          .append("]\n- Alunos matriculados:\n");
        
        if (students.isEmpty()) {
            sb.append("Nenhum aluno matriculado.\n");
        } else {
            for (Student student : students) {
                sb.append("-- ").append(student.toString()).append("\n");
            }
        }
        
        return sb.toString();
    }
}
