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
                    .example("Bearer eyJhbGciOiJSUzI1NiJ9.eyJleHAiOjE2MzYxODkxOTksInN1YiI6InN1YmplY3QiLCJhY2NvdW50IjoiY2hpbmEifQ.S9AwUpBJ6N6-AwkW2vw7MRZ4PlPFa9QxEpX6pGS2TEiRaI7BUnhuj5zvhAWIrkmnpBpfTMLO-UuKf2nStcTSgX81FxfpqMVw9ITPAMch5X9QMfdZ3TF3Ess33ajSDa0zQUC28aJkdcVsHxnFYOpIgaZbJRa881ZOv-I4Fzw5muaKGUYYjXvp6sm-j264mBspXsp-AI_RCUc4IPZqHtD9Dm5Fh8KUzk174pklvdP97JVwPBAQn-IafOVKk1SE05KRI9OhaS8d_9xgz0iZGv-5W4es0wks3lbIvpTCVXneFck5e3UrCkBK53Ex6n72_KooRGSbeggDc4PL6_NM3RhAxQ")
                    .required(false);
            operation.addParametersItem(customHeaderVersion);
            return operation;
        }
    }
}