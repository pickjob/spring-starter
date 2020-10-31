package spring.starter.base.configuration;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import spring.starter.base.consts.SecurityConsts;

/**
 *   http://ip:port/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
 * @author pickjob@126.com
 * @date 2020-06-01
 */
@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI();
    }

    @Component
    public class GlobalHeaderOperationCustomizer implements OperationCustomizer {
        @Override
        public Operation customize(Operation operation, HandlerMethod handlerMethod) {
            Parameter customHeaderVersion = new Parameter()
                    .in(ParameterIn.HEADER.toString())
                    .name(SecurityConsts.SECURITY_HEADER)
                    .description("Authorization： JWT Header")
                    .schema(new StringSchema())
                    .example("Bearer eyJhbGciOiJSUzI1NiJ9.eyJleHAiOjE2MDQwNjEwMTYsInN1YiI6InN1YmplY3QiLCJhY2NvdW50IjoiY2hpbmEifQ.fcgJIbTmljzDkDyC3KbGA2vFuiatxGUEpDcj5VMw__magKVaIfj2wCEFfMgTuT80INV4lufd5D7PWkZn3B7jaeK2wCbdGO6mrLeNolP_gDHJM_pv622vFQ_8iRxhTl67wfkd9Ly6FqoTa0DQgLS7rgU2t4NU_EWN44Fd2vbuC9uWg6M2RhUcKeuZvx-ZPhedkFZzsO2e_-17ES3gxj2Cvzi9DqU7Zn8cILz2MZ60AkJhPxw5Q7d1s-j2e1i8THuJSm_MY4C_CvK7LsP5FmvL2mdrup1JxgJ2DnXmQQYqksx69ZkmiTn7EX_yRT_hGNYloxdLKJfK4HqNHsMCS5tAXg")
                    .required(false);
            operation.addParametersItem(customHeaderVersion);
            return operation;
        }
    }
}