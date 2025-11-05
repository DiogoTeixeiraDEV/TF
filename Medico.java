public class Medico {
    private int crm;
    private String nome;
    private String especialidade;

    public Medico(int Crm, String nome, String especialidade){
        this.crm = Crm;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public int getCRM(){
        return crm;
    }
    public String getNome(){
        return nome;
    }
    public String getEspecialidade(){
        return especialidade;
    }
    public void setCRM(int crm){
        this.crm = crm;
    }
    public void setNome(String nome ){
        this.nome = nome;
    }
    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }

    public String toString(){
        return "Medico CRM: " +crm +", Nome: " +nome +", Especialidade: " +especialidade ;
    }

    


}
