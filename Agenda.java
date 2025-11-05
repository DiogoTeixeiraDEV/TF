public class Agenda {
    private Consulta[] consultas;
    private int nroConsultas;

    public Agenda() {
        consultas = new Consulta[40];
        nroConsultas = 0;
    }

    public boolean adicionarConsulta(Consulta consulta) {
        if (nroConsultas < consultas.length) {
            consultas[nroConsultas] = consulta;
            nroConsultas++;
            return true;
        }
        return false;
    }

    public boolean removerConsulta(int nro) {
        int pos = buscarPosicao(nro);
        if (pos != -1) {
            for (int i = pos; i < nroConsultas - 1; i++) {
                consultas[i] = consultas[i + 1];
            }
            consultas[nroConsultas - 1] = null;
            nroConsultas--;
            return true;
        }
        return false;
    }

    public Consulta buscarConsultaPorNro(int nro) {
        for (int i = 0; i < nroConsultas; i++) {
            if (consultas[i].getNro() == nro) {
                return consultas[i];
            }
        }
        return null;
    }

    public int buscarPosicao(int nro) {
        for (int i = 0; i < nroConsultas; i++) {
            if (consultas[i].getNro() == nro) {
                return i;
            }
        }
        return -1;
    }

    public Consulta[] buscarConsultaMedico(String nomeMedico) {
        int cont = 0;
        for (int i = 0; i < nroConsultas; i++) {
            if (consultas[i].getMedico().getNome().equalsIgnoreCase(nomeMedico)) {
                cont++;
            }
        }
        Consulta[] resultado = new Consulta[cont];
        int j = 0;
        for (int i = 0; i < nroConsultas; i++) {
            if (consultas[i].getMedico().getNome().equalsIgnoreCase(nomeMedico)) {
                resultado[j++] = consultas[i];
            }
        }
        return resultado;
    }

    public String buscarConsultaPaciente(int codigoPaciente) {
        for (int i = 0; i < nroConsultas; i++) {
            if (consultas[i].getPaciente().getCodigo() == codigoPaciente) {
                return consultas[i].getData().toString();
            }
        }
        return null;
    }

    public Consulta[] buscarConsultaData(int dia, int mes, int ano) {
        int cont = 0;
        for (int i = 0; i < nroConsultas; i++) {
            Data d = consultas[i].getData();
            if (d.getDia() == dia && d.getMes() == mes && d.getAno() == ano) {
                cont++;
            }
        }
        Consulta[] resultado = new Consulta[cont];
        int j = 0;
        for (int i = 0; i < nroConsultas; i++) {
            Data d = consultas[i].getData();
            if (d.getDia() == dia && d.getMes() == mes && d.getAno() == ano) {
                resultado[j++] = consultas[i];
            }
        }
        return resultado;
    }

    public double buscarValorConsultasPorEspecialidadeMedica(String especialidade) {
        double soma = 0;
        for (int i = 0; i < nroConsultas; i++) {
            if (consultas[i].getMedico().getEspecialidade().equalsIgnoreCase(especialidade)) {
                soma += consultas[i].getValor();
            }
        }
        return soma;
    }

    public boolean alterarMedico(int nro, Medico novoMedico) {
        Consulta c = buscarConsultaPorNro(nro);
        if (c != null) {
            c.setMedico(novoMedico);
            return true;
        }
        return false;
    }

    public Consulta buscarConsultaMaisBarata() {
        if (nroConsultas == 0) return null;
        Consulta maisBarata = consultas[0];
        for (int i = 1; i < nroConsultas; i++) {
            if (consultas[i].getValor() < maisBarata.getValor()) {
                maisBarata = consultas[i];
            }
        }
        return maisBarata;
    }

    public void mostraAgenda() {
        if (nroConsultas == 0) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        System.out.println("=== Agenda de Consultas ===");
        for (int i = 0; i < nroConsultas; i++) {
            System.out.println(consultas[i]);
        }
    }

    // Getters
    public Consulta[] getConsultas() {
        return consultas;
    }

    public int getNroConsultas() {
        return nroConsultas;
    }

    @Override
    public String toString() {
        String resultado = "Agenda de Consultas:\n";
        for (int i = 0; i < nroConsultas; i++) {
            resultado += consultas[i].toString() + "\n";
        }
        return resultado;
    }
}

