package br.com.covid.core.data.input;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class ItemInputPort {

    private Integer quantidade;

    private Integer pontosDoItem;

    private String tipoDoItem;



}
