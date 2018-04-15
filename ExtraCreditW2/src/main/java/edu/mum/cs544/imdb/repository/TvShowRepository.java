/**
* Author: DatDoan
* Created Date: Apr 14, 2018
*/
package edu.mum.cs544.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.mum.cs544.imdb.model.TvShow;

public interface TvShowRepository extends JpaRepository<TvShow, Integer>{

}
