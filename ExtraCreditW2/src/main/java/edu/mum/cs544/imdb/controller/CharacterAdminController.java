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
import edu.mum.cs544.imdb.model.Character;
import edu.mum.cs544.imdb.service.CharacterService;
import edu.mum.cs544.imdb.service.EpisodeService;

@Controller
@RequestMapping("/admin/character")
public class CharacterAdminController {

  @Autowired
  private EpisodeService episodeService;

  @Autowired
  private CharacterService characterService;

  @RequestMapping(value = "/create", method = RequestMethod.GET)
  private String get(Model model, @ModelAttribute("character") Character character,
      @RequestParam(value = "id", required = false) Integer id,
      @RequestParam(value = "episodeId", required = false) Integer episodeId) {
    if (id != null && id > 0) {
      Character updatedCharacter = characterService.getCharacter(id);
      model.addAttribute("character", updatedCharacter);
    } else {
      character = new Character();
      character.setEpisode(episodeService.getEpisode(episodeId));
      model.addAttribute("character", character);
    }
    return "admin/character/create";
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  private String create(Model model, @ModelAttribute("character") Character character,
      @RequestParam(value = "seasonId", required = false) Integer seasonId) {
    characterService.save(character);
    return "redirect:/admin/episode/create?id=" + character.getEpisode().getId();
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
  public String delete(@PathVariable("id") int id) {
    Character character = characterService.getCharacter(id);
    characterService.delete(character);
    return "redirect:/admin/episode/create?id=" + character.getEpisode().getId();
  }

}
