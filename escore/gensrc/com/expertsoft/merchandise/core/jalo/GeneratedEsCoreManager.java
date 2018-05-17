/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 16.05.2018 18:47:05                         ---
 * ----------------------------------------------------------------
 */
package com.expertsoft.merchandise.core.jalo;

import com.expertsoft.merchandise.core.constants.EsCoreConstants;
import com.expertsoft.merchandise.core.jalo.ApparelProduct;
import com.expertsoft.merchandise.core.jalo.ApparelSizeVariantProduct;
import com.expertsoft.merchandise.core.jalo.ApparelStyleVariantProduct;
import com.expertsoft.merchandise.core.jalo.ElectronicsColorVariantProduct;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.User;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type <code>EsCoreManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEsCoreManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("likeCount", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.product.Product", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("secondEmail", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Customer", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	public ApparelProduct createApparelProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EsCoreConstants.TC.APPARELPRODUCT );
			return (ApparelProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelProduct createApparelProduct(final Map attributeValues)
	{
		return createApparelProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EsCoreConstants.TC.APPARELSIZEVARIANTPRODUCT );
			return (ApparelSizeVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelSizeVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final Map attributeValues)
	{
		return createApparelSizeVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EsCoreConstants.TC.APPARELSTYLEVARIANTPRODUCT );
			return (ApparelStyleVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelStyleVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final Map attributeValues)
	{
		return createApparelStyleVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( EsCoreConstants.TC.ELECTRONICSCOLORVARIANTPRODUCT );
			return (ElectronicsColorVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ElectronicsColorVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final Map attributeValues)
	{
		return createElectronicsColorVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	@Override
	public String getName()
	{
		return EsCoreConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.likeCount</code> attribute.
	 * @return the likeCount - Count of likes on product.
	 */
	public Integer getLikeCount(final SessionContext ctx, final Product item)
	{
		return (Integer)item.getProperty( ctx, EsCoreConstants.Attributes.Product.LIKECOUNT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.likeCount</code> attribute.
	 * @return the likeCount - Count of likes on product.
	 */
	public Integer getLikeCount(final Product item)
	{
		return getLikeCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.likeCount</code> attribute. 
	 * @return the likeCount - Count of likes on product.
	 */
	public int getLikeCountAsPrimitive(final SessionContext ctx, final Product item)
	{
		Integer value = getLikeCount( ctx,item );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.likeCount</code> attribute. 
	 * @return the likeCount - Count of likes on product.
	 */
	public int getLikeCountAsPrimitive(final Product item)
	{
		return getLikeCountAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.likeCount</code> attribute. 
	 * @param value the likeCount - Count of likes on product.
	 */
	public void setLikeCount(final SessionContext ctx, final Product item, final Integer value)
	{
		item.setProperty(ctx, EsCoreConstants.Attributes.Product.LIKECOUNT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.likeCount</code> attribute. 
	 * @param value the likeCount - Count of likes on product.
	 */
	public void setLikeCount(final Product item, final Integer value)
	{
		setLikeCount( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.likeCount</code> attribute. 
	 * @param value the likeCount - Count of likes on product.
	 */
	public void setLikeCount(final SessionContext ctx, final Product item, final int value)
	{
		setLikeCount( ctx, item, Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.likeCount</code> attribute. 
	 * @param value the likeCount - Count of likes on product.
	 */
	public void setLikeCount(final Product item, final int value)
	{
		setLikeCount( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.secondEmail</code> attribute.
	 * @return the secondEmail
	 */
	public String getSecondEmail(final SessionContext ctx, final Customer item)
	{
		return (String)item.getProperty( ctx, EsCoreConstants.Attributes.Customer.SECONDEMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.secondEmail</code> attribute.
	 * @return the secondEmail
	 */
	public String getSecondEmail(final Customer item)
	{
		return getSecondEmail( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.secondEmail</code> attribute. 
	 * @param value the secondEmail
	 */
	public void setSecondEmail(final SessionContext ctx, final Customer item, final String value)
	{
		item.setProperty(ctx, EsCoreConstants.Attributes.Customer.SECONDEMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.secondEmail</code> attribute. 
	 * @param value the secondEmail
	 */
	public void setSecondEmail(final Customer item, final String value)
	{
		setSecondEmail( getSession().getSessionContext(), item, value );
	}
	
}
