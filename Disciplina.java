public class Disciplina{
    private String nome;
    private int codigo;
    private String descricao;
    //Atributos

    public Disciplina(String n, int c, String d){
        this.nome = n;
        this.codigo = c;
        this.descricao = d;
    }
    //Contrutor

    public String getNome(){
        return this.nome;
    }
    private void setNome(String n){
        this.nome = n;
    }
    public int getCodigo(){
        return this.codigo;
    }
    private void setCodigo(int c){
        this.codigo = c;
    }
    public String getDescricao(){
        return this.descricao;
    }
    private void setDescricao(String d){
        this.descricao = d;
    }
    //Get e set

    //Metodos
}