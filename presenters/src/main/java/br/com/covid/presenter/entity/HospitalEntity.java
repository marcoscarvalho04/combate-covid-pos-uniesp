package br.com.covid.presenter.entity;

import br.com.covid.core.data.output.HospitalOutputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String nome;

    @Column
    private String cnpj;

    @Column
    private String endereco;

    @OneToOne
    private LocalizacaoEntity localizacao;


    public static HospitalEntity converterOutputPortToEntity(HospitalOutputPort hospitalOutputPort){
        LocalizacaoEntity localizacaoEntity = LocalizacaoEntity.builder()
                .latitude(hospitalOutputPort.getLocalizacao().getLatitude())
                .longitude(hospitalOutputPort.getLocalizacao().getLongitude())
                .build();

        return HospitalEntity.builder()
                .cnpj(hospitalOutputPort.getCnpj())
                .endereco(hospitalOutputPort.getEndereco())
                .nome(hospitalOutputPort.getNome())
                .localizacao(localizacaoEntity)
                .build();

    }




}
