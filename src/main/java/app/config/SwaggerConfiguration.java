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
                        .defaultValue("Bearer eyJhbGciOiJSUzI1NiJ9.eyJleHAiOjE2MzA1MDA5MDYsInN1YiI6IjEiLCJhY2NvdW50IjoiY2hpbmEifQ.W1M0OOTyASSw59NWpxQA5zE-ATuw2zkZPuI2rSB2UgomQx2Un2ekkcskFp0j6ep3Fz8GYgKqSNkuNJFX1oBIr6v2a-gzxTtQ0Qvs_ytlzoOAECtLxfMSVRNJltNkHzpe831vv4tIQrkrORg8Y6GuNl2wnG2zvNCdWmQgwGkOlKcsslfriLv5Ktr1WfY02ir-UknCotc4imKLNACSiUa6M9H9hMECOmHG4rpWadTjJAsBHoWj8epa3POrBXCLwS_72mFDEJoweV16jnGvX5laRuHWc0M50C0BT5C6YeMT06tYTEqHJNucublk5WTXUlBgRKrwFzanAhiIx-77PNcJ9Q")
                        .parameterType("header")
                        .modelRef(new ModelRef("header"))
                        .build()))
                ;
    }
}
