package academy.learnprogramming.console;

import academy.learnprogramming.config.AppConfig;
import academy.learnprogramming.MessageGenerator;
import academy.learnprogramming.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
//    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess The Number Game");
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);
        int number = numberGenerator.next();
        log.info("number = {}", number);

        // get message generator bean from context (container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage={}",messageGenerator.getMainMessage());
        log.info("getResultMessage={}",messageGenerator.getResultMessage());


//        game.reset();

        context.close();
    }
}
