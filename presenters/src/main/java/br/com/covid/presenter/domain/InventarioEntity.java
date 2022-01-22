package br.com.covid.presenter.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class InventarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pontosDoInventario;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "inventario_id")
    private List<Item> itens;



    public void calculaPontosDoInventario(){
        if(this.pontosDoInventario == null ){
            this.pontosDoInventario = 0;
        }
        this.itens.forEach(item -> {
            pontosDoInventario += item.getTipoDoItem().calculaPontosDoItem(item);
        });
    }

    public void adicionarItem(List<Item> itens) {
        this.itens = itens;
    }
    public void adicionarItem(Item item){
        this.itens.add(item);
    }






}
