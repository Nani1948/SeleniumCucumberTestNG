package com.seleniumcucumberframework.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(linkText="Close")WebElement close;
	@FindBy(xpath="//span[@id='userNavLabel']")WebElement  userProfileName;
	@FindBy(linkText="My Settings")WebElement  mySettings;
	@FindBy(xpath="//a[@class='menuButtonMenuLink'][3]")WebElement logout;
	@FindBy(id="userNav-menuItems")private List<WebElement> dropdownListOfUserMenu;	
	@FindBy(xpath="//div[@id='PersonalInfo']")WebElement personalInformation;
	@FindBy(xpath="//a[@id='LoginHistory_font']")WebElement loginHistory;
	@FindBy(linkText="Download login history for last six months, including logins from outside the website, such as API logins (Excel .csv file) »")WebElement downloadLoginHistory;
	@FindBy(id="tsidButton")WebElement clickonDropdownPages;
	//@FindBy(id="tsid-menuItems")private  List<WebElement> dropdownListOfPagesMenu;
	@FindBy(xpath="//a[contains(text(),'Reports')]")WebElement reportTab;
	@FindBy(xpath="//li[@id='MoreTabs_Tab']")WebElement DropdownOfAllTabs;
	@FindBy(xpath="//a[contains(text(),'Salesforce Chatter')]")WebElement  selectSalesChatterfromPagesDropdown;
	@FindBy(xpath="//select[@id='p4' and @name='p4']")WebElement salesOptions;
	@FindBy(xpath="//a[contains(text(),'Sales')]")WebElement selectSalesfromPagesDropdown;
	@FindBy(xpath="//input[@value='No Thanks']")WebElement  noThanks;
	@FindBy(xpath="//ul[@id='tabBar']")private List<WebElement> ListOfAllTabs;
    //My Personal
	@FindBy(xpath="//a[@title='My Profile']")WebElement myProfile;
	//AccountTab
	@FindBy(linkText="Accounts")WebElement  accountTab;
	//OpportunitesTab
	@FindBy(linkText="Opportunities")WebElement  opportunitiesTab;
	//ContactTab
	@FindBy(xpath="//a[@title='Contacts Tab']")WebElement contactTab;
	//HomeTab
	@FindBy(linkText="Home")WebElement homeTab;
	@FindBy(xpath="//img[@title='All Tabs']")WebElement plusIcon;
	public void clickOnUserProfileName() {
		moveToElementAction(driver, userProfileName,"ProfileName");
	}
	public void clickOnAccount() {
		moveToElementAction(driver,accountTab,"Account");
	}
	public void clickOnOpportunities() {
		moveToElementAction(driver,opportunitiesTab,"Opportunites");
	}
	public void clickOnMySettings() {
    	moveToElementAction(driver, mySettings,"My Settings");
    }
	public void clickOnLogout() {
		moveToElementAction(driver, logout,"Logout");
	}
	public String getTextOfUserNameFromUserMenuDropdown() {
		return userProfileName.getText();
	}
    public  void getListofUserMenuDropdown() {
    	 List<WebElement> listOfUserMenu = new ArrayList<>();

	        for (WebElement listOfOptions : dropdownListOfUserMenu) {
	        	listOfUserMenu.add(listOfOptions);
	            System.out.println(listOfOptions.getText());
	        }
    }
    public String getTitleOfHomePage() {
    	return getPageTitle();
    }
    
    public void clickOnPersonalInformation() {
    	moveToElementAction(driver,  personalInformation," Personal Information");
    }
    public void clickOnLoginHistory() {
    	moveToElementAction(driver,  loginHistory," Login History");
    }
    
    public void clickOnDownloadLoginHistory() {
    	moveToElementAction(driver,  downloadLoginHistory," Download Login History");
    }
   

  
    
    public void clickOnSalesforceChatterPages(String text) {
    	moveToElementAction(driver,  selectSalesChatterfromPagesDropdown,text);
    	
    }
    public String getTextOfReports() {
        List<WebElement> listOfTabBar = new ArrayList<>();

        for (WebElement listOfOptions : ListOfAllTabs) {
            listOfTabBar.add(listOfOptions);
            String optionText = listOfOptions.getText();
            System.out.println(optionText);
            String reportTabText=reportTab.getText();
            if (optionText.equals(reportTabText)) {
                return optionText;
            }
        }

        return null; // If the report tab text is not found, return null
    
       // https://github.com/DivyashreeBA/mayjavaproject.git

    }
    public void  maximizedWindow() {
    	driver.manage().window().maximize();
    }
    public void switchToWindow() {
      driver.switchTo().window(driver.getWindowHandle());
    }
    public boolean isTabPresentInList(String text) {
       
        
        for (WebElement tab :  ListOfAllTabs) {
            String tabText = tab.getText();
            if (tabText.equals(text)) {
                return true; // Tab is present in the list
            }
        }
        
        return false; // Tab is not present in the list
    }
    public void selectSales(String text) {
    	selectByVisibleTextOfElement(salesOptions, text);
    }
    public void clickOnSalesPages(String text) {
    	moveToElementAction(driver,  selectSalesfromPagesDropdown,text);
    	
    }
    public void clickOnNoThanks(String text) {
    	clickElement(driver,  noThanks, text);
    }
    public void clickOnMyProfile(String text) {
    	clickElement(driver, myProfile, text);
    }
    public String getTitleOfMyProfilePage(String text) {
    	clickElement(driver, myProfile, text);
    	return getPageTitle().toString();
    }
    public void  switchToMainWindow() {
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	 driver.switchTo().window(driver.getWindowHandle());
    }
    public void clickOnContact(String text) {
    	clickElement(driver,  contactTab, text);
    }
    public void clickOnHome(String text) {
    	clickElement(driver,  homeTab, text);
    }
    public void clickOnClose(String text) {
		   moveToElementAction(driver, close,  text);
	}
    public void clickOnPlusIcon(String text) {
    	  moveToElementAction(driver,plusIcon,  text);
    }
    public String getTitleOfPage(String text) {
    	waitForTitle(driver, text);
    	return driver.getTitle();
    }

}
