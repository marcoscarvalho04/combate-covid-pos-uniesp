package br.com.covid.api.controller;

import br.com.covid.api.constants.ApiConstants;
import br.com.covid.api.request.HospitalRequest;
import br.com.covid.core.ports.input.ManterHospitalInputPort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.API_VERSION+ApiConstants.HOSPITAL_PATH)
public class HospitalController {

   private final ManterHospitalInputPort manterHospital;

   public HospitalController(ManterHospitalInputPort manterHospital) {
      this.manterHospital = manterHospital;
   }

   @PostMapping
   public void criarHospital(@RequestBody HospitalRequest hospitalRequest){
      this.manterHospital.salvarHospital(HospitalRequest.converterRequestToInputPort(hospitalRequest));

   }

}
