package br.com.covid.presenter.domain;

import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.data.output.InventarioOutputPort;
import br.com.covid.core.data.output.ItemOutputPort;
import br.com.covid.core.data.output.LocalizacaoOutputPort;
import br.com.covid.core.exceptions.NotFoundTipoItemException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String cnpj;

    @Column
    private String endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "localizacao_id")
    private LocalizacaoEntity localizacao;

    @Column
    private Float percentualOcupacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventario_id")
    private InventarioEntity inventario;






    public static HospitalEntity converterOutputPortToEntity(HospitalOutputPort hospitalOutputPort) throws NotFoundTipoItemException {
        LocalizacaoEntity localizacaoEntity = LocalizacaoEntity.builder()
                .latitude(hospitalOutputPort.getLocalizacao().getLatitude())
                .longitude(hospitalOutputPort.getLocalizacao().getLongitude())
                .build();

        int counter = 0;
        List<Item> itens = Item.outputPortToItem(hospitalOutputPort.getInventarioOutputPort().getItens());

        InventarioEntity inventarioEntity = InventarioEntity
                .builder()
                .itens(itens)
                .build();

        inventarioEntity.calculaPontosDoInventario();

        return HospitalEntity.builder()
                .cnpj(hospitalOutputPort.getCnpj())
                .endereco(hospitalOutputPort.getEndereco())
                .nome(hospitalOutputPort.getNome())
                .localizacao(localizacaoEntity)
                .inventario(inventarioEntity)
                .percentualOcupacao(hospitalOutputPort.getPercentualDeOcupacao())
                .build();

    }

    public static HospitalOutputPort converterEntityToOutput(HospitalEntity entity) {
        LocalizacaoOutputPort outputPort = LocalizacaoOutputPort.builder()
                .longitude(entity.getLocalizacao().getLongitude())
                .latitude(entity.getLocalizacao().getLatitude())
                .build();
        InventarioOutputPort inventarioOutputPort = InventarioOutputPort
                .builder()
                .pontosDoInventario(entity.getInventario().getPontosDoInventario())
                .id(entity.getId())
                .itens(Item.itemToOutputPort(entity.inventario.getItens()))

                .build();

        return HospitalOutputPort.builder()
                .localizacao(outputPort)
                .cnpj(entity.getCnpj())
                .nome(entity.getNome())
                .id(entity.getId())
                .endereco(entity.getEndereco())
                .percentualDeOcupacao(entity.getPercentualOcupacao())
                .inventarioOutputPort(inventarioOutputPort)
                .build();
    }




}
