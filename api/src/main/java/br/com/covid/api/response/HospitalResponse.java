package br.com.covid.api.response;

import br.com.covid.core.data.input.HospitalInputPort;
import br.com.covid.core.data.input.LocalizacaoInputPort;
import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.data.output.InventarioOutputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponse {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private LocalizacaoResponse localizacao;
    private Float percentualDeOcupacao;
    private InventarioResponse inventarioResponse;

    public static HospitalResponse converterOutputPortToResponse(HospitalOutputPort outputPort){

        LocalizacaoResponse response = LocalizacaoResponse.builder()
                .latitude(outputPort.getLocalizacao().getLatitude())
                .longitude(outputPort.getLocalizacao().getLongitude())
                .build();

        InventarioResponse inventarioOutputPort = InventarioResponse.builder()
                .pontosDoInventario(outputPort.getInventarioOutputPort().getPontosDoInventario())
                .id(outputPort.getId())
                .itemResponse(ItemResponse.itemOutputPortToResponse(outputPort.getInventarioOutputPort().getItens()))
                .build();

        return HospitalResponse.builder()
                .id(outputPort.getId())
                .cnpj(outputPort.getCnpj())
                .endereco(outputPort.getEndereco())
                .nome(outputPort.getNome())
                .localizacao(response)
                .percentualDeOcupacao(outputPort.getPercentualDeOcupacao())
                .inventarioResponse(InventarioResponse.outputPortToInventarioResponse(outputPort.getInventarioOutputPort()))
                .build();
    }

}
