package br.com.covid.api.response;

import br.com.covid.core.data.output.InventarioOutputPort;
import br.com.covid.core.data.output.ItemOutputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventarioResponse {

    private Long id;
    private Integer pontosDoInventario;
    private List<ItemResponse> itemResponse;

    public static InventarioResponse outputPortToInventarioResponse(InventarioOutputPort inventarioOutputPort){
        InventarioResponse inventarioResponse = InventarioResponse
                .builder()
                .id(inventarioOutputPort.getId())
                .pontosDoInventario(inventarioOutputPort.getPontosDoInventario())
                .itemResponse(ItemResponse.itemOutputPortToResponse(inventarioOutputPort.getItens()))
                .build();
        return inventarioResponse;
    }
}
