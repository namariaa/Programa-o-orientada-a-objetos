Implementação e uso do sistemas

Classes implementadas:
  - Alunos
  - Professores
  - Turma
  - Disciplina
  - SistemaEscolar
Além disso, para fins de complementar as interfaces de texto os teste foram feitos em
teste_aulas.java que estará anexado juntamente as classes, no terminal fica:
javac teste_aulas.java
java teste_aulas

Regras de funcionamento:

  - O acesso de todos métodos é através da classe SistemaEscolar que é responsável
  por ligar os métodos com as funcionalidades da classe limitando o acesso direto do
    usuário às classes/ao sistema.
  - Ao rodar o código no terminal o usuário terá, primeiramente, acesso às formas de
  cadastrar, então ao escolher uma opção de cadastro ele precisa apenas colocar as
  informações necessárias e não precisa ter acesso direto ao código e a detalhes de
  implementação. Em um segundo momento, após a finalização de todos os cadastros
  (de todos os alunos, professores, disciplinas e turmas) aparecerá um novo menu
  que conta com as ações que o usuário pode realizar dentre elas temos:
    [1]Perfil do aluno
    [2]Adicionar nota
    [3]Alterar nota
    [4]Atribuir aluno a turma
    [5]Remover aluno da turma
    [6]Finalizar sessão
    
O que implementa cada opção do menu:

[1]Perfil do aluno
Ele irá diretamente para o método implementado perfildoAluno em SistemaEscolar que
transforma as informações dadas pelo o usuário em objetos e chama o método PerfilAluno,
feito na classe aluno, que usará estas informações para aparecer na linha de comando, já
formatado, informações pessoais do aluno e seu boletim de todas as matérias.
[2]Adicionar nota
Adiciona na classe aluno todas as suas notas de acordo com a disciplina. Para isso foi
criado um ArrayList<ArrayList<Float>> para separar por indicie as notas dos alunos por
disciplinas, ou seja, se cadastrei para o aluno X a disciplina Y e depois a disciplina Z issosignifica que no índice 0 do array irá ter um array com três notas referentes as notas
daquele aluno naquela disciplina e no índice 1 as notas da disciplina Z.
Apenas professores podem fazer o uso dessa função, pois além de informações como a
nota que deseja inserir e a disciplina, o professor precisa fornecer sua identificação
corretamente.
[3]Alterar nota
Alteração da unidade que o professor quiser, podendo alterar da nota 1 ou da nota 2. Seu
funcionamento interno segue a linha de raciocínio do código de adição de notas apenas
alterando onde quero colocar especificamente.
Observação: Para a adição das notas foi usado o SET em vez do ADD, pois ao se cadastrar
em uma disciplinas todas as notas do aluno ficam zeradas até um professor colocar uma
nota de fato e em vez de queremos inserir um novo valor queremos simplesmente substituir
o que já tem por outro, por exemplo substituir o 0 inicial pela nota dada pelo professor.
[4]Atribuir aluno a turma
Colocar o aluno como integrante da turma. Para isso foi necessário apenas adicionar em
um ArrayList criado na classe turma que contém todos os alunos.
[5]Remover aluno da turma
Remover o aluno da turma, precisando de informações como nome da turma e aluno. No
ArrayList citado acima é feita a remoção desse aluno.
[6]Finalizar sessão
Finalizar o programa.
Observação: Para saber qual método de SistemaEscolar chamar e executar foram feitos if´s
dentro de teste_aulas para ter um direcionamento correto.

Observações de uso:

Durante a implementação, optei por alguns detalhes para o uso correto, essa sessão irá se
referir a todos eles.
  - Para o cadastro de uma turma você necessariamente precisa já ter cadastrado um
  professor e uma disciplina, o único que não é pré-requisito de criação é o aluno que
  pode ser adicionado posteriormente, ao usuário escolher a opção 4 do menu criado
  na interface de texto que internamente implementa, por meio do controle da classe
  SistemaEscolar, o código.
  - Para cadastrar um professor é preciso necessariamente ter cadastrado uma
  disciplina, para colocar em suas informações qual a disciplina ministrada.Para o controle de erros:
  Em aluno:
    - Em setNotas para conseguir inserir uma nota foi feito um For de verificação se a
    disciplina dada para a colocação de notas é uma disciplina que aquele aluno
    específico está cursando. Mas, um processo de verificação ainda é feito para a nota
    ser inserida, apenas se a identificação do professor daquela disciplina for fornecida
    corretamente posso inserir as notas do aluno (essa mesma verificação é feita no
    método provaFinal).
  Em professor:
    - Os testes, como a identificação do professor para adição e alteração de notas, são
    todos feitos na classe aluno.
  Em SistemaEscolar:
    - Em várias partes dessa classe e em diversos métodos, foram feitas verificações
    como, se todas as informações necessárias foram inseridas pelo usuário e caso
    tenham sido inseridas se estão todas corretas. Abaixo, estão exemplo de
    verificações e saídas a partir destas verificações:
    if (a == null || d == null || p == null)
    System.out.println("Alguma informação está errada não foi possível
    efetuar a adição");
    else p.alterarNota(a, d);

    Caso o aluno, ou a disciplina ou o professor não tenham sido inseridos ou tenham sido
    inseridas incorretamente a alteração da nota (que é o objetivo deste método) não é
    realizada.
    
    if (disciplinasCadastradas.size() == 0) System.out.println("Não
    possui disciplinas disponiveis para cadastrar turma");
    Caso eu não tenha me cadastrado em nenhuma disciplina não posso criar uma turma.
    Como através de informações dadas no terminal foram criados os objetos e
    implementados nas classes
  Na classe SistemaEscolar estes dados solicitados no próprio método pelo terminal são
  transformados em objetos e inseridos em arrays criados nesta mesma classe para assim
  termos o controle completo de todas as informações. Abaixo temos um código exemplo de
  como foi feito os objetos:System.out.println("Ola, aluno!!! Vamos fazer o seu cadastro? ");
  System.out.print("Digite seu nome: ");
  String nome = sc.nextLine();
  sc.nextLine();
  System.out.print("Digite sua identificação: ");
  int matricula = sc.nextInt();
  Aluno z = new Aluno(nome,matricula);
  alunosCadastrados.add(z);
