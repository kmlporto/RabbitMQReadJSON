public class Livro {
    String nome;
    String editora;

    public Livro(){

    }

    public Livro(String nome, String editora) {
        this.nome = nome;
        this.editora = editora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}
