package br.com.covid.core.ports.input;

import br.com.covid.core.data.input.HospitalInputPort;

public interface ManterHospitalInputPort {

    void salvarHospital(HospitalInputPort inputPort);
}
