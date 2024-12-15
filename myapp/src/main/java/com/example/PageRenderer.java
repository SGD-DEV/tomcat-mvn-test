package com.example;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class PageRenderer {
    private final Configuration cfg;
    private final Map<String, String> pages;

    public PageRenderer() {
        this.cfg = FreemarkerConfig.getConfiguration();
        this.pages = new HashMap<>();

        // Seiten registrieren
        registerPages();
    }

    // Alle Seiten explizit registrieren
    private void registerPages() {
        pages.put("home", "home.ftl");           // Root-Level-Seite
        pages.put("page1", "pages/page1.ftl");  // Seite im Ordner "pages"
        pages.put("page2", "test/page2.ftl");   // Seite im Ordner "test"
    }

    // Seite rendern basierend auf dem registrierten Namen
    public String renderPage(String pageName) {
        if (!pages.containsKey(pageName)) {
            return "Fehler: Die Seite \"" + pageName + "\" wurde nicht registriert.";
        }

        String templatePath = pages.get(pageName);

        try {
            Template template = cfg.getTemplate(templatePath);
            StringWriter out = new StringWriter();
            template.process(null, out); // Keine Daten übergeben
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Fehler: Die Seite \"" + pageName + "\" konnte nicht geladen werden.";
        }
    }

    public static void main(String[] args) {
        PageRenderer renderer = new PageRenderer();

        // Home-Seite rendern
        System.out.println(renderer.renderPage("home"));

        // Seite 1 rendern
        System.out.println(renderer.renderPage("page1"));

        // Seite 2 rendern
        System.out.println(renderer.renderPage("page2"));

        // Fehler: Nicht registrierte Seite
        System.out.println(renderer.renderPage("page3"));
    }
}
