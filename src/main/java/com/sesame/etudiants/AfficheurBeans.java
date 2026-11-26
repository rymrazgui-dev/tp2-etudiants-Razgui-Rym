package com.sesame.etudiants;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;



@Component
public class AfficheurBeans implements CommandLineRunner {

    private final ApplicationContext context;


    public AfficheurBeans(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) {
        System.out.println("===== Beans contenant \"etudiant\" =====");
        for (String nom : context.getBeanDefinitionNames()) {
            if (nom.toLowerCase().contains("etudiant")) {
                System.out.println(" - " + nom);
            }
        }
        System.out.println("=====================================");
    }
}
