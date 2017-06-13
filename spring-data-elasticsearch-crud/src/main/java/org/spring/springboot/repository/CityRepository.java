package org.spring.springboot.repository;

import org.spring.springboot.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * ES 操作类
 * <p>
 * Created by bysocket on 17/05/2017.
 */
public interface CityRepository extends ElasticsearchRepository<City, Long> {
    /**
     * @param description
     * @param score
     * @return
     */
    List<City> findByDescriptionAndScore(String description, Integer score);

    List<City> findByDescriptionOrScore(String description, Integer score);

    Page<City> findByDescription(String description, Pageable page);

//    @Query("{\"bool\" : {\"must\" : {\"term\" : {\"description\" : \"?0\"}}}}")
//    Page<City> findByDescription(String description, Pageable pageable);

    Page<City> findByDescriptionNot(String description, Pageable page);

    Page<City> findByDescriptionLike(String description, Pageable page);

    Page<City> findByScoreBetween(Integer score, Pageable page);

}
