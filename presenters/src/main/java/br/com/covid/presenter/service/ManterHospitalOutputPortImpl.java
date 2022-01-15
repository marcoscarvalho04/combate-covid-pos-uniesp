package br.com.covid.presenter.service;

import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.ports.output.ManterHospitalOutputPort;
import br.com.covid.presenter.entity.HospitalEntity;
import br.com.covid.presenter.repository.HospitalRepository;
import br.com.covid.presenter.repository.LocalizacaoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public void salvarHospital(HospitalOutputPort hospitalOutputPort) {
        var toSave = HospitalEntity.converterOutputPortToEntity(hospitalOutputPort);
        this.localizacaoRepository.save(toSave.getLocalizacao());
        this.hospitalRepository.save(toSave);
    }
}
