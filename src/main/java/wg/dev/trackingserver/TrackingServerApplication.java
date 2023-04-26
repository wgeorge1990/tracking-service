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

	private CarRepository carRepository;

	public static void main(String[] args) { SpringApplication.run(TrackingServerApplication.class, args); }

	@Override
	public void run(String... args) throws Exception {
		// Uncomment and run to create some testing data for the Car Entity.
		// TODO: update after object data modeling relationships are updated.
//		carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000));
//		carRepository.save(new Car("Ford", "F150", "Black", "ADF-2222", 2022, 60000));
//		carRepository.save(new Car("Honda", "Pilot", "Red", "ADF-3333", 2023, 70000));
//		carRepository.save(new Car("Honda", "Civic", "Black", "ADF-4444", 2022, 90000));

		//fetch all cars from MySQL and log.
		for (Car car : carRepository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}

		//fetch and log by other properties
		for (Car car : carRepository.findByColorOrderByPriceAsc("Red")){
			logger.info(car.toString());
			logger.info(car.getBrand() + " " + car.getColor() + " " + car.getPrice());
		}


	}

}
