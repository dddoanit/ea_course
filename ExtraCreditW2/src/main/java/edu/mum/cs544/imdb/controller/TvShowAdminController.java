/**
* Author: DatDoan
* Created Date: Apr 15, 2018
*/
package edu.mum.cs544.imdb.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.mum.cs544.imdb.model.TvShow;
import edu.mum.cs544.imdb.service.TvShowService;

@Controller
@RequestMapping("/admin/tvshow")
public class TvShowAdminController {
  
  @Autowired
  private TvShowService tvShowService;
  
  @RequestMapping(value="/", method=RequestMethod.GET)
  public String list(Model model) {
      model.addAttribute("tvShows", tvShowService.findAll());
      return "admin/tvshow/index";
  }
  
  @RequestMapping(value = "/create", method = RequestMethod.GET)
  private String get(Model model, @ModelAttribute("tvShow") TvShow tvShow,
      @RequestParam(value = "id", required = false) Integer id) {
    if (id != null && id > 0) {
      TvShow updatedTvShow = tvShowService.getTvShow(id);
      model.addAttribute("tvShow", updatedTvShow);
      model.addAttribute("seasons", updatedTvShow.getSeasons());
    }
    return "admin/tvshow/create";
  }
  
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  private String create(Model model, @ModelAttribute("tvShow") TvShow tvShow) {
    tvShowService.save(tvShow);
    return "redirect:/admin/tvshow/";
  }
  
  @RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
  public String delete(@PathVariable("id") int id) {
      TvShow tvShow = tvShowService.getTvShow(id);
      tvShowService.delete(tvShow);
      return "redirect:/admin/tvshow/";
  }
  
  @ModelAttribute("genres")
  public List<TvShow.Genre> productTypes() {
      return Arrays.asList(TvShow.Genre.values());
  }
}
