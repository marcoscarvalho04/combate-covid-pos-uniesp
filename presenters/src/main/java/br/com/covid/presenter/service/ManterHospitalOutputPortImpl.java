package br.com.covid.presenter.service;

import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.ports.output.ManterHospitalOutputPort;
import br.com.covid.presenter.entity.HospitalEntity;
import br.com.covid.presenter.repository.HospitalRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@NoArgsConstructor
@Service
public class ManterHospitalOutputPortImpl implements ManterHospitalOutputPort {

    private HospitalRepository hospitalRepository;

    @Override
    public void salvarHospital(HospitalOutputPort hospitalOutputPort) {
        this.hospitalRepository.save(HospitalEntity.converterOutputPortToEntity(hospitalOutputPort));
    }
}
