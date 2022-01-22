package br.com.covid.api.request;

import br.com.covid.core.data.input.InventarioInputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class InventarioRequest {

    private List<ItemRequest> itens;

    public static InventarioInputPort inventarioRequestToInputPort(InventarioRequest inventarioRequest) {
        return InventarioInputPort.builder()
                .itens(ItemRequest.itemRequestToItemInputPort(inventarioRequest.getItens()))
                .build();
    }
}
