/**
* Author: DatDoan
* Created Date: Apr 14, 2018
*/
package edu.mum.cs544.imdb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.mum.cs544.imdb.model.Character;
import edu.mum.cs544.imdb.repository.CharacterRepository;

@Service
@Transactional
public class CharacterService {
  
  @Autowired
  private CharacterRepository characterRepository;
  
  public Character save(Character character) {
    return characterRepository.save(character);
  }
  
  public List<Character> findAll() {
    return characterRepository.findAll();
  }
  
  public Character getCharacter(int id) {
    return characterRepository.findOne(id);
  }
  
  public void delete(Character character) {
    characterRepository.delete(character);
  }
}
