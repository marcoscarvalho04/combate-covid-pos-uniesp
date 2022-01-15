package br.com.covid.presenter.entity;

import br.com.covid.core.data.output.HospitalOutputPort;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
                .id(null)
                .build();

        return HospitalEntity.builder()
                .id(null)
                .cnpj(hospitalOutputPort.getCnpj())
                .endereco(hospitalOutputPort.getEndereco())
                .nome(hospitalOutputPort.getNome())
                .localizacao(localizacaoEntity)
                .build();

    }




}
