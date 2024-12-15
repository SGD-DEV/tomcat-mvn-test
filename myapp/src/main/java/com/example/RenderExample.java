package com.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class RenderExample {
    public static void main(String[] args) {
        try {
            Configuration cfg = FreemarkerConfig.getConfiguration();
            Template template = cfg.getTemplate("welcome.ftl");

            Map<String, Object> data = new HashMap<>();
            data.put("name", "World");

            StringWriter out = new StringWriter();
            template.process(data, out);
            System.out.println(out.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
