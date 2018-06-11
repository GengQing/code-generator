package pers.gengq.code.generator;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.swagger.models.Model;
import io.swagger.models.Swagger;
import pers.gengq.code.generator.freemarker.Freemarker;
import pers.gengq.code.generator.swagger.SwaggerFactory;
import pers.gengq.code.generator.swagger.model.PropertiesConvertor;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gengqing on 6/8/2018
 **/
public class Generator {

    private Freemarker freemarker;

    private Swagger swagger;

    private String packageName;

    private String author;


    public Generator(String author, String packageName, String swaggerPath) {
        this.author = author;
        this.packageName = packageName;
        swagger = SwaggerFactory.getSwagger(swaggerPath);
        this.freemarker = new Freemarker();
    }

    public void generateDefinitionClass() throws Exception {
        Template template = freemarker.getModelTemplate();
        for (Map.Entry<String, Model> kv : swagger.getDefinitions().entrySet()) {
            String subPackage = packageName + "." + "definition";
            generateClass(template, kv.getKey(), kv.getValue(), subPackage);
        }
    }

    private void generateClass(Template template, String s, Model model, String subPackage) throws IOException, TemplateException {
        Map<String, Object> root = createFreemarkerDataModel(s, model, subPackage);
        String fileName = "target/" + s + ".java";
        FileWriter fileWriter = new FileWriter(fileName, false);
        template.process(root, fileWriter);
    }

    private Map<String, Object> createFreemarkerDataModel(String s, Model model, String subPackage) {
        Map<String, Object> root = new HashMap<>();
        root.put("package", subPackage);
        root.put("author", author);
        root.put("date", LocalDate.now());
        root.put("modelDescription", model.getDescription());
        root.put("modelName", s);
        root.put("properties", PropertiesConvertor.convert(model.getProperties()));
        return root;
    }
}
