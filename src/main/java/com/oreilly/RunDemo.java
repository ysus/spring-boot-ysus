package com.oreilly;

import com.oreilly.config.AppConfig;
import com.oreilly.entities.Game;
import com.oreilly.entities.Team;

import java.text.NumberFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunDemo {
    public static void main(String[] args) {
    	
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

//    	ApplicationContext context =
//              new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	NumberFormat nf = context.getBean(NumberFormat.class);
    	double amount = 1234567.1234567;
    	System.out.println(nf.format(amount));
    	
        Game game1 = context.getBean("game", Game.class); 
        Game game2 = context.getBean("game", Game.class);  
        
        Team royals = context.getBean("royals", Team.class);
        Team redSox = context.getBean("redSox", Team.class);
        Team cubs = context.getBean("cubs", Team.class);

        game1.setHomeTeam(royals);
        game1.setAwayTeam(cubs);
        System.out.println(game1);

        game2.setHomeTeam(cubs);
        game2.setAwayTeam(redSox);
        System.out.println(game2);
        //by default singleton
        System.out.println(game1);

//        context.close();
    }
}
