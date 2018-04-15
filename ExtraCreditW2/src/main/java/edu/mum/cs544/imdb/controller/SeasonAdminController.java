/**
* Author: DatDoan
* Created Date: Apr 15, 2018
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
import edu.mum.cs544.imdb.model.Season;
import edu.mum.cs544.imdb.service.SeasonService;
import edu.mum.cs544.imdb.service.TvShowService;

@Controller
@RequestMapping("/admin/season")
public class SeasonAdminController {
  
  @Autowired
  private SeasonService seasonService;
  
  @Autowired
  private TvShowService tvShowService;
  
  @RequestMapping(value="/", method=RequestMethod.GET)
  public String list(Model model) {
      model.addAttribute("seasons", seasonService.findAll());
      return "admin/season/index";
  }
  
  @RequestMapping(value = "/create", method = RequestMethod.GET)
  private String get(Model model, @ModelAttribute("season") Season season,
      @RequestParam(value = "id", required = false) Integer id,
      @RequestParam(value = "tvShowId", required = false) Integer tvShowId) {
    if (id != null && id > 0) {
      Season updatedSeason = seasonService.getSeason(id);
      model.addAttribute("season", updatedSeason);
    } else {
      season = new Season();
      season.setTvShow(tvShowService.getTvShow(tvShowId));
      model.addAttribute("season", season);
    }
    return "admin/season/create";
  }
  
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  private String create(Model model, @ModelAttribute("season") Season season,
      @RequestParam(value = "tvShowId", required = false) Integer tvShowId) {
    seasonService.save(season);
    return "redirect:/admin/tvshow/create?id="+season.getTvShow().getId();
  }
  
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
  public String delete(@PathVariable("id") int id) {
    Season season = seasonService.getSeason(id);
    seasonService.delete(season);
    return "redirect:/admin/tvshow/create?id=" + season.getTvShow().getId();
  }
  
}
