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
    	
        Game game= context.getBean("game", Game.class); 
        
        Team royals = context.getBean("royals", Team.class);
        Team redSox = context.getBean("redSox", Team.class);
        Team cubs = context.getBean("cubs", Team.class);

        game.setHomeTeam(royals);
        game.setAwayTeam(cubs);
        game.playGame();
       // System.out.println(game);

        game.setHomeTeam(cubs);
        game.setAwayTeam(redSox);
        game.playGame();
       // System.out.println(game);

        context.close();
    }
}
