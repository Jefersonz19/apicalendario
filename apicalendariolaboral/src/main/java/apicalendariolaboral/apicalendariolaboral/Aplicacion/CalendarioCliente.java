
// Elaborado por:  Jeferson Zapata


package apicalendariolaboral.apicalendariolaboral.Aplicacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import java.util.stream.Collectors;

import apicalendariolaboral.apicalendariolaboral.core.Dto.CalendarioDto;
import apicalendariolaboral.apicalendariolaboral.core.Dto.FestivoDto;

@Service
public class CalendarioCliente {

    @Autowired
    private RestTemplate restemplate;

    public CalendarioDto obtener(int year) {
        String url = "http://localhost:3029/festivos/obtener/" + year;
        ResponseEntity<CalendarioDto> responseEntity = restemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<CalendarioDto>() {
                });
        return responseEntity.getBody();
    }

    public List<FestivoDto> listarFestivos(int year){
        String url = "http://localhost:3029/festivos/obtener/" + year;
        ResponseEntity<List<FestivoDto>> responseEntity=restemplate.exchange(url, HttpMethod.GET, null, 
            new ParameterizedTypeReference<List<FestivoDto>>() {
                
            });
        return responseEntity.getBody();
    }

        public List<FestivoDto> obtenerFestivo(int year) {
        String BASE_URL = "http://localhost:3029/festivos/obtener/" + year;
        ResponseEntity<List<FestivoDto>> responseEntity = restemplate.exchange(
                BASE_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<FestivoDto>>() {
                });
                return responseEntity.getBody();
        //List<FestivoDto> festivosDto = responseEntity.getBody();
        //return festivosDto.stream()
                // .map(festivosDto::get())
              //  .collect(Collectors.toList());
    }

}