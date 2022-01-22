package br.com.covid.core.data.output;

import br.com.covid.core.data.input.ItemInputPort;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder

public class InventarioOutputPort {

    private Long id;
    private Integer pontosDoInventario;
    private List<ItemOutputPort> itens;
}
