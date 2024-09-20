import java.util.Scanner;

public class teste_aulas {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("*/*//*/*// Bem-vindo ao SGN /*//*/**//\n" +
                            "(Sistema de gerenciamento de nota)\n"    +
                            "Escolha um serviço para começar:\n"      +
                            "********************************\n"      +
                            "[1]Cadastrar aluno\n"                    +
                            "[2]Cadastrar disciplina\n"               + 
                            "[3]Cadastrar professor\n"                +
                            "[4]Cadastrar turma\n"                    +
                            "[5]Parar cadastro\n"                     +
                            "**Lembrando que para cadastrar turma você precisa de professor e discipina\n"+
                            "**O cadastro de professor só pode ser realizado se houver disciplinas já cadastradas\n");
        SistemaEscolar sgn = new SistemaEscolar();
        String resposta = "S";
        while (resposta != "N" || resposta != "n"){
            System.out.print("Digite o numero do servico: ");
            int op = sc.nextInt();
            System.out.print("\n");
            sc.nextLine();
            if (op == 1) sgn.cadastrarAluno();
            else if (op == 3) sgn.cadastrarProfessor();
            else if (op == 2) sgn.cadastrarDisciplina();
            else if (op == 4) sgn.cadastrarTurma();
            else if (op == 5) break;
            else System.out.println("Opção inavlida.");
            System.out.print("Você deseja realizar mais algum cadastro[S/N]? ");
            resposta = sc.nextLine();
            if (resposta.equals("N")|| resposta.equals("n")) break;
            System.out.print("\n");
        }
        resposta = "S";
        System.out.println("Escolha um serviço:"                                                              +
                              "********************************\n"                                            +
                              "[1]Perfil do aluno (pode ser acessado apenas por aluno)\n"                     +
                              "[2]Adicionar nota  (pode ser acessado apenas por professores\n"                + 
                              "[3]Alterar nota    (pode ser acessado apenas por professores\n"                +
                              "[4]Atribuir aluno a turma \n"                                                  +
                              "[5]Remover aluno da turma\n"                                                   +
                              "[6]Finalizar sessão");
        while (resposta != "N" || resposta != "n"){
            System.out.print("Digite o numero do servico: ");
            int op = sc.nextInt();
            if (op == 1){
                System.out.print("Digite a matricula do aluno que você quer acessar: ");
                int codigo = sc.nextInt();
                System.out.println(sgn.perfildoAluno(codigo));
                sc.nextLine();
            } 
            else if (op == 2){
                System.out.print("Professor, digite a sua identificação: ");
                int id = sc.nextInt();
                System.out.print("Digite a matricula do aluno: ");
                int matricula = sc.nextInt();
                System.out.print("Digite o codigo da disciplina: ");
                int codigo = sc.nextInt();
                sgn.adicionarNotadoAluno(matricula, codigo, id);
            } 
            else if (op == 3){
                System.out.print("Professor, digite a sua identificação: ");
                int id = sc.nextInt();
                System.out.print("Digite a matricula do aluno: ");
                int matricula = sc.nextInt();
                System.out.print("Digite o codigo da disciplina: ");
                int codigo = sc.nextInt();
                sgn.alterarNotadoAluno(matricula, codigo, id);
            }
            else if (op == 4){
                System.out.print("Digite a matricula do aluno: ");
                int matricula = sc.nextInt();
                System.out.print("Digite o nome da turma: ");
                sc.nextLine();
                String nome = sc.nextLine();
                sgn.atribuirAlunoTurma(matricula, nome);
            }
            else if (op == 5){
                System.out.print("Digite a matricula do aluno: ");
                int matricula = sc.nextInt();
                System.out.print("Digite o nome da turma: ");
                sc.nextLine();
                String nome = sc.nextLine();
                sgn.removerAlunoTurma(matricula, nome);
            }
            else if (op == 6) break;
            else System.out.println("Serviço selecionado não está disponivel");
            System.out.print("Você deseja realizar mais algum servico[S/N]? ");
            resposta = sc.nextLine();
            sc.nextLine();
            System.out.print("\n");
            if (resposta.equals("N") || resposta.equals("n")) break;
        }
        /*Aluno ana = new Aluno("Ana Maria Ferreira de Abreu Guedes",2023201);
        Aluno Cristina = new Aluno("Ana Cristina Ferreira de Abreu", 2005201);
        Professor Marlene = new Professor("Marlene", 5487);
        Disciplina ciencias = new Disciplina("Ciencias", 65, "Um pouco mais sobre a ciencias");
        Disciplina informatica = new Disciplina("Informatica",87, "Mexendo em computadores");
        Turma normal = new Turma("normal",Marlene,informatica);
        /*normal.adicionarAluno(Cristina);
        normal.adicionarAluno(ana);
        Marlene.adicionarNota(ana,informatica); 
        Marlene.adicionarNota(ana,informatica);
        System.out.println(normal.listarAlunos().get(1).perfilAluno());
        Turma minicientistas = new Turma("minicientistas", Marlene, ciencias);
        minicientistas.adicionarAluno(ana);
        Marlene.adicionarNota(ana,ciencias);
        Marlene.adicionarNota(ana,ciencias);
        Marlene.alterarNota(ana,ciencias);
        System.out.println(minicientistas.listarAlunos().get(0).perfilAluno()); 
        */ 
    }
}
