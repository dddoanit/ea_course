/**
* Author: DatDoan
* Created Date: Apr 14, 2018
*/
package edu.mum.cs544.imdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.mum.cs544.imdb.model.TvShow;
import edu.mum.cs544.imdb.repository.TvShowRepository;

@Service
@Transactional
public class TvShowService {
  
  @Autowired
  private TvShowRepository tvShowRepository;
  
  public TvShow save(TvShow tvShow) {
    return tvShowRepository.save(tvShow);
  }
  
  public List<TvShow> findAll() {
    return tvShowRepository.findAll();
  }
  
}
