package br.com.covid.api.controller;

import br.com.covid.api.constants.ApiConstants;
import br.com.covid.api.request.HospitalRequest;
import br.com.covid.api.response.HospitalResponse;
import br.com.covid.core.data.input.HospitalInputPort;
import br.com.covid.core.data.output.HospitalOutputPort;
import br.com.covid.core.exceptions.NotFoundTipoItemException;
import br.com.covid.core.ports.input.ManterHospitalInputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ApiConstants.API_VERSION+ApiConstants.HOSPITAL_PATH)
public class HospitalController {

   private final ManterHospitalInputPort manterHospital;

   public HospitalController(ManterHospitalInputPort manterHospital) {
      this.manterHospital = manterHospital;
   }

   @PostMapping
   public ResponseEntity<HospitalResponse> criarHospital(@RequestBody HospitalRequest hospitalRequest){
      HospitalOutputPort hospitalOutputPort = HospitalOutputPort.builder().build();
      try {
         hospitalOutputPort = this.manterHospital.salvarHospital(HospitalRequest.converterRequestToInputPort(hospitalRequest));
         return new ResponseEntity<HospitalResponse>(HospitalResponse.converterOutputPortToResponse(hospitalOutputPort), HttpStatus.OK);
      }catch(NotFoundTipoItemException e) {
         return new ResponseEntity(HttpStatus.NOT_FOUND);
      }
   }

   @GetMapping
   public List<HospitalResponse> getAllHospitais(){
      var allHospitais = this.manterHospital.getAllHospitais();
      return allHospitais
              .stream()
              .map(HospitalResponse::converterOutputPortToResponse)
              .collect(Collectors.toList());

   }

   @DeleteMapping
   public ResponseEntity deleteHospital(@RequestParam Long id) {
      try {
         this.manterHospital.deleteHospital(id);
      }catch (NoSuchElementException e) {
         return new ResponseEntity(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity(HttpStatus.OK);
   }

   @PatchMapping("/{id}/{novoPercentual}")
   public ResponseEntity<HospitalResponse> atualizarPercentualDeOcupacao(@PathVariable Long id, @PathVariable Float novoPercentual) {
      HospitalOutputPort hospitalOutput;
      try {
         hospitalOutput = this.manterHospital.atualizarPercentualDeOcupacao(id, novoPercentual);
      }catch (NoSuchElementException e) {
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
      return new ResponseEntity(HospitalResponse.converterOutputPortToResponse(hospitalOutput), HttpStatus.OK);
   }

}
