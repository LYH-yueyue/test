package com.liu.Service;

import com.liu.Repository.HotelRepository;
import com.liu.pojo.Flight;
import com.liu.pojo.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Page<Hotel> findByCondition(Hotel hotel, Pageable pageable) {
        Page<Hotel> hotels = null;
        Specification specification = new Specification<Hotel>() {

            @Override
            public Predicate toPredicate(Root<Hotel> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (hotel.getHotelAddress() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("hotelAddress"), hotel.getHotelAddress()));
                }
                if (hotel.getHotelName() != null && hotel.getHotelName() != "") {
                    predicates.add(criteriaBuilder.like(root.get("hotelName"), "%" + hotel.getHotelName() + "%"));
                }
                if (hotel.getHotelRank() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("hotelRank"), hotel.getHotelRank()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        hotels = hotelRepository.findAll(specification, pageable);
        return hotels;
    }
}
