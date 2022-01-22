package br.com.covid.presenter.domain;

import br.com.covid.core.data.output.ItemOutputPort;
import br.com.covid.core.exceptions.NotFoundTipoItemException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;

    private TipoDoItem tipoDoItem;

    public static List<Item> outputPortToItem(List<ItemOutputPort> itensOutputPort) throws NotFoundTipoItemException {
        List<Item> itens = new LinkedList<Item>();
        try {
            itensOutputPort.forEach(itemOutputPort -> {
                var item = Item
                        .builder()
                        .tipoDoItem(TipoDoItem.valueOf(itemOutputPort.getTipoDoItem()))
                        .quantidade(itemOutputPort.getQuantidade())
                        .build();
                itens.add(item);

            });
        }catch (IllegalArgumentException e) {
            throw new NotFoundTipoItemException();
        }
        return itens;

    }

    public static List<ItemOutputPort> itemToOutputPort(List<Item> itens ){
        List<ItemOutputPort> itensOutputPort = new LinkedList<ItemOutputPort>();
        itens.forEach(item -> {
            ItemOutputPort itemOutputPort = ItemOutputPort.builder()
                    .quantidade(item.getQuantidade())
                    .tipoDoItem(item.tipoDoItem.getDescricao())
                    .id(item.getId())
                    .build();
            itensOutputPort.add(itemOutputPort);
        });
        return itensOutputPort;
    }


}
