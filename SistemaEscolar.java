import java.util.Scanner;
import java.util.ArrayList;

public class SistemaEscolar{
    Scanner sc = new Scanner(System.in);
    ArrayList<Disciplina> disciplinasCadastradas = new ArrayList<>();
    ArrayList<Professor> professoresCadastrados = new ArrayList<>();
    ArrayList<Turma> turmasCadastrados = new ArrayList<>();
    ArrayList<Aluno> alunosCadastrados = new ArrayList<>();
    public void cadastrarTurma(){
        if (disciplinasCadastradas.size() == 0) System.out.println("Não possui disciplinas disponiveis para cadastrar turma");
        else{
            sc.nextLine();
            System.out.print("Digite o nome da turma: ");
            String nome = sc.nextLine();
            sc.nextLine();
            System.out.println("\n");
            for (int i = 0; i < disciplinasCadastradas.size();i++){
                System.out.println("[" + i + 1 + "] " + disciplinasCadastradas.get(i).getNome());
            }
            System.out.println("[" + (disciplinasCadastradas.size() + 1) + "] " + " nenhuma");
            System.out.print("Digite a disciplina da turma: ");
            int dq = sc.nextInt();
            System.out.print("\n");
            if (dq == disciplinasCadastradas.size() + 1) System.out.println("Não foi possivel castrar a turma por nenhuma disciplina ter sido selecionada");
            else{
                Disciplina quer = disciplinasCadastradas.get(dq - 1);
                Boolean tem_prof = false;
                Professor qual_prof = null;
                for (int i = 0; i < professoresCadastrados.size();i++){
                    if (professoresCadastrados.get(i).disciplinas == quer){
                        tem_prof = true;
                        qual_prof = professoresCadastrados.get(i);
                    }
                }
                if (!tem_prof) System.out.println("Não possui professores disponiveis para criar a turma");
                else{
                    Turma x = new Turma(nome,qual_prof,quer);
                    turmasCadastrados.add(x);
                }
            }
        }
    }

    public void cadastrarProfessor(){
        System.out.println("Ola, novo professor!!! Vamos fazer o seu cadastro? ");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();                   
        sc.nextLine();                                                                  
        System.out.print("\n");
        System.out.print("Digite sua identificação: ");
        int id = sc.nextInt();
        System.out.print("Digite codigo da disciplina: ");
        int c = sc.nextInt();
        Disciplina d = null;
        for (int i = 0; i < disciplinasCadastradas.size(); i++){
            if (disciplinasCadastradas.get(i).getCodigo() == c){
                d = disciplinasCadastradas.get(i);
            }
        }
        if (d == null) System.out.println("Não foi possivel concluir o cadastro pois essa materia ainda não foi cadastrada");
        else{
            Professor y = new Professor(nome,id,d); 
            professoresCadastrados.add(y);
        }
    }

    public void cadastrarAluno(){
        System.out.println("Ola, aluno!!! Vamos fazer o seu cadastro? ");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        sc.nextLine();
        System.out.print("Digite sua identificação: ");
        int matricula = sc.nextInt();
        Aluno z = new Aluno(nome,matricula); 
        alunosCadastrados.add(z);
    }

    public void cadastrarDisciplina(){
        System.out.println("Hora do cadastro de disciplinas, Vamos começar?");
        System.out.print("Digite o nome da disciplina: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.print("\n");
        System.out.print("Digite o código da disciplina: ");
        int id = sc.nextInt();
        System.out.print("Digite a descrição da disciplina: "); 
        sc.nextLine();
        String descricao = sc.nextLine();
        Disciplina d = new Disciplina(nome,id,descricao); 
        disciplinasCadastradas.add(d);
    }

    public String perfildoAluno(int codigo){
        String s = "";
        for (int i = 0; i < alunosCadastrados.size();i++){
            if (codigo == alunosCadastrados.get(i).getMatricula()){
                s = alunosCadastrados.get(i).perfilAluno();
            
                break;
            }
        }
        if (s != "") return s;
        else return "Aluno não cadastrado";
    }

    public void adicionarNotadoAluno(int matricula,int codigo, int id){
        Aluno a = null;
        Disciplina d = null;
        Professor p = null;
        for (int i = 0; i < alunosCadastrados.size();i++){
            if (matricula == alunosCadastrados.get(i).getMatricula()){
                a = alunosCadastrados.get(i);
            }
        }
        for (int i = 0; i <disciplinasCadastradas.size();i++){
            if (codigo == disciplinasCadastradas.get(i).getCodigo()){
                d = disciplinasCadastradas.get(i);
            }
        }
        for (int i = 0; i < professoresCadastrados.size();i++){
            if (id == professoresCadastrados.get(i).getIdentificacao()){
                p = professoresCadastrados.get(i);
            }
        }
        if (a == null || d == null || p == null) System.out.println("Alguma informação está errada não foi possivel efetuar a adição");
        else p.adicionarNota(a, d);
    }
    public void alterarNotadoAluno(int matricula,int codigo, int id){
        Aluno a = null;
        Disciplina d = null;
        Professor p = null;
        for (int i = 0; i < alunosCadastrados.size();i++){
            if (matricula == alunosCadastrados.get(i).getMatricula()){
                a = alunosCadastrados.get(i);
            }
        }
        for (int i = 0; i <disciplinasCadastradas.size();i++){
            if (codigo == disciplinasCadastradas.get(i).getCodigo()){
                d = disciplinasCadastradas.get(i);
            }
        }
        for (int i = 0; i < professoresCadastrados.size();i++){
            if (id == professoresCadastrados.get(i).getIdentificacao()){
                p = professoresCadastrados.get(i);
            }
        }
        if (a == null || d == null || p == null) System.out.println("Alguma informação está errada não foi possivel efetuar a adição");
        else p.alterarNota(a, d);
    }

    public void atribuirAlunoTurma(int matricula,String nome){
        Aluno m = null;
        Turma n = null;
        for (int i = 0; i < alunosCadastrados.size();i++){
            if (matricula == alunosCadastrados.get(i).getMatricula()){
                m = alunosCadastrados.get(i);
            }
        }
        for (int i = 0; i < turmasCadastrados.size();i++){
            if (turmasCadastrados.get(i).getNome().equals(nome)){
                n = turmasCadastrados.get(i);
            }
        }
        if (m == null || n == null) System.out.println("Alguma informação está errada não foi possivel efetuar a atribuição");
        else n.adicionarAluno(m);
    }

    public void removerAlunoTurma(int matricula,String nome){
        Aluno m = null;
        Turma n = null;
        for (int i = 0; i < alunosCadastrados.size();i++){
            if (matricula == alunosCadastrados.get(i).getMatricula()){
                m = alunosCadastrados.get(i);
            }
        }
        for (int i = 0; i < turmasCadastrados.size();i++){
            if (turmasCadastrados.get(i).getNome().equals(nome)){
                n = turmasCadastrados.get(i);
            }
        }
        if (m == null || n == null) System.out.println("Alguma informação está errada não foi possivel efetuar a atribuiçaõ");
        else n.removerAluno(m);
    }
}
