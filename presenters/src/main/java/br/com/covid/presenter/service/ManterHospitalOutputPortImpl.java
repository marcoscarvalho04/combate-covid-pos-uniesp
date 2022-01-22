package br.com.covid.presenter.service;

import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.exceptions.NotFoundTipoItemException;
import br.com.covid.core.ports.output.ManterHospitalOutputPort;
import br.com.covid.presenter.domain.HospitalEntity;
import br.com.covid.presenter.repository.HospitalRepository;
import br.com.covid.presenter.repository.LocalizacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class ManterHospitalOutputPortImpl implements ManterHospitalOutputPort {

    private HospitalRepository hospitalRepository;
    private LocalizacaoRepository localizacaoRepository;

    public ManterHospitalOutputPortImpl(HospitalRepository hospitalRepository, LocalizacaoRepository localizacaoRepository) {
        super();
        this.localizacaoRepository= localizacaoRepository;
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public HospitalOutputPort salvarHospital(HospitalOutputPort hospitalOutputPort) throws NotFoundTipoItemException {
        var toSave = HospitalEntity.converterOutputPortToEntity(hospitalOutputPort);
        return HospitalEntity.converterEntityToOutput(this.hospitalRepository.save(toSave));
    }

    @Override
    public List<HospitalOutputPort> getAllHospitais() {
        return this.hospitalRepository.
                findAll().
                stream().
                map(HospitalEntity::converterEntityToOutput).
                collect(Collectors.toList());
    }

    @Override
    public void deleteHospital(Long id) throws NoSuchElementException{
        try {
            var elementoHospital = this.hospitalRepository.findById(id).get();
            this.hospitalRepository.delete(elementoHospital);
        }catch (NoSuchElementException e) {
            throw e;

        }
    }

    @Override
    public HospitalOutputPort atualizarPercentualDeOcupacao(Long id, Float percentualDeOcupacao) throws NoSuchElementException {
        HospitalEntity elementoHospital;
        try {
            elementoHospital = this.hospitalRepository.findById(id).get();
            elementoHospital.setPercentualOcupacao(percentualDeOcupacao);
            this.hospitalRepository.save(elementoHospital);
        }catch (NoSuchElementException e) {
            throw e;

        }
        return HospitalEntity.converterEntityToOutput(elementoHospital);
    }


}
