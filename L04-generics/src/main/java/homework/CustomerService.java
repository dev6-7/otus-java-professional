package homework;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {
    TreeMap<Customer, String> sortCustomerMap = new TreeMap<>(Comparator.comparingLong(o -> o.getScores()));

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Map.Entry<Customer, String> element = sortCustomerMap.firstEntry();
        return new java.util.AbstractMap.SimpleEntry<>(element.getKey().clone(), element.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> element = sortCustomerMap.ceilingEntry(customer);
        //у нас условие что должно быть строго больше, поэтому если такого же нашли то прибавляем единицу и ищем еще раз.
        if (element != null && element.getKey().getScores() == customer.getScores()) {
            Customer customerCopy = customer.clone();
            customerCopy.setScores(customer.getScores() + 1l);

            element = sortCustomerMap.ceilingEntry(customerCopy);
        }
        return element == null ? null : new java.util.AbstractMap.SimpleEntry<>(element.getKey().clone(), element.getValue());
    }

    public void add(Customer customer, String data) {
        sortCustomerMap.put(customer, data);
    }
}
