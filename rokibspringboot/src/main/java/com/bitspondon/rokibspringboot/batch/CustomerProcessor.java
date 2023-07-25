package com.bitspondon.rokibspringboot.batch;

import com.bitspondon.rokibspringboot.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        return customer;
//        if(customer.getCountry().equals("United States")) {
//        }else{
//            return null;
//        }
    }
}
