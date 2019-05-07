package org.spring.springboot.handler;

import org.spring.springboot.error.GlobalException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class CityHandler {
    
    public Mono<ServerResponse> helloCity(ServerRequest request) {
        return ServerResponse.ok().body(sayHelloCity(request), String.class);
    }
    
    private Mono<String> sayHelloCity(ServerRequest request) {
        Optional<String> cityParamOptional = request.queryParam("city");
        if (!cityParamOptional.isPresent()) {
            throw new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR, "request param city is ERROR");
        }
        
        return Mono.just("Hello," + cityParamOptional.get());
    }
}
