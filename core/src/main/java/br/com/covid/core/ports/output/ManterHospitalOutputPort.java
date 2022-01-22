package br.com.covid.core.ports.output;

import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.exceptions.NotFoundTipoItemException;

import java.util.List;
import java.util.NoSuchElementException;

public interface ManterHospitalOutputPort {


    HospitalOutputPort salvarHospital(HospitalOutputPort hospitalOutputPort) throws NotFoundTipoItemException;
    List<HospitalOutputPort> getAllHospitais();
    void deleteHospital(Long id) throws NoSuchElementException;
    HospitalOutputPort atualizarPercentualDeOcupacao(Long id, Float percentualDeOcupacao) throws NoSuchElementException;
}
