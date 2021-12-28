package com.webservice.webservice.soap.service;


import com.webservice.webservice.soap.Bean.CustomerData;
import dummybank.customerdetails.CustomerDetails;
import dummybank.customerdetails.GetCustomerDetailsRequest;
import dummybank.customerdetails.GetCustomerDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class customerDetailsEndPoint {

    @Autowired
    CustomerDetailsService customerDetails;


    @PayloadRoot(namespace = "http://DummyBank/CustomerDetails", localPart = "GetCustomerDetailsRequest")
    @ResponsePayload
    public GetCustomerDetailsResponse processCourseDetailsRequest(@RequestPayload GetCustomerDetailsRequest request) {

        CustomerData data = customerDetails.CustomerInformation(request.getCustomerId());
       System.err.println(request.getCustomerId());


        return CustomerDeatilFromDb(data);
    }

    public GetCustomerDetailsResponse CustomerDeatilFromDb(CustomerData data)
    {
        GetCustomerDetailsResponse response = new GetCustomerDetailsResponse();
        response.setCustomerDetails(mapCustomerData(data));
        return response;
    }

    public CustomerDetails mapCustomerData(CustomerData data)
    {
        CustomerDetails data1=new CustomerDetails();
        data1.setId(data.getId());
        data1.setAddress(data.getAddress());
        data1.setName(data.getName());
        data1.setMobile(data.getMobile());
        data1.setTotalBalance(data.getTotal_Balance());
        System.err.println(data1);
        return data1;
    }
}
