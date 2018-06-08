package pers.gengq.code.generator.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;

/**
 * Created by gengqing on 6/8/2018
 **/
public class Freemarker {

    private Configuration configuration;

    public Freemarker() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setClassForTemplateLoading(Freemarker.class, "/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        this.configuration = cfg;
    }

    public Template getModelTemplate() throws IOException {
        Template template = configuration.getTemplate("Model.ftlh");
        return template;
    }


}
