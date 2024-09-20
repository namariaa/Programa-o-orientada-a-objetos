import java.util.ArrayList;
import java.util.Map;

public class Turma{
    private String nome;
    private Professor professor;
    private Disciplina disciplina;
    private ArrayList<Aluno> alunos = new ArrayList<>();
    //Atributos

    public Turma(String n, Professor p, Disciplina d){
        this.nome = n;
        this.professor = p;
        this.disciplina = d;
    }
    //Contrutor

    public String getNome(){
        return this.nome;
    }
    public void setNome(String n){
        this.nome = n;
    }
    public Professor getProfessor(){
        return this.professor;
    }
    public void setProfessor(Professor p){
        this.professor = p;
    }
    public Disciplina getDisciplina(){
        return this.disciplina;
    }
    public void setDisciplina(Disciplina d){
        this.disciplina = d;
    }
    //Get e set

    public void adicionarAluno(Aluno a){
        alunos.add(a);
        a.addDisciplina(getDisciplina());
        a.setSituacao("Cursando");
    }

    public void removerAluno(Aluno a){
        alunos.remove(a);
    }
    public ArrayList<Aluno> listarAlunos(){
        return this.alunos;
    }
    //Metodos
}
