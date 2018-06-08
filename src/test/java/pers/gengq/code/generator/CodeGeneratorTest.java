package pers.gengq.code.generator;

import org.junit.Test;

public class CodeGeneratorTest {

    public static final String SWAGGER_YAML = "swagger.yaml";

    @Test
    public void generateDefinitionClass() throws Exception {
        Generator generator = new Generator("gengq", "com.aili", SWAGGER_YAML);
        generator.generateDefinitionClass();
    }

}
