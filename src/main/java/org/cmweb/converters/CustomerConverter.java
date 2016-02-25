package org.cmweb.converters;

import org.cmweb.data.CustomerData;
import org.cmweb.entity.CustomerEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component(value = "customerConverter")
public class CustomerConverter implements Converter<CustomerEntity,CustomerData> {


    public CustomerData convert(CustomerEntity source) {
        CustomerData target = new CustomerData();
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setEmail(source.getCustomerSecurity().getEmail());

        return target;
    }
}
