package com.bolivar.comunes.numeros.demo.service;

import com.bolivar.comunes.numeros.consumingwebservice.wsdl.NumberToWords;
import com.bolivar.comunes.numeros.consumingwebservice.wsdl.NumberToWordsResponse;
import com.bolivar.comunes.numeros.demo.models.ObtenernumeroenpalabrasResponse;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigInteger;

@Primary
public class NumeroAPalabrasService extends WebServiceGatewaySupport {

    private String endpoint = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso";

    public ObtenernumeroenpalabrasResponse obtenerNumeroAPalabras(BigInteger number) {

        ObtenernumeroenpalabrasResponse response = new ObtenernumeroenpalabrasResponse();
        NumberToWords numberto = new NumberToWords();
        numberto.setUbiNum(number);

        NumberToWordsResponse responseWSDL = (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint, numberto);

        //responseWSDL.setNumberToWordsResult(numberto.getUbiNum().toString());

        response.setResponse(responseWSDL.getNumberToWordsResult());

        return response;

    }

}
