package com.expertsoft.merchandise.core.handlers;

import com.expertsoft.merchandise.core.model.RatingModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

import java.util.Optional;
import java.util.OptionalDouble;

public class ProductAverageRatingAttributeHandler implements DynamicAttributeHandler<Double, ProductModel> {

    @Override
    public Double get(ProductModel model) {
        OptionalDouble averageRating = model.getRatings().stream().mapToInt(RatingModel::getValue).average();
        return averageRating.isPresent() ? averageRating.getAsDouble() : null;
    }

    @Override
    public void set(ProductModel model, Double aDouble) {
        throw new UnsupportedOperationException();
    }
}
