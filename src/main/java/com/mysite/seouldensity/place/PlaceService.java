package com.mysite.seouldensity.place;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.mysite.seouldensity.DataNotFoundException;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;
import java.io.ByteArrayInputStream;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

@RequiredArgsConstructor
@Service
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final RestTemplate restTemplate;


    //해당 apiUrl 로 요청을 보내고 응답으로 받은 xml 문자열을 String으로 반환
    public String getSeoulApi(String apiUrl){
        return restTemplate.getForObject(apiUrl, String.class);
    }

    public Map<String, String> getPlacePopulation(List<Place> places){
        long startTime = System.currentTimeMillis();
        Map<String, String> placePopulations = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (Place place : places) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                String apiUrl = "http://openapi.seoul.go.kr:8088/70426e487a6133393130336945645a66/xml/citydata/1/5/" + place.getPlaceName();
                String apiData = getSeoulApi(apiUrl); //apiData = 응답으로 받은 문자열
                String populationStatus = extractPopulationStatus(apiData); // populationStatus = AREA_CONGEST_LVL 값을 추출한 값
                placePopulations.put(place.getPlaceName(), populationStatus); // ("서울대공원", "붐빔") 형태로 저장
            }, executorService);
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        long stopTime = System.currentTimeMillis();
        System.out.println("API 호출 지연시간 : " + (stopTime - startTime) + "ms");
        executorService.shutdown();
        return placePopulations;
    }

    private String extractPopulationStatus(String apiData) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            ByteArrayInputStream input = new ByteArrayInputStream(apiData.getBytes("UTF-8"));
            Document doc = builder.parse(input);

            NodeList nodeList = doc.getElementsByTagName("AREA_CONGEST_LVL");
            if (nodeList.getLength() > 0) {
                return nodeList.item(0).getTextContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "정보 없음";
    }
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
