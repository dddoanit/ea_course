/**
 * Author: DatDoan Created Date: Apr 14, 2018
 */
package edu.mum.cs544.imdb.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import edu.mum.cs544.imdb.model.TvShow;

public interface TvShowRepository extends JpaRepository<TvShow, Integer> {
  @Query("from TvShow tv where LOWER(tv.name) like CONCAT('%', LOWER(:nameShow), '%') or tv.genre = :genreShow")
  List<TvShow> search(@Param("nameShow") String nameShow, @Param("genreShow") TvShow.Genre genreShow);
}
