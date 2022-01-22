package br.com.covid.api.request;

import br.com.covid.core.data.input.HospitalInputPort;
import br.com.covid.core.data.input.InventarioInputPort;
import br.com.covid.core.data.input.ItemInputPort;
import br.com.covid.core.data.input.LocalizacaoInputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalRequest {

    private String nome;
    private String cnpj;
    private String endereco;
    private LocalizacaoRequest localizacao;
    private Float percentualDeOcupacao;
    private InventarioRequest inventarioRequest;

    public static HospitalInputPort converterRequestToInputPort(HospitalRequest request){

        LocalizacaoInputPort localizacaoInputPort = LocalizacaoInputPort.builder()
                .latitude(request.localizacao.getLatitude())
                .longitude(request.localizacao.getLongitude())
                .build();
        InventarioInputPort inventarioInputPort = InventarioInputPort.builder()
                .itens(ItemRequest.itemRequestToItemInputPort(request.getInventarioRequest().getItens()))
                .build();

        return HospitalInputPort.builder()
                .cnpj(request.cnpj)
                .endereco(request.endereco)
                .nome(request.nome)
                .percentualDeOcupacao(request.getPercentualDeOcupacao())
                .localizacao(localizacaoInputPort)
                .inventarioInputPort(inventarioInputPort)
                .build();
    }

}
