package com.expertsoft.merchandise.facades.populators;

import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.springframework.stereotype.Component;

@Component
public class CustomerSecondEmailPopulator implements Populator<CustomerModel, CustomerData> {
    @Override
    public void populate(CustomerModel customerModel, CustomerData customerData) throws ConversionException {
        customerData.setSecondEmail(customerModel.getSecondEmail());
    }
}
