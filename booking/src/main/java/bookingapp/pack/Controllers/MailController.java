package bookingapp.pack.Controllers;


import bookingapp.pack.Services.MailService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {




    @RequestMapping("/recovery")
    public String sendMail()
    {

        String configFile="email-bean.xml";

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(configFile);

        MailService ms = (MailService) context.getBean("gtEmail");
        try {
            ms.sendSimpleMessage("vlad.dedita@gmail.com","Recovery","Salut");
            return "OK";
        }
        catch(Exception e)
        {
            return e.toString();
        }

    }

}
