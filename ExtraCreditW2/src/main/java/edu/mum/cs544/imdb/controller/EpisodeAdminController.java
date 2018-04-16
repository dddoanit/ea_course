/**
 * Author: DatDoan Created Date: Apr 15, 2018
 */
package edu.mum.cs544.imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.mum.cs544.imdb.model.Episode;
import edu.mum.cs544.imdb.service.EpisodeService;
import edu.mum.cs544.imdb.service.SeasonService;

@Controller
@RequestMapping("/admin/episode")
public class EpisodeAdminController {

  @Autowired
  private SeasonService seasonService;

  @Autowired
  private EpisodeService episodeService;

  @RequestMapping(value = "/create", method = RequestMethod.GET)
  private String get(Model model, @ModelAttribute("episode") Episode episode,
      @RequestParam(value = "id", required = false) Integer id,
      @RequestParam(value = "seasonId", required = false) Integer seasonId) {
    if (id != null && id > 0) {
      Episode updatedEpisode = episodeService.getEpisode(id);
      model.addAttribute("episode", updatedEpisode);
      model.addAttribute("characters", updatedEpisode.getCharacters());
    } else {
      episode = new Episode();
      episode.setSeason(seasonService.getSeason(seasonId));
      model.addAttribute("episode", episode);
    }
    return "admin/episode/create";
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  private String create(Model model, @ModelAttribute("episode") Episode episode,
      @RequestParam(value = "seasonId", required = false) Integer seasonId) {
    episodeService.save(episode);
    return "redirect:/admin/season/create?id=" + episode.getSeason().getId();
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
  public String delete(@PathVariable("id") int id) {
    Episode episode = episodeService.getEpisode(id);
    episodeService.delete(episode);
    return "redirect:/admin/season/create?id=" + episode.getSeason().getId();
  }

}
