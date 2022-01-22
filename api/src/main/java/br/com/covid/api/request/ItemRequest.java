package br.com.covid.api.request;

import br.com.covid.core.data.input.ItemInputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ItemRequest {


    private Integer quantidade;

    private String tipoDoItem;

    public static List<ItemInputPort> itemRequestToItemInputPort(List<ItemRequest> itemRequest) {
        List<ItemInputPort> listaDeItemComoInputPort = new LinkedList<ItemInputPort>();
        itemRequest.forEach(item -> {
            var itemInputPort = ItemInputPort.builder()
                    .tipoDoItem(item.getTipoDoItem())
                    .quantidade(item.getQuantidade())
                    .build();
            listaDeItemComoInputPort.add(itemInputPort);
        });

        return listaDeItemComoInputPort;
    }

}
