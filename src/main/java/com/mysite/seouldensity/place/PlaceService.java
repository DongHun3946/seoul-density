package com.mysite.seouldensity.place;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.mysite.seouldensity.DataNotFoundException;
import java.util.*;

@RequiredArgsConstructor
@Service
public class PlaceService {

    private final PlaceRepository placeRepository;
    public Page<Place> getList(int page) {
        Pageable pageable = PageRequest.of(page,9);
        return this.placeRepository.findAll(pageable);
    }
    public Place getPlace(Integer id){
        Optional<Place> place  = this.placeRepository.findById(id);
        if(place.isPresent()){
            return place.get();
        }
        else{
            throw new DataNotFoundException("place not found");
        }
    }
}
