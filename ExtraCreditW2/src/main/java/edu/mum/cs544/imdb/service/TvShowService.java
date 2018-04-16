/**
 * Author: DatDoan Created Date: Apr 14, 2018
 */
package edu.mum.cs544.imdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.mum.cs544.imdb.model.TvShow;
import edu.mum.cs544.imdb.repository.TvShowRepository;
import edu.mum.cs544.imdb.repository.TvShowSearchRepository;

@Service
@Transactional
public class TvShowService {

  @Autowired
  private TvShowRepository tvShowRepository;
  
  @Autowired
  private TvShowSearchRepository tvShowSearchRepository; 

  public TvShow save(TvShow tvShow) {
    return tvShowRepository.save(tvShow);
  }

  public List<TvShow> findAll() {
    return tvShowRepository.findAll();
  }

  public TvShow getTvShow(int id) {
    return tvShowRepository.findOne(id);
  }

  public void delete(TvShow tvShow) {
    tvShowRepository.delete(tvShow);
  }

  public List<TvShow> search(String nameShow, String genreShow, float ratingShow, String nameArtis,
      String nameCharacter, String nameDirector) {
    return tvShowSearchRepository.search(nameShow, genreShow, ratingShow, nameArtis,
        nameCharacter, nameDirector);
  }

}
