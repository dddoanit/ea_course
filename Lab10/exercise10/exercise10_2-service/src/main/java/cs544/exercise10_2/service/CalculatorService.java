/**
* Author: DatDoan
* Created Date: Apr 17, 2018
*/
package cs544.exercise10_2.service;

public class CalculatorService implements ICalculator{
  private int result = 0;
  
  @Override
  public void add(int value) {
    result += value;
  }
  
  @Override
  public int getResult() {
    return result;
  }
}
