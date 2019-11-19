package com.liu.Service;

import com.liu.Repository.FlightRepository;
import com.liu.pojo.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findByCondition(Flight flight) {
        List<Flight> flights = null;
        Specification specification = new Specification<Flight>() {

            @Override
            public Predicate toPredicate(Root<Flight> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (flight.getStartDate() != null) {

                    predicates.add(criteriaBuilder.equal(root.get("startDate"), flight.getStartDate()));
                    //predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("startDate"), flight.getStartDate()));
                }
                if (flight.getStartingCity() != null && flight.getStartingCity() != "") {
                    predicates.add(criteriaBuilder.like(root.get("startingCity"), "%" + flight.getStartingCity() + "%"));
                }
                if (flight.getTerminusCity() != null && flight.getTerminusCity() != "") {
                    predicates.add(criteriaBuilder.like(root.get("terminusCity"), "%" + flight.getTerminusCity() + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        flights = flightRepository.findAll(specification);
        return flights;
    }

}
