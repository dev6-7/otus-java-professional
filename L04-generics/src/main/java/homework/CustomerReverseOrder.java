package homework;


import java.util.*;

public class CustomerReverseOrder {

    Stack<Customer> customers = new Stack<>();
    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"

    public void add(Customer customer) {
        customers.add(customer);
    }

    public Customer take() {
        return customers.pop();
    }
}
