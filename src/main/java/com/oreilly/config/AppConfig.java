package com.oreilly.config;

import com.oreilly.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.text.NumberFormat;
import java.util.List;
import java.util.Set;

@Configuration
@Import(InfrastructureConfig.class)
//@ComponentScan(basePackages = "com.oreilly")
//@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
	public Game game(DataSource dataSource) {
		BaseballGame baseballGame = new BaseballGame(redSox(),cubs());
		baseballGame.setDataSource(dataSource);
		return baseballGame;
	}
	
	@Bean
	public Team redSox() {
		return new RedSox();
	}
	
	@Bean
	public Team cubs() {
		return new RedSox();
	}
	
	
//    @Autowired
//    private DataSource dataSource;

//    @Autowired
//    private List<Team> teams;
//
//    @Bean
//    public NumberFormat nf() {
//        return NumberFormat.getCurrencyInstance();
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Game game() {
//        BaseballGame baseballGame = new BaseballGame(teams.get(0),teams.get(1));
////        baseballGame.setDataSource(dataSource);
//        return baseballGame;
//    }
}
