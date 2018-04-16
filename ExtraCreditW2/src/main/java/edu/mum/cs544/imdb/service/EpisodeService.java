/**
* Author: DatDoan
* Created Date: Apr 14, 2018
*/
package edu.mum.cs544.imdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.mum.cs544.imdb.model.Episode;
import edu.mum.cs544.imdb.repository.EpisodeRepository;

@Service
@Transactional
public class EpisodeService {
  
  @Autowired
  private EpisodeRepository episodeRepository;
  
  public Episode save(Episode episode) {
    return episodeRepository.save(episode);
  }
  
  public List<Episode> findAll() {
    return episodeRepository.findAll();
  }
  
  public Episode getEpisode(int id) {
    return episodeRepository.findOne(id);
  }
  
  public void delete(Episode episode) {
    episodeRepository.delete(episode);
  }
}
