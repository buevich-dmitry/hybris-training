package com.expertsoft.merchandise.storefront.forms;

import de.hybris.platform.acceleratorstorefrontcommons.forms.UpdateProfileForm;

public class ElectronicsUpdateProfileForm extends UpdateProfileForm {

    private String secondEmail;

    public String getSecondEmail() {
        return secondEmail;
    }

    public void setSecondEmail(String secondEmail) {
        this.secondEmail = secondEmail;
    }
}
