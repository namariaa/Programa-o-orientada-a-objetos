import java.util.Scanner;

import java.util.ArrayList;

public class Professor {
    private String nome;
    private int identificacao;
    public Disciplina disciplinas;
    private ArrayList<Turma> turmas = new ArrayList<>();
    //Atributos

    public Professor(String n, int i,Disciplina d){
        this.nome = n;
        this.identificacao = i;
        this.disciplinas = d;
    }
    //Contrutor 

    public String getNome(){
        return this.nome;
    }
    private void setNome(String n){
        this.nome = n;
    }
    public int getIdentificacao(){
        return this.identificacao;
    }
    private void setIdentificacao(int i){
        this.identificacao = i;
    }
    //Get e set

    public void adicionarTurma(Turma t){
        turmas.add(t);
    }
    public void removerTurma(Turma t){
        turmas.remove(t);
    }
    public void adicionarNota(Aluno a, Disciplina d){
        int indicie = 0;
        for (int i = 0; i < a.disciplinas.size();i++){
            if (d == a.disciplinas.get(i)) indicie = i;
        } 
        a.setNotas(getIdentificacao(),d);
    }

    public void alterarNota(Aluno a, Disciplina d){
        int indicie = 0;
        for (int i = 0; i < a.disciplinas.size();i++){
            if (d == a.disciplinas.get(i)) indicie = i;
        } 
        Scanner sc = new Scanner(System.in);
        System.out.print("Professor, qual a nota do aluno " + a.getNome() + " que você deseja alterar[01/02]: ");
        int n = sc.nextInt();
        a.getNotas().get(indicie).set(n - 1, 0f);
        a.setNotas(getIdentificacao(),d);
    }

    //Metodos

}
