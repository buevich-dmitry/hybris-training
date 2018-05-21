package com.expertsoft.merchandise.core.search.solrfacetsearch.provider.impl;

import de.hybris.platform.commerceservices.search.solrfacetsearch.provider.impl.ProductReviewAverageRatingValueProvider;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractPropertyFieldValueProvider;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RangedAvgCustomerRatingProvider extends AbstractPropertyFieldValueProvider implements FieldValueProvider {

    private FieldNameProvider fieldNameProvider;

    @Override
    public Collection<FieldValue> getFieldValues(IndexConfig indexConfig, IndexedProperty indexedProperty, Object productModel) throws FieldValueProviderException {
        List<String> rangeNameList = null;
        Double value = ((ProductModel) productModel).getAvgRating();
        try
        {
            rangeNameList = getRangeNameList(indexedProperty, value);
        }
        catch (final FieldValueProviderException e)
        {
            LOG.error("Could not get Range value", e);
        }
        String rangeName = null;
        if (CollectionUtils.isNotEmpty(rangeNameList))
        {
            rangeName = rangeNameList.get(0);
        }
        final Collection<String> fieldNames = getFieldNameProvider().getFieldNames(indexedProperty, null);
        final Object valueToPass = (rangeName == null ? value : rangeName);
        List<FieldValue> fieldValues = new ArrayList<>();
        for (final String fieldName : fieldNames) {
            fieldValues.add(new FieldValue(fieldName, valueToPass));
        }
        return fieldValues;
    }

    public FieldNameProvider getFieldNameProvider() {
        return fieldNameProvider;
    }

    @Required
    public void setFieldNameProvider(FieldNameProvider fieldNameProvider) {
        this.fieldNameProvider = fieldNameProvider;
    }
}
