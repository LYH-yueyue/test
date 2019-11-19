package com.liu.Service;

import com.liu.Repository.RoomRepository;
import com.liu.pojo.Flight;
import com.liu.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room findOneByhotelId(Integer id) {
        Room room = null;
        Specification specification = new Specification<Room>() {
            @Override
            public Predicate toPredicate(Root<Room> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (id != null) {
                    predicates.add(criteriaBuilder.equal(root.get("id"), id));
                    //predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("startDate"), flight.getStartDate()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        List all = roomRepository.findAll(specification);
        room = (Room) all.get(0);
        return room;
    }

}
