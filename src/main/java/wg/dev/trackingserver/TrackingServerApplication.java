package wg.dev.trackingserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import wg.dev.trackingserver.domain.Car;
import wg.dev.trackingserver.domain.CarRepository;

@SpringBootApplication
public class TrackingServerApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(TrackingServerApplication.class);
	@Autowired

	private CarRepository repository;

	public static void main(String[] args) { SpringApplication.run(TrackingServerApplication.class, args); }

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000));
		repository.save(new Car("Ford", "F150", "Black", "ADF-2222", 2022, 60000));
		repository.save(new Car("Honda", "Pilot", "Red", "ADF-3333", 2023, 70000));
		repository.save(new Car("Honda", "Civic", "Black", "ADF-4444", 2022, 90000));
		//fetch all cars from MySQL and log.
		for (Car car : repository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}

	}

}
