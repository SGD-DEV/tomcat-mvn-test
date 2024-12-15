package com.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class PageRenderer {

    public static void main(String[] args) {
        try {
            // Freemarker-Konfiguration
            Configuration cfg = FreemarkerConfig.getConfiguration();

            // Seiten definieren
            renderPage(cfg, "home.ftl");
            renderPage(cfg, "pages/page1.ftl");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void renderPage(Configuration cfg, String templateName) {
        try {
            Template template = cfg.getTemplate(templateName);

            // Daten an die Seite übergeben
            Map<String, Object> data = new HashMap<>();
            data.put("title", templateName.replace(".ftl", ""));

            // Seite rendern
            StringWriter out = new StringWriter();
            template.process(data, out);

            System.out.println("---- Inhalt von: " + templateName + " ----");
            System.out.println(out.toString());

        } catch (Exception e) {
            System.out.println("Fehler beim Rendern der Seite: " + templateName);
            e.printStackTrace();
        }
    }
}
