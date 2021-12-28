package com.webservice.webservice.soap.service;


import com.webservice.webservice.soap.Bean.CustomerData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDetailsService {

    private static List<CustomerData> customerInformation=new ArrayList<>();

    static
    {
        CustomerData data1=new CustomerData(1,"suman",12345678,"bangalore",6000);
        customerInformation.add(data1);

        CustomerData data2=new CustomerData(2,"kumar",988888,"india",9890908);
        customerInformation.add(data2);

        CustomerData data3=new CustomerData(3,"amit",434234,"patna",20000);
        customerInformation.add(data3);


        CustomerData data4=new CustomerData(4,"raj",90876,"delhi",890);
        customerInformation.add(data4);

    }

    public CustomerData CustomerInformation(int customerId)
    {
        for(CustomerData data:customerInformation)
        {
            System.err.println(data.getId());
            if(data.getId()==customerId)
            {
                return data;
            }

        }
        return null;

        //return new CustomerData();
    }
}
