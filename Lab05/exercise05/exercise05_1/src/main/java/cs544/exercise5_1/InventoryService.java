/**
* Author: DatDoan
* Created Date: Apr 9, 2018
*/
package cs544.exercise5_1;

public class InventoryService implements IInventoryService {

  public int getNumberInStock(int productNumber) {
    return productNumber-200;
  }

}
