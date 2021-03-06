package edu.drexel.TrainDemo;

import edu.drexel.TrainDemo.entities.itinerary.Calendar;
import edu.drexel.TrainDemo.entities.itinerary.Route;
import edu.drexel.TrainDemo.entities.itinerary.Stop;
import edu.drexel.TrainDemo.entities.itinerary.StopTime;
import edu.drexel.TrainDemo.entities.itinerary.StopTimeIdClass;
import edu.drexel.TrainDemo.repositories.itinerary.CalendarRepository;
import edu.drexel.TrainDemo.repositories.itinerary.RouteRepository;
import edu.drexel.TrainDemo.repositories.itinerary.StopRepository;
import edu.drexel.TrainDemo.repositories.itinerary.StopTimeRepository;

import org.slf4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// This is just a demonstration of Spring Repositories and dependency
// inversion (the 'D' in SOLID.) Feel free to remove this.
@Component
public class RouteLoggingRunner implements ApplicationRunner {

    private final Logger logger;
    private final RouteRepository repo;
    private final StopRepository stopRepo;
    private final CalendarRepository calenderRepo;
    private final StopTimeRepository stopTimeRepo;
    
    

    public RouteLoggingRunner(Logger logger, RouteRepository repo, StopRepository stopRepository,
    		CalendarRepository calenderRepo, StopTimeRepository stopTimeRepo) {
        this.stopTimeRepo = stopTimeRepo;
		this.calenderRepo = calenderRepo;
		this.stopRepo = stopRepository;
		this.logger = logger;
        this.repo = repo;
    }

    @Override
    public void run(ApplicationArguments args) {
        logger.info("Attempting to find routes with repo.findAll()...");
        for (Route route : repo.findAll()) {
            logger.info(route.toString());
        }

        long id = 96L;
        logger.info("Attempting to find route with id " + id + "...");
        Optional<Route> entity = repo.findById(id);
        if (entity.isPresent()) {
            logger.info("Found route with id " + id);
            logger.info(entity.get().toString());
        } else {
            logger.info("Could not find route with id " + id);
        }

        long agencyId = 51;
        logger.info("Attempting to get all routes by the agency id " + agencyId + "...");
        List<Route> routes = repo.findByAgencyId(agencyId);
        for (Route route : routes) {
            logger.info(route.toString());
        }
        
        String stopId = "abe";
        logger.info("Attempting to get all stops by the stop id " + stopId + "...");
        List<Stop> Stops = stopRepo.findByIdContainingIgnoreCase(stopId);
        for (Stop stop : Stops) {
            logger.info(stop.toString());
        }
        
        Long calenderId = 1298323L;
        logger.info("Attempting to get all stops by the calender id " + calenderId + "...");
        System.out.println(calenderRepo.findById(calenderId));
        
        System.out.println(stopTimeRepo.findById(new StopTimeIdClass("HUD", 2841296329L)));
        
        System.out.println(stopTimeRepo.findByStopId("NFL"));
       
        
    }
}
