package br.com.covid.core.ports.output;

import br.com.covid.core.data.output.HospitalOutputPort;

public interface ManterHospitalOutputPort {

    void salvarHospital(HospitalOutputPort hospitalOutputPort);
}
