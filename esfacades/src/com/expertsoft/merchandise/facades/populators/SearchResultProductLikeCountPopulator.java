package com.expertsoft.merchandise.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.springframework.stereotype.Component;

@Component
public class SearchResultProductLikeCountPopulator implements Populator<SearchResultValueData, ProductData> {
    @Override
    public void populate(SearchResultValueData searchResultValueData, ProductData productData) throws ConversionException {
        productData.setLikeCount((Integer) searchResultValueData.getValues().get("likeCount"));
    }
}
