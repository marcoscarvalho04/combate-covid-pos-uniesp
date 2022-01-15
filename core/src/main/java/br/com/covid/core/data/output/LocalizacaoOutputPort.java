package br.com.covid.core.data.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocalizacaoOutputPort {

    private Long id;
    private String latitude;
    private String longitude;
}
