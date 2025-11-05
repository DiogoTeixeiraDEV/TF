public class Consulta {
    private int nro;
    private Data data;
    private Medico medico;
    private Paciente paciente;
    private double valor;

    public Consulta(int nro, Data data, Medico medico, Paciente paciente, double valor) {
        this.nro = nro;
        this.data = data;
        this.medico = medico;
        this.paciente = paciente;
        this.valor = valor;
    }

    public int getNro(){
        return nro;
    }
    public Data getData(){
        return data;
    }
    public Medico getMedico(){
        return medico;
    }
    public Paciente getPaciente(){
        return paciente;
    }
    public double getValor(){
        return valor;
    }
    public void setNro(int nro) {
        this.nro = nro; 
    }
    public void setData(Data data){
        this.data = data;
    }
    public void setMedico(Medico medico){
        this.medico = medico;
    }
    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }
    public void setValor(double valor){
        this.valor = valor;
    }

    public String toString(){
        return "Consulta{nro=" +nro +", data=" +data +"medico=" +medico.getNome() +" (" +medico.getEspecialidade() +")" +", paciente=" +paciente.getNome() +", valor=R$" +String.format("%.2f", valor) +"}";
    }

}