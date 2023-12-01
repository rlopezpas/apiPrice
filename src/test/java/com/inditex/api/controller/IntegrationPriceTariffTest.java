/**
 * Clase de testing integrado para TDD
 */
package com.inditex.api.controller;

import com.inditex.api.config.PlusEncoderInterceptor;
import com.inditex.api.controller.dto.PriceTariffResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationPriceTariffTest {

    @LocalServerPort
    private String port;

    private String baseUrl="http://localhost";

    private static RestTemplate restTemplate;

    @BeforeAll
    public static void init(){
        restTemplate=new RestTemplateBuilder()
                .interceptors(new PlusEncoderInterceptor())
                .build();;

    }

    @BeforeEach
    public void setUp(){
        baseUrl=baseUrl.concat(":").concat(port+"/api/price-tariff");
    }

    /**
     * Test numero 1
     */
    @Test
    @Sql(scripts={"classpath:data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements="DELETE FROM PRICE_TARIFF;", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void test1(){
        String fechaHoraString = "2020-06-14T09:00:00+00:02";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/price")
                .queryParam("applicationDate", fechaHoraString)
                .queryParam("productId", 35455)
                .queryParam("brandId", 1);

        String urlPrice = builder.toUriString();

        ResponseEntity<PriceTariffResponseDTO> price = restTemplate.
                getForEntity(urlPrice, PriceTariffResponseDTO.class);


        assertEquals(HttpStatus.OK, price.getStatusCode());
        assertEquals(10, price.getBody().getPriceId());

    }

    /**
     * Test numero 2
     */
    @Test
    @Sql(scripts={"classpath:data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements="DELETE FROM PRICE_TARIFF;", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void test2(){
        String fechaHoraString = "2020-06-14T15:00:00+00:02";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/price")
                .queryParam("applicationDate", fechaHoraString)
                .queryParam("productId", 35455)
                .queryParam("brandId", 1);

        String urlPrice = builder.toUriString();

        ResponseEntity<PriceTariffResponseDTO> price = restTemplate.
                getForEntity(urlPrice, PriceTariffResponseDTO.class);


        assertEquals(HttpStatus.OK, price.getStatusCode());
        assertEquals(20, price.getBody().getPriceId());

    }

    /**
     * Test numero 3
     */
    @Test
    @Sql(scripts={"classpath:data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements="DELETE FROM PRICE_TARIFF;", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void test3(){
        String fechaHoraString = "2020-06-14T20:00:00+00:02";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/price")
                .queryParam("applicationDate", fechaHoraString)
                .queryParam("productId", 35455)
                .queryParam("brandId", 1);

        String urlPrice = builder.toUriString();

        ResponseEntity<PriceTariffResponseDTO> price = restTemplate.
                getForEntity(urlPrice, PriceTariffResponseDTO.class);


        assertEquals(HttpStatus.OK, price.getStatusCode());
        assertEquals(10, price.getBody().getPriceId());

    }

    /**
     * Test numero 4
     */
    @Test
    @Sql(scripts={"classpath:data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements="DELETE FROM PRICE_TARIFF;", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void test4(){
        String fechaHoraString = "2020-06-15T09:00:00+00:02";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/price")
                .queryParam("applicationDate", fechaHoraString)
                .queryParam("productId", 35455)
                .queryParam("brandId", 1);

        String urlPrice = builder.toUriString();

        ResponseEntity<PriceTariffResponseDTO> price = restTemplate.
                getForEntity(urlPrice, PriceTariffResponseDTO.class);


        assertEquals(HttpStatus.OK, price.getStatusCode());
        assertEquals(30, price.getBody().getPriceId());

    }

    /**
     * Test numero 5
     */
    @Test
    @Sql(scripts={"classpath:data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements="DELETE FROM PRICE_TARIFF;", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void test5(){
        String fechaHoraString = "2020-06-15T20:00:00+00:02";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/price")
                .queryParam("applicationDate", fechaHoraString)
                .queryParam("productId", 35455)
                .queryParam("brandId", 1);

        String urlPrice = builder.toUriString();

        ResponseEntity<PriceTariffResponseDTO> price = restTemplate.
                getForEntity(urlPrice, PriceTariffResponseDTO.class);


        assertEquals(HttpStatus.OK, price.getStatusCode());
        assertEquals(40, price.getBody().getPriceId());

    }

    /**
     * Testea el limite de tiempo inicial
     */
    @Test
    @Sql(scripts={"classpath:data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements="DELETE FROM PRICE_TARIFF;", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testHourLimits(){
        String fechaHoraString = "2020-06-14T12:59:59+00:02";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/price")
                .queryParam("applicationDate", fechaHoraString)
                .queryParam("productId", 35455)
                .queryParam("brandId", 1);

        String urlPrice = builder.toUriString();

        ResponseEntity<PriceTariffResponseDTO> price = restTemplate.
                getForEntity(urlPrice, PriceTariffResponseDTO.class);


        assertEquals(HttpStatus.OK, price.getStatusCode());
        assertEquals(10, price.getBody().getPriceId());

    }

    /**
     * Testea el limite de tiempo final
     */
    @Test
    @Sql(scripts={"classpath:data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements="DELETE FROM PRICE_TARIFF;", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testHourLimits2(){
        String fechaHoraString = "2020-06-14T16:30:00+00:02";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/price")
                .queryParam("applicationDate", fechaHoraString)
                .queryParam("productId", 35455)
                .queryParam("brandId", 1);

        String urlPrice = builder.toUriString();

        ResponseEntity<PriceTariffResponseDTO> price = restTemplate.
                getForEntity(urlPrice, PriceTariffResponseDTO.class);


        assertEquals(HttpStatus.OK, price.getStatusCode());
        assertEquals(20, price.getBody().getPriceId());

    }

    /**
     * Testea la entrada de parametros del controlador
     */
    @Test
    @Sql(scripts={"classpath:data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements="DELETE FROM PRICE_TARIFF;", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void badRequest(){
        //Probamos todos los parametros
        //productId
        String fechaHoraString = "2020-06-14T16:30:00+00:02";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/price")
                .queryParam("applicationDate", fechaHoraString)
                .queryParam("brandId", 1);

        String urlPrice = builder.toUriString();

        try {
            restTemplate.
                    getForEntity(urlPrice, PriceTariffResponseDTO.class);
        }catch (Exception ex){
           Assertions.assertTrue(ex.getMessage()
                   .contains(String.valueOf(HttpStatus.BAD_REQUEST.value())));
        }
        //brandId
        fechaHoraString = "2020-06-14T16:30:00+00:02";
        builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/price")
                .queryParam("applicationDate", fechaHoraString)
                .queryParam("productId", 1);

        urlPrice = builder.toUriString();

        try {
            restTemplate.
                    getForEntity(urlPrice, PriceTariffResponseDTO.class);
        }catch (Exception ex){
            Assertions.assertTrue(ex.getMessage()
                    .contains(String.valueOf(HttpStatus.BAD_REQUEST.value())));
        }
        //applicationDate En formato incorrecto
        fechaHoraString = "2020-06-14T16:30:00";
        builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/price")
                .queryParam("applicationDate", fechaHoraString)
                .queryParam("productId", 35455)
                .queryParam("brandId", 1);
        urlPrice = builder.toUriString();
        try {
            restTemplate.
                    getForEntity(urlPrice, PriceTariffResponseDTO.class);
        }catch (Exception ex){
            Assertions.assertTrue(ex.getMessage()
                    .contains(String.valueOf(HttpStatus.BAD_REQUEST.value())));
        }
        //applicationDate
        builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/price")
                .queryParam("productId", 35455)
                .queryParam("brandId", 1);
        urlPrice = builder.toUriString();
        try {
            restTemplate.
                    getForEntity(urlPrice, PriceTariffResponseDTO.class);
        }catch (Exception ex){
            Assertions.assertTrue(ex.getMessage()
                    .contains(String.valueOf(HttpStatus.BAD_REQUEST.value())));
        }
    }
    /**
     * Testea precio no encontrado
     */
    @Test
    @Sql(scripts={"classpath:data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements="DELETE FROM PRICE_TARIFF;", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void notFound(){
        //Probamos todos los parametros
        //productId
        String fechaHoraString = "2023-06-14T16:30:00+00:02";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/price")
                .queryParam("applicationDate", fechaHoraString)
                .queryParam("productId", 35455)
                .queryParam("brandId", 1);

        String urlPrice = builder.toUriString();

        try {
            restTemplate.
                    getForEntity(urlPrice, PriceTariffResponseDTO.class);
        }catch (Exception ex){
            Assertions.assertTrue(ex.getMessage()
                    .contains(String.valueOf(HttpStatus.NOT_FOUND.value())));
        }
    }
}
