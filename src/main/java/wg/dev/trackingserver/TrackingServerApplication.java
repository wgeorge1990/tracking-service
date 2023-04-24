package wg.dev.trackingserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrackingServerApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(TrackingServerApplication.class);

	public static void main(String[] args) {
		// after adding comment it should restart thanks to dev tools
		SpringApplication.run(TrackingServerApplication.class, args);
		logger.info("Application started");
	}

}
