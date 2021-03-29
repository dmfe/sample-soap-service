package xyz.dmfe.soap.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xyz.dmfe.sample_soap_service.GetCountryRequest;
import xyz.dmfe.sample_soap_service.GetCountryResponse;
import xyz.dmfe.soap.repository.CountryRepository;

@Endpoint
@RequiredArgsConstructor
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://dmfe.xyz/sample-soap-service";

    private final CountryRepository countryRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        return response;
    }
}
