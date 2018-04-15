/**
* Author: DatDoan
* Created Date: Apr 14, 2018
*/
package edu.mum.cs544.imdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.mum.cs544.imdb.model.Season;
import edu.mum.cs544.imdb.repository.SeasonRepository;

@Service
@Transactional
public class SeasonService {
  
  @Autowired
  private SeasonRepository seasonRepository;
  
  public Season save(Season season) {
    return seasonRepository.save(season);
  }
  
  public List<Season> findAll() {
    return seasonRepository.findAll();
  }
  
  public Season getSeason(int id) {
    return seasonRepository.findOne(id);
  }
  
  public void delete(Season season) {
    seasonRepository.delete(season);
  }
}
