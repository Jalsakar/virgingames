package com.virgingames.pages;

import com.virgingames.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ModernSlaveryPolicyPage extends Utility {

    //This code initializes a logger object named log for the ModernSlaveryPolicyPage class using Apache Log4j2.
    private static final Logger log = LogManager.getLogger(ModernSlaveryPolicyPage.class.getName());

    //========================== Locators ============================//
    @CacheLookup
    @FindBy(css = ".jss32")
    WebElement headerMessage;

    //======================== Methods ================================//

    public String verifyHeaderMessage(){
        log.info("Verify Header Text" + headerMessage.toString());
        return getTextFromElement(headerMessage);
    }
}
