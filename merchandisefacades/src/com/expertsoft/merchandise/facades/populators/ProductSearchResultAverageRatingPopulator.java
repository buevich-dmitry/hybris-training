package com.expertsoft.merchandise.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

public class ProductSearchResultAverageRatingPopulator implements Populator<SearchResultValueData, ProductData> {

    @Override
    public void populate(SearchResultValueData searchResultValueData, ProductData productData) throws ConversionException {
        List<String> list = (List<String>) searchResultValueData.getValues().get("avgRating");
        if (CollectionUtils.isNotEmpty(list))
        productData.setAvgRating(Double.valueOf(list.get(0)));
    }
}
