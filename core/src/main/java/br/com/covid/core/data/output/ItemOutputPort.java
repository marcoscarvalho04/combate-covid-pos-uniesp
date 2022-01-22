package br.com.covid.core.data.output;


import br.com.covid.core.data.input.ItemInputPort;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@Builder

public class ItemOutputPort {

    private Long id;

    private Integer quantidade;

    private String tipoDoItem;

    public static List<ItemOutputPort> itemInputPortToOutputPort(List<ItemInputPort> itens ){
        List<ItemOutputPort> itemOutputPort = new LinkedList<ItemOutputPort>();
        itens.forEach(itemInputPort -> {
            var outputPortElement = ItemOutputPort
                    .builder()
                    .tipoDoItem(itemInputPort.getTipoDoItem())
                    .quantidade(itemInputPort.getQuantidade())

                    .build();
            itemOutputPort.add(outputPortElement);
        });
        return itemOutputPort;
    }

}
