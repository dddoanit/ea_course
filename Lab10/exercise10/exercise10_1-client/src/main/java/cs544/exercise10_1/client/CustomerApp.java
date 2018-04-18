package cs544.exercise10_1.client;

import java.util.Collection;
import cs544.exercise10_1.customer.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cs544.exercise10_1.service.ICustomerService;

public class CustomerApp {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
    ICustomerService remoteService =
        context.getBean("customerServiceProxy", ICustomerService.class);

    // TODO add 3 customers & print customers list
    Customer cust1 = new Customer();
    cust1.setCustomerNumber("1");
    cust1.setName("A");
    remoteService.addCustomer(cust1);
    cust1 = new Customer();
    cust1.setCustomerNumber("2");
    cust1.setName("B");
    remoteService.addCustomer(cust1);
    cust1 = new Customer();
    cust1.setCustomerNumber("3");
    cust1.setName("C");
    remoteService.addCustomer(cust1);
    printCustomers(remoteService.getCustomers());
    
    // TODO update 1 customer & print customers list
    cust1.setCustomerNumber("1");
    cust1.setName("A UPDATED");
    remoteService.updateCustomer(cust1);
    printCustomers(remoteService.getCustomers());
    // TODO delete 1 customer & print customers list
    remoteService.deleteCustomer("1");
    printCustomers(remoteService.getCustomers());
  }

  public static void printCustomers(Collection<Customer> customers) {
    for (Customer customer : customers) {
      System.out.println(customer.getName() + " " + customer.getCustomerNumber());
    }
    System.out.println();
  }
}
