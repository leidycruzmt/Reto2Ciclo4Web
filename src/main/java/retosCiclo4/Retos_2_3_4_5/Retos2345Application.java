package retosCiclo4.Retos_2_3_4_5;

import retosCiclo4.Retos_2_3_4_5.interfaces.CleaningProductInterface;
import retosCiclo4.Retos_2_3_4_5.interfaces.UserInterface;
import retosCiclo4.Retos_2_3_4_5.interfaces.OrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


@Component
@SpringBootApplication
public class Retos2345Application implements CommandLineRunner {
    
    @Autowired
    private CleaningProductInterface cleaningProductInterface;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private OrderInterface orderInterface;

	public static void main(String[] args) {
		SpringApplication.run(Retos2345Application.class, args);
	}
        
        @Override
        public void run(String... args) throws Exception {
        
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        cleaningProductInterface.deleteAll();
        userInterface.deleteAll();
        orderInterface.deleteAll(); 
    }

}
