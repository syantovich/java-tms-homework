package org.example.configs;

import org.example.*;
import org.example.interfaces.UserConnectorService;
import org.example.services.BetInfoService;
import org.example.services.UserConnectorServiceConsole;
import org.springframework.context.annotation.*;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("org.example.aspect")
@EnableAspectJAutoProxy
public class App {

    @Bean
    public Player player() {
        return new Player();
    }

    @Bean
    public UserConnectorService userConnectorService() {
        return new UserConnectorServiceConsole();
    }

    @Bean
    @Scope("prototype")
    public Horse horse() {
        return new Horse();
    }

    @Bean
    @Scope("prototype")
    public Rider rider() {
        return new Rider();
    }

    @Bean
    @Scope("prototype")
    public RidePair ridePair(Horse horse, Rider rider) {
        return new RidePair(horse, rider);
    }

    @Bean
    public List<RidePair> ridePairs() {
        return Arrays.asList(
                ridePair(horse(), rider()),
                ridePair(horse(), rider()),
                ridePair(horse(), rider()),
                ridePair(horse(), rider())
        );
    }

    @Bean
    public Game game() {
        return new Game();
    }

    @Bean
    public BetInfoService betInfoService(Player player, UserConnectorService userConnectorService, Game game) {
        return new BetInfoService(player, userConnectorService, game);
    }

}
