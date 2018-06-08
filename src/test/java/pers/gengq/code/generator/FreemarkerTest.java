package pers.gengq.code.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Test;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Created by gengqing on 6/8/2018
 **/
public class FreemarkerTest {

    @Test
    public void test() throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        Template template = cfg.getTemplate("JavaBean.ftlh");
        assertNotNull(template);

        Map<String, Object> root = new HashMap<>();
        String packageName = "com.ericsson.fms";
        root.put("package", packageName);
        root.put("author", "gengqing");
        root.put("date", LocalDate.now());
        root.put("modelName", "Pet");
        root.put("proertyName", "id");

        Map<String, Object> model = new HashMap<>();
        model.put("description", "this is a pet");

        Map<String, Object> property = new HashMap<>();
        property.put("type", "int");

        root.put("model", model);
        root.put("property", property);


        String fileName = "target/JavaBean.java";
        FileWriter fileWriter = new FileWriter(fileName, false);
        template.process(root, fileWriter);
    }


}
