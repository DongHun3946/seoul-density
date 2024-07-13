package com.mysite.seouldensity.place;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mysite.seouldensity.DataNotFoundException;
import java.util.*;

@RequiredArgsConstructor
@Service
public class PlaceService {

    private final PlaceRepository placeRepository;
    public List<Place> getList(){
        return this.placeRepository.findAll();
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
