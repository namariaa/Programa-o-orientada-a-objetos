import java.util.ArrayList;

import java.util.Scanner;

public class Aluno{
    private String nomeCompleto;
    private int matricula;
    private String situacao;
    public ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private ArrayList<Turma> turmas = new ArrayList<>();
    private ArrayList<ArrayList<Float>> notas = new ArrayList<>();
    //Atributos 

    public Aluno(String n, int m){
        this.nomeCompleto = n;
        this.matricula = m;
        this.situacao = "Nao matriculado";
        ArrayList<Float> notes = new ArrayList<>();
        notes.add(0f); //Para no momento em que eu entrar na disciplina já começo com notas zeradas que só se alteram se o professor alterar
        notes.add(0f);
        notes.add(0f);
        notas.add(notes);
    }
    //Contrutor

    public String getNome(){
        return this.nomeCompleto;
    }
    private void setNome(String n){
        this.nomeCompleto = n;
    }
    public int getMatricula(){
        return this.matricula;
    }
    private void setMatricula(int m){
        this.matricula = m;
    }
    public ArrayList<ArrayList<Float>> getNotas(){
        return this.notas;
    }
    public String getSituacao(){
        return this.situacao;
    }
    public void setSituacao(String s){
        this.situacao = s;
    }
    public void setNotas(int id, Disciplina d){
        Boolean esta = false;
        int indicie = 0;
        for (int i = 0; i < disciplinas.size();i++){
            if (d == disciplinas.get(i)){
                esta = true;
                indicie = i;
            }
        } 
        if (esta){
        Scanner sc = new Scanner(System.in);
        System.out.print("Você é um professor? Coloque sua identificação: ");
        int senha = sc.nextInt();
        if (senha == id){
            System.out.print("Ola, entre com a nota do aluno: ");
            float n = sc.nextFloat();
            if (notas.get(indicie).get(0) == 0) notas.get(indicie).set(0,n);
            else if (notas.get(indicie).get(1) == 0){
                notas.get(indicie).set(1,n);
                float media = (notas.get(indicie).get(0) + notas.get(indicie).get(1)) / 2;
                if (media < 60){
                    System.out.println("Prova de recuperação=========");
                    provaFinal(id,indicie);
                }
                else {
                    System.out.println("Aluno ja passou com media " + media + ", nao é necessario fazer prova final");
                    setSituacao("Aprovado");
                }
                }
            System.out.println("Nota adicionada com sucesso");
        }
        else{
            System.out.println("Não foi possivel adicionar nota pois você não é professor da materia");
        }
        }
        else{
            System.out.println("Aluno nao matriculado na disciplina");
        }
    }
    //Get e set
    public void addDisciplina(Disciplina d){
        ArrayList<Float> notes = new ArrayList<>();
        disciplinas.add(d);
        notes.add(0f);
        notes.add(0f);
        notes.add(0f);
        notas.add(notes);
    }
    public void removerDisciplina(Disciplina d){
        disciplinas.remove(d);
    }

    public void provaFinal(int id, int indicie){
        Scanner sc = new Scanner(System.in);
        System.out.print("Você é um professor? Coloque sua identificação: ");
        int senha = sc.nextInt();
        if (senha == id){
            System.out.print("Ola, entre com a nota do aluno: ");
            float n = sc.nextFloat();
            notas.get(indicie).add(2,n);
            if ((notas.get(indicie).get(2) + notas.get(indicie).get(1) + notas.get(indicie).get(0)) / 3 >= 60) this.situacao = "Aprovado";
            else this.situacao = "Reprovado";
        }
    }

    public String perfilAluno(){
        String s = "";
        for (int i = 0; i < disciplinas.size();i++){
            s = s + "Materia:      " + disciplinas.get(i).getNome() + "\n";
            s = s + "Nota01:       " + notas.get(i).get(0) + "\n";
            s = s + "Nota02:       " + notas.get(i).get(1) + "\n";
            s = s + "Nota P.Final: " + notas.get(i).get(2) + "\n";
        }
        return "*****Perfil Pessoal*****\n" +
                "Nome completo: " + getNome() + "\n" +
                "Matricula:     " + getMatricula() + "\n" +
                "Situação:      " + getSituacao() + "\n" +
                "**********************\n" + 
                "Boletim---------------\n" + s;
    }
    //metódos 
}