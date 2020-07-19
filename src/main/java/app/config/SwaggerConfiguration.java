package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @author pickjob@126.com
 * @date 2020-06-01
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .globalOperationParameters(List.of(new ParameterBuilder()
                        .name("Authorization")
                        .description("鉴权token")
                        .defaultValue("Bearer eyJhbGciOiJSUzI1NiJ9.eyJleHAiOjE1OTQ5NTYxOTAsInN1YiI6IjEiLCJhY2NvdW50IjoiY2hpbmEifQ.Bc_ht_oDof2LvYIf42zazLPfkslGeVOnH7t1W-N9bhgLoDb-6ionLzzTLBIBSD0idWf1lwxCNamjFWVAiijKpQ16CMNdDf3aXobUAVNL0lwu5haRp5qthe-XrQIcQrt9AdCmTnjkdmhvmwMrCtdIkiXsaxD4ABlJnlDfiFzOBsmxzxMW2oGKTQY13c5MLdXHoAjjLE8Okm5xqqseo47twiBLv_vl8hbziRPueJmJz_e7oZajnALKdEvXPll_t229z7S9Qq-8otFvmS7YqETNeW6iYcr1C9HQ1CAUpWWM9EfTKF51id3B5g5B1j0mjqdBipQI8QV_KqD2rkhDJ6QH_w")
                        .parameterType("header")
                        .modelRef(new ModelRef("header"))
                        .build()))
                ;
    }
}
