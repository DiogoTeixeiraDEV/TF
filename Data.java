public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia(){
        return dia;
    }
    public int getMes(){
        return mes;
    }
    public int getAno(){
        return ano;
    }

    private boolean ehBissexto(int Ano){
           return (Ano % 4 == 0 && Ano % 100 != 0) || (Ano % 400 == 0);
    }
    
    public boolean verificarData(){
        if (mes < 1 || mes > 12) {
            return false;
        }
        if (dia < 1 || dia > 31){
            return false;
        }
        int diasNoMes;
        switch (mes){
            case 4:
            case 6:
            case 9:
            case 11:
            diasNoMes = 30;
            break;
            case 2:   // Fevereiro
                if (ehBissexto(ano)) {
                    diasNoMes = 29;
                } else {
                    diasNoMes = 28;
                }
                break;
            default: 
                diasNoMes = 31;
                break;
        }
        return dia >= 1 && dia <= diasNoMes;
    }
    public String toString(){
        return dia +"/" +mes +"/" +ano;
    }
}


