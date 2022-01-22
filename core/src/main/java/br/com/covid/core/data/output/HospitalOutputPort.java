package br.com.covid.core.data.output;

import br.com.covid.core.data.input.HospitalInputPort;
import br.com.covid.core.data.input.LocalizacaoInputPort;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class HospitalOutputPort {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private Float percentualDeOcupacao;
    private LocalizacaoOutputPort localizacao;
    private InventarioOutputPort inventarioOutputPort;


    public static HospitalOutputPort converterInputToOutput(HospitalInputPort hospitalInputPort) {

        LocalizacaoOutputPort localizacaoOutputPort = LocalizacaoOutputPort.builder()
                .latitude(hospitalInputPort.getLocalizacao().getLatitude())
                .longitude(hospitalInputPort.getLocalizacao().getLongitude())
                .build();

        InventarioOutputPort inventarioOutputPort = InventarioOutputPort
                .builder()
                .itens(ItemOutputPort.itemInputPortToOutputPort(hospitalInputPort.getInventarioInputPort().getItens()))
                .build();

        return HospitalOutputPort.builder()
                .cnpj(hospitalInputPort.getCnpj())
                .endereco(hospitalInputPort.getEndereco())
                .nome(hospitalInputPort.getNome())
                .localizacao(localizacaoOutputPort)
                .percentualDeOcupacao(hospitalInputPort.getPercentualDeOcupacao())
                .inventarioOutputPort(inventarioOutputPort)
                .build();
    }
}
