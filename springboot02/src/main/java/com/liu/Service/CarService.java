package com.liu.Service;

import com.liu.Repository.CarRepository;
import com.liu.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Page<Car> findAll(Car car, Pageable pageable) {
        Page<Car> cars = null;
        Specification specification = new Specification<Car>() {
            @Override
            public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (car.getStartDate() != null && car.getStartDate().toString() != "") {//出发日期
                    predicates.add(criteriaBuilder.equal(root.get("startDate"), car.getStartDate()));
                    //predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("startDate"), flight.getStartDate()));
                } else if (car.getStartLocal() != null && car.getStartLocal() != "") {
                    predicates.add(criteriaBuilder.like(root.get("startLocal"), "%" + car.getStartLocal() + "%"));
                } else if (car.getEndLocal() != null && car.getEndLocal() != "") {
                    predicates.add(criteriaBuilder.like(root.get("endLocal"), "%" + car.getEndLocal() + "%"));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return cars = carRepository.findAll(specification, pageable);
    }

}
