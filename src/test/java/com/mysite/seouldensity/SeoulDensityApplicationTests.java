package com.mysite.seouldensity;

import java.util.Optional;
import com.mysite.seouldensity.place.Place;
import com.mysite.seouldensity.place.PlaceRepository;
import com.mysite.seouldensity.answer.Answer;
import com.mysite.seouldensity.answer.AnswerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SeoulDensityApplicationTests {
	@Autowired
	private PlaceRepository placeRepository;

	@Autowired
	private AnswerRepository answerRepository;
	@Test
	void contextLoads() {
		Optional<Answer> oa = this.answerRepository.findById(8);
		assertTrue(oa.isPresent());
		Answer a = oa.get();
		this.answerRepository.delete(a);
	}
}

/*
--------데이터 저장---------
Place p = new Place();
p.setPlaceCode("POI009");
p.setPlaceName("광화문·덕수궁");
p.setCategory("고궁·문화유산");
p.setImagePath("/images/광나루한강공원.jpg");
this.placeRepository.save(p);
---------------------------

--------데이터 조회---------
Optional<Place> oa = this.placeRepository.findById(1);
assertTrue(oa.isPresent());
Place a = oa.get();
---------------------------

--------데이터 삭제---------
Optional<Place> oa = this.placeRepository.findById(2);
assertTrue(oa.isPresent());
Place q = oa.get();
this.placeRepository.delete(q);
---------------------------

--------데이터 수정---------
Optional<Place> oq = this.placeRepository.findById(3);
assertTrue(oq.isPresent());
Place p = oq.get();
p.setImagePath("수정된 사항");
this.placeRepository.save(p);

 */