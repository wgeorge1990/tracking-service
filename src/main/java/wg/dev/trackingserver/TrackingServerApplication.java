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
import wg.dev.trackingserver.domain.Owner;
import wg.dev.trackingserver.domain.OwnerRepository;

import java.util.Arrays;

@SpringBootApplication
public class TrackingServerApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(TrackingServerApplication.class);
	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	public static void main(String[] args) { SpringApplication.run(TrackingServerApplication.class, args); }

	@Override
	public void run(String... args) throws Exception {

		Owner ownerOne = new Owner("Bob", "Ross");
		Owner ownerTwo = new Owner("Lucinda", "Williams");
		Owner ownerThree = new Owner("Bruce", "Springsteen");
		ownerRepository.saveAll(Arrays.asList(ownerOne, ownerTwo, ownerThree));

		carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, ownerOne));
		carRepository.save(new Car("Ford", "F150", "Black", "ADF-2222", 2022, 60000, ownerTwo));
		carRepository.save(new Car("Honda", "Pilot", "Red", "ADF-3333", 2023, 70000, ownerThree));
		carRepository.save(new Car("Honda", "Civic", "Black", "ADF-4444", 2022, 90000, ownerOne));

		// fetch all cars from MySQL to logger.INFO
		for (Car car : carRepository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}

		// fetch and log by other properties to logger.INFO
		for (Car car : carRepository.findByColorOrderByPriceAsc("Red")){
			logger.info(car.getBrand() + " " + car.getColor() + " " + car.getPrice());
		}

		// log owners to logger.INFO
		for (Owner owner : ownerRepository.findAll()) {
			logger.info(owner.getFirstname() + " " + owner.getLastname());
		}

	}

}
