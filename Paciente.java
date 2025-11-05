public class Paciente {
    private int codigo;
    private String nome;

    public Paciente(int codigo, String nome){
        this.nome = nome;
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }
    public String getNome(){
        return nome;
    }
    public  void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

     public String toString() {
        return "Paciente \n Codigo: " +codigo +",\n Nome: " +nome +" ;";
    }
}
