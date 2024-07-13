package com.mysite.seouldensity.place;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
    Place findByPlaceCode(String code);
    Place findByPlaceName(String name);
    Page<Place> findAll(Pageable pageable);
}
