package com.expertsoft.merchandise.storefront.forms;

import de.hybris.platform.acceleratorstorefrontcommons.forms.RegisterForm;

public class ElectronicsRegisterForm extends RegisterForm {

    private String secondEmail;

    public String getSecondEmail() {
        return secondEmail;
    }

    public void setSecondEmail(String secondEmail) {
        this.secondEmail = secondEmail;
    }
}
