package br.com.covid.core.ports.input;

import br.com.covid.core.data.input.HospitalInputPort;
import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.exceptions.NotFoundTipoItemException;

import java.util.List;
import java.util.NoSuchElementException;

public interface ManterHospitalInputPort {

    HospitalOutputPort salvarHospital(HospitalInputPort inputPort) throws NotFoundTipoItemException;
    List<HospitalOutputPort> getAllHospitais();
    void deleteHospital(Long id) throws NoSuchElementException;
    HospitalOutputPort atualizarPercentualDeOcupacao(Long id, Float percentualDeOcupacao) throws NoSuchElementException;
}
