package br.com.covid.core.usecase;

import br.com.covid.core.data.input.HospitalInputPort;
import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.ports.input.ManterHospitalInputPort;
import br.com.covid.core.ports.output.ManterHospitalOutputPort;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class ManterHospitalUseCaseInputImpl implements ManterHospitalInputPort {

    @Autowired
    private final ManterHospitalOutputPort manterHospitalOutputPort;

    public ManterHospitalUseCaseInputImpl(ManterHospitalOutputPort manterHospitalOutputPort){
        this.manterHospitalOutputPort = manterHospitalOutputPort;

    }
    @Override
    public void salvarHospital(HospitalInputPort inputPort) {
        this.manterHospitalOutputPort.salvarHospital(HospitalOutputPort.converterInputToOutput(inputPort));
    }
}
