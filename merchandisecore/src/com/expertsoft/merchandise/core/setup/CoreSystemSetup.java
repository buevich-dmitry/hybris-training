/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.expertsoft.merchandise.core.setup;

import de.hybris.platform.catalog.jalo.CatalogManager;
import de.hybris.platform.catalog.jalo.CatalogVersion;
import de.hybris.platform.catalog.jalo.SyncAttributeDescriptorConfig;
import de.hybris.platform.catalog.jalo.SyncItemJob;
import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetup.Process;
import de.hybris.platform.core.initialization.SystemSetup.Type;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import de.hybris.platform.core.initialization.SystemSetupParameterMethod;
//import com.expertsoft.merchandise.core.constants.MerchandiseCoreConstants;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.AttributeDescriptor;
import de.hybris.platform.jalo.type.TypeManager;

import java.util.ArrayList;
import java.util.List;


/**
 * This class provides hooks into the system's initialization and update processes.
 */
@SystemSetup(extension = "merchandisecore")
public class CoreSystemSetup extends AbstractSystemSetup
{
	public static final String IMPORT_ACCESS_RIGHTS = "accessRights";

	/**
	 * This method will be called by system creator during initialization and system update. Be sure that this method can
	 * be called repeatedly.
	 *
	 * @param context
	 *           the context provides the selected parameters and values
	 */
	@SystemSetup(type = Type.ESSENTIAL, process = Process.ALL)
	public void createEssentialData(final SystemSetupContext context)
	{
		importImpexFile(context, "/merchandisecore/import/common/essential-data.impex");
		importImpexFile(context, "/merchandisecore/import/common/countries.impex");
		importImpexFile(context, "/merchandisecore/import/common/delivery-modes.impex");

		importImpexFile(context, "/merchandisecore/import/common/themes.impex");
		importImpexFile(context, "/merchandisecore/import/common/user-groups.impex");
		importImpexFile(context, "/merchandisecore/import/common/cronjobs.impex");

		CatalogManager cm = CatalogManager.getInstance();

		// get source and target version of synchronization
		CatalogVersion src = cm.getCatalog( "electronicsProductCatalog" ).getCatalogVersion( "Staged" );
		CatalogVersion tgt = cm.getCatalog( "electronicsProductCatalog" ).getCatalogVersion( "Online" );

		// find rule by source and target (provided there is just one!)
		SyncItemJob syncJob = cm.getSyncJob( src, tgt );

		// get attribute which should be treated as part-of
		AttributeDescriptor ad = TypeManager.getInstance().getComposedType(Product.class)
                .getDeclaredAttributeDescriptor( "ratings" );

		// get or create attribute synchronization config item
		SyncAttributeDescriptorConfig cfg = syncJob.getConfigFor(ad, true);

		// set part-of behavior to true
		cfg.setCopyByValue( true );
	}

	/**
	 * Generates the Dropdown and Multi-select boxes for the project data import
	 */
	@Override
	@SystemSetupParameterMethod
	public List<SystemSetupParameter> getInitializationOptions()
	{
		final List<SystemSetupParameter> params = new ArrayList<>();

		params.add(createBooleanSystemSetupParameter(IMPORT_ACCESS_RIGHTS, "Import Users & Groups", true));

		return params;
	}

	/**
	 * This method will be called during the system initialization.
	 *
	 * @param context
	 *           the context provides the selected parameters and values
	 */
	@SystemSetup(type = Type.PROJECT, process = Process.ALL)
	public void createProjectData(final SystemSetupContext context)
	{
		final boolean importAccessRights = getBooleanSystemSetupParameter(context, IMPORT_ACCESS_RIGHTS);

		final List<String> extensionNames = getExtensionNames();

		processCockpit(context, importAccessRights, extensionNames, "cmscockpit",
				"/merchandisecore/import/cockpits/cmscockpit/cmscockpit-users.impex",
				"/merchandisecore/import/cockpits/cmscockpit/cmscockpit-access-rights.impex");

		processCockpit(context, importAccessRights, extensionNames, "productcockpit",
				"/merchandisecore/import/cockpits/productcockpit/productcockpit-users.impex",
				"/merchandisecore/import/cockpits/productcockpit/productcockpit-access-rights.impex",
				"/merchandisecore/import/cockpits/productcockpit/productcockpit-constraints.impex");

		processCockpit(context, importAccessRights, extensionNames, "cscockpit",
				"/merchandisecore/import/cockpits/cscockpit/cscockpit-users.impex",
				"/merchandisecore/import/cockpits/cscockpit/cscockpit-access-rights.impex");

		processCockpit(context, importAccessRights, extensionNames, "reportcockpit",
				"/merchandisecore/import/cockpits/reportcockpit/reportcockpit-users.impex",
				"/merchandisecore/import/cockpits/reportcockpit/reportcockpit-access-rights.impex");

		if (extensionNames.contains("mcc"))
		{
			importImpexFile(context, "/merchandisecore/import/common/mcc-sites-links.impex");
		}
	}

	protected void processCockpit(final SystemSetupContext context, final boolean importAccessRights,
			final List<String> extensionNames, final String cockpit, final String... files)
	{
		if (importAccessRights && extensionNames.contains(cockpit))
		{
			for (final String file : files)
			{
				importImpexFile(context, file);
			}
		}
	}

	protected List<String> getExtensionNames()
	{
		return Registry.getCurrentTenant().getTenantSpecificExtensionNames();
	}

	protected <T> T getBeanForName(final String name)
	{
		return (T) Registry.getApplicationContext().getBean(name);
	}
}
