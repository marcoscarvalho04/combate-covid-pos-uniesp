package br.com.covid.core.data.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalInputPort {


    private String nome;
    private String cnpj;
    private String endereco;
    private LocalizacaoInputPort localizacao;


}
