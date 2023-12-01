/**
 * Interceptador para rest manager
 */
package com.inditex.api.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

public class PlusEncoderInterceptor implements ClientHttpRequestInterceptor {
    /**
     * Examina la url y de encontrar un simbolo "+" no lo borra.
     * @param request request de envio
     * @param body body de envio
     * @param execution cliente de ejecucion
     * @return cliente de respuesta
     * @throws IOException excepcion de lectura de fichero
     */
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        return execution.execute(new HttpRequestWrapper(request) {
            @Override
            public URI getURI() {
                URI u = super.getURI();
                String strictlyEscapedQuery = StringUtils.replace(u.getRawQuery(), "+", "%2B");
                return UriComponentsBuilder.fromUri(u)
                        .replaceQuery(strictlyEscapedQuery)
                        .build(true).toUri();
            }
        }, body);
    }
}