/**
* Author: DatDoan
* Created Date: Apr 3, 2018
*/
package edu.mum.hw2.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "`ORDER`")
public class Order {
  @Id
  @GeneratedValue
  private long orderId;
  
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;
  
  @ElementCollection
  @CollectionTable(name = "ORDER_LINE")
  private List<OrderLine> orderLines = new ArrayList<>();

  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public List<OrderLine> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine> orderLines) {
    this.orderLines = orderLines;
  }
  
}
