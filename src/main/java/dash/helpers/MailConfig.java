package dash.helpers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration 
public class MailConfig {

  
   

    @Value("DASH-Core")
    private String from;

    @Value("Default Message Head")
    private String subject;
    
    

    @Bean
    public SimpleMailMessage simpleMailMessage() {
       SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
       simpleMailMessage.setFrom(from);
       simpleMailMessage.setSubject(subject);
       return simpleMailMessage;
    }
}
