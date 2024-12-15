package com.example;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerConfig {
    private static Configuration cfg;

    public static Configuration getConfiguration() {
        if (cfg == null) {
            cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setClassForTemplateLoading(FreemarkerConfig.class, "/templates");
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        }
        return cfg;
    }
}
