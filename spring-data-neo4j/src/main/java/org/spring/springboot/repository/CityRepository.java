package org.spring.springboot.repository;

import java.util.Collection;

import org.spring.springboot.domain.City;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Node4j 操作类
 * <p>
 * Created by Andy on 26/03/2018.
 */
@RepositoryRestResource(collectionResourceRel = "cities", path = "cities")
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
	City findByName(@Param("name") String name);

	@Query("MATCH (n:`City`) WHERE n.`name` =~ { `name_0` } RETURN n")
	Collection<City> findByNameLike(@Param("name_0") String name);
}
