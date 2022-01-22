package br.com.covid.core.usecase;

import br.com.covid.core.data.input.HospitalInputPort;
import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.exceptions.NotFoundTipoItemException;
import br.com.covid.core.ports.input.ManterHospitalInputPort;
import br.com.covid.core.ports.output.ManterHospitalOutputPort;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Data
public class ManterHospitalUseCaseInputImpl implements ManterHospitalInputPort {

    @Autowired
    private final ManterHospitalOutputPort manterHospitalOutputPort;

    public ManterHospitalUseCaseInputImpl(ManterHospitalOutputPort manterHospitalOutputPort){
        this.manterHospitalOutputPort = manterHospitalOutputPort;

    }
    @Override
    public HospitalOutputPort salvarHospital(HospitalInputPort inputPort) throws NotFoundTipoItemException {
        return this.manterHospitalOutputPort.salvarHospital(HospitalOutputPort.converterInputToOutput(inputPort));

    }

    @Override
    public List<HospitalOutputPort> getAllHospitais() {
        return this.manterHospitalOutputPort.getAllHospitais();
    }

    @Override
    public void deleteHospital(Long id) throws NoSuchElementException {
        this.manterHospitalOutputPort.deleteHospital(id);
    }

    @Override
    public HospitalOutputPort atualizarPercentualDeOcupacao(Long id, Float percentualDeOcupacao) {
       return this.manterHospitalOutputPort.atualizarPercentualDeOcupacao(id, percentualDeOcupacao);
    }
}
