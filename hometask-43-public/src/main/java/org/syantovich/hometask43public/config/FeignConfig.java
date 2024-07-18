package org.syantovich.hometask43public.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;
import org.syantovich.hometask43public.dto.ErrorDto;
import org.syantovich.hometask43public.exc.CommonException;

import java.io.InputStream;

@Configuration
public class FeignConfig implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        try (InputStream inputStream = response.body().asInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorDto errorDto = objectMapper.readValue(inputStream, ErrorDto.class);
            return new CommonException(errorDto.getCode(), errorDto.getMessage());
        } catch (Exception e) {
            throw new CommonException(500, "Что-то пошло не так");
        }
    }
}
