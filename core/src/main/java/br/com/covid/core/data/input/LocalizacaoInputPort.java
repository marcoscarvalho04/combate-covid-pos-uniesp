package br.com.covid.core.data.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocalizacaoInputPort {

    private String latitude;
    private String longitude;
}
