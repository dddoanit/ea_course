/**
 * Author: DatDoan Created Date: Apr 15, 2018
 */
package edu.mum.cs544.imdb.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import edu.mum.cs544.imdb.model.TvShow;

@Repository
public class TvShowSearchRepository {
  @Autowired
  private EntityManager em;

  public List<TvShow> search(String nameShow, String genreShow, float ratingShow, String nameArtis,
      String nameCharacter, String nameDirector) {
    String sql = "select distinct tv from TvShow tv " + "left join tv.directors director"
        + " left join tv.seasons season " + "left join season.episodes episode"
        + " left join episode.artists artist " + "left join episode.characters character"
        + " where 1 = 1";

    if (!StringUtils.isEmpty(nameShow)) {
      sql += " and LOWER(tv.name) like CONCAT('%', LOWER(:nameShow), '%')";
    }
    if (!StringUtils.isEmpty(genreShow) && !"ALL".equals(genreShow)) {
      sql += " and tv.genre = :genreShow";
    }
    if (ratingShow >= 1) {
      sql += " and tv.rating = :ratingShow";
    }
    if (!StringUtils.isEmpty(nameArtis)) {
      sql += " and LOWER(artist.name) like CONCAT('%', LOWER(:nameArtis), '%')";
    }
    if (!StringUtils.isEmpty(nameCharacter)) {
      sql += " and LOWER(character.name) like CONCAT('%', LOWER(:nameCharacter), '%')";
    }
    if (!StringUtils.isEmpty(nameDirector)) {
      sql += " and LOWER(director.name) like CONCAT('%', LOWER(:nameDirector), '%')";
    }

    TypedQuery<TvShow> query = em.createQuery(sql, TvShow.class);

    if (!StringUtils.isEmpty(nameShow)) {
      query.setParameter("nameShow", nameShow);
    }
    if (!StringUtils.isEmpty(genreShow) && !"ALL".equals(genreShow)) {
      query.setParameter("genreShow", TvShow.Genre.valueOf(genreShow));
    }
    if (ratingShow >= 1) {
      query.setParameter("genreShow", genreShow);
    }
    if (!StringUtils.isEmpty(nameArtis)) {
      query.setParameter("nameArtis", nameArtis);
    }
    if (!StringUtils.isEmpty(nameCharacter)) {
      query.setParameter("nameCharacter", nameCharacter);
    }
    if (!StringUtils.isEmpty(nameDirector)) {
      query.setParameter("nameDirector", nameDirector);
    }
    return query.getResultList();
  }
}
