package pers.gengq.code.generator.swagger;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import io.swagger.parser.util.SwaggerDeserializationResult;

import java.util.Collections;
import java.util.Objects;

/**
 * Created by gengqing on 6/8/2018
 **/
public class SwaggerFactory {

    public static Swagger getSwagger(String location) {
        Objects.requireNonNull(location);
        SwaggerDeserializationResult result =
                new SwaggerParser().readWithInfo(location, Collections.emptyList(), true);
        return result.getSwagger();
    }


}
