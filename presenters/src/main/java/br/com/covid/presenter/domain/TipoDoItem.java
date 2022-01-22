package br.com.covid.presenter.domain;

import br.com.covid.presenter.helper.GerenciarItem;
import lombok.Builder;
import lombok.Getter;

@Getter
public enum TipoDoItem implements GerenciarItem {
    MEDICO(3, "Médico"),
    ENFERMEIRO(3, "Enfermeiro"),
    RESPIRADOR(5, "Respirador"),
    TOMOGRAFO(12, "Tomografo"),
    AMBULANCIA(10, "Ambulancia")
;

    @Override
    public Integer calculaPontosDoItem(Item item) {
        return item.getQuantidade() * this.getValor();
    }

    public Integer valor;
    public String descricao;

    TipoDoItem(Integer valor, String descricao) {
        this.descricao = descricao;
        this.valor = valor;
    }


}
