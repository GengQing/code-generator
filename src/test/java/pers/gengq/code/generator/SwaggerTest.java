package pers.gengq.code.generator;

import io.swagger.models.Model;
import io.swagger.models.Swagger;
import io.swagger.models.properties.Property;
import io.swagger.parser.SwaggerParser;
import io.swagger.parser.util.SwaggerDeserializationResult;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.assertNotNull;


/**
 * <P>
 *
 * </P>
 * Created by gengqing on 6/7/2018
 **/
public class SwaggerTest {

    private String swagger = "swagger.yaml";

    @Test
    public void parseSwaggerTest() {
        SwaggerDeserializationResult result =
                new SwaggerParser().readWithInfo(swagger, Collections.emptyList(), true);
        result.getMessages().forEach(System.out::println);
        Swagger swagger = result.getSwagger();
        assertNotNull(swagger);
        Map<String, Model> defs = swagger.getDefinitions();
        defs.forEach(this::println);
    }

    public void println(String s, Model model) {
        System.out.println(s + " property--------------");
        Map<String, Property> propertyMap = model.getProperties();
        propertyMap.forEach((s1, property) -> System.out.println(s1 + " : " + property.getType()));
    }

}
