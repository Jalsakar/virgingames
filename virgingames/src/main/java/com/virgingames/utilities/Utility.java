package com.virgingames.utilities;

import com.virgingames.browserfactory.ManageBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.*;
import java.util.function.Function;

public class Utility extends ManageBrowser {
    /* Utility Class extends to ManageDriver for the driver to finding locators
     * All common methods are fixed in the utility Class.
     */

//************************************************************************//

    /**
     * * This method will generate random number
     */
    public int generateRandomNumber() {
        return (int) (Math.random() * 5000 + 1);

    }

    /**
     * This method will generate random string
     */
    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void sendTextToElement(WebElement element, String str) {
        element.sendKeys(str);
    }

    /**
     * This method will return list of web elements
     */
    public List<WebElement> webElementList(By by) {
        return driver.findElements(by);
    }

    /**
     * This method will clear previous stored data
     */
    public void clearTextFromField(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL + "a");
        driver.findElement(by).sendKeys(Keys.DELETE);
    }

    public void sendTabAndEnterKey(By by) {
        driver.findElement(by).sendKeys(Keys.TAB);
        //driver.findElement(by).sendKeys(Keys.ENTER);
    }

    /**
     * This method will get arrayList from web elements
     */
    public ArrayList<String> getArrayListFromWebElements(List<WebElement> listOfElements) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (WebElement element : listOfElements) {
            arrayList.add(element.getText());
        }
        System.out.println(arrayList);
        return arrayList;
    }

//*************************** Alert Methods ***************************************//

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This method will accept alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss alert
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will get text from alert
     */
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    /**
     * This method will send text from alert
     */
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }


//*************************** Select Class Methods ***************************************//

    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByVisibleTextFromDropDown(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    /**
     * This method will select the option by value
     */
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    public void selectByValueFromDropDown(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

    /**
     * This method will select the option by index
     */
    public void selectByIndexFromDropDown(WebElement by, String index) {
        new Select(driver.findElement((By) by)).selectByIndex(Integer.parseInt(index));
    }

    public void selectByIndexFromDropDown(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    /**
     * This method will select the option by contains text
     */
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

//*************************** Window Handle Methods ***************************************//

    /**
     * This method will close all windows
     */
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to right window
     */
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }
//*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * This method will use to hover mouse on element and click
     */
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }

    public void mouseHoverToElementAndClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    //************************** Waits Methods *********************************************//

    /**
     * This method will use to wait until  VisibilityOfElementLocated
     */
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

//***************************** Is Display Methods **********************************************//

    /**
     * This method will verify that element is displayed
     */
    public boolean verifyThatElementIsDisplayed(By by) {
        WebElement element = driver.findElement(by);
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatElementIsDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method will verify that element is displayed
     */
    public boolean verifyThatTextIsDisplayed(By by, String text) {
        WebElement element = driver.findElement(by);
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatTextIsDisplayed(WebElement element, String text) {
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    //************************** ScreenShot Methods *********************************************//

    /**
     * This method will take screenshot
     */
    public static void takeScreenShot() {
        String filePath = System.getProperty("user.dir") + "/src/main/java/com/nopcommerce/demo/screenshots/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr1, new File(filePath + getRandomString(10) + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/main/java/com/demo/nopcommerce/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /**
     * Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /**
     * Take screenshot in Byte Format
     */
    public static byte[] getScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void switchToIframe(WebElement element) {
        driver.switchTo().frame(element);
    }

    public String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

    //******************************JAVA Executor Methods*********************************//

    //import org.openqa.selenium.JavascriptExecutor;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    //To perform scroll vertically for 1000px
    public void javaExecutorScriptExecuteScriptToPerformScroll() {
        js.executeScript("window.scrollBy(0,1000)");
    }

    //Performing a sleep in the browser under test
    public void jvJavaScriptExecutorExecuteASyncScriptPerformingSleep() {
        long start = System.currentTimeMillis();
        ((JavascriptExecutor) driver).executeAsyncScript(
                "window.setTimeout(arguments[arguments.length - 1], 500);");
        System.out.println(
                "Elapsed time: " + (System.currentTimeMillis() - start));
    }

    //Scroll the page till the element is found
    public void javaExecutorScriptExecuteScriptToScrollThePageTillElementFound(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    //To click on button
    public void javaExecutorScriptExecuteScriptToClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    //find the hidden element
    public void jsHiddenElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('displayed-text').value='text123'");
    }
    //********************************************** upload files ******************************************************

    /**
     * This method will upload the file when input is a tag and file name is upload file so we
     * can use send keys method
     */
    public void uploadFiles(String path, By by) {
        WebElement fileInput = driver.findElement(by);
        fileInput.sendKeys(path);
    }

    public void uploadFiles(String path, WebElement element) {
        element.sendKeys(path);
    }

    /**
     * This method will upload the file when we do not have input as tag then we can use robot class and action class
     * or JavaScripExecutor to load file using some of the keyboard actions.
     */
    public void uploadFile(String filePath, By by) throws AWTException {
        //perform click action on window based application
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(by);
        actions.moveToElement(elementLocator).click().build().perform();

//        WebElement button = driver.findElement(by);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", button);//click action on the button

        //creating object for Robot class
        Robot rb = new Robot();
        rb.delay(2000);
        //put path to the file in a clipboard
        StringSelection ss = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        //CTL+V
        rb.keyPress(KeyEvent.VK_CONTROL);//Press on CTL key
        rb.keyPress(KeyEvent.VK_V);//Press on Key V to Paste it
        rb.keyRelease(KeyEvent.VK_CONTROL);//Release CTL Key
        rb.keyRelease(KeyEvent.VK_V);//Release V key
        //Enter action
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    public void uploadFile(String filePath, WebElement element) throws AWTException {
        //perform click action on window based application
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
//        WebElement button = driver.findElement(by);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", button);//click action on the button

        //creating object for Robot class
        Robot rb = new Robot();
        rb.delay(2000);
        //put path to the file in a clipboard
        StringSelection ss = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        //CTL+V
        rb.keyPress(KeyEvent.VK_CONTROL);//Press on CTL key
        rb.keyPress(KeyEvent.VK_V);//Press on Key V to Paste it
        rb.keyRelease(KeyEvent.VK_CONTROL);//Release CTL Key
        rb.keyRelease(KeyEvent.VK_V);//Release V key
        //Enter action
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    //****************************  Return WebElement and List of WebElement ****************************

    /**
     * This method will find the list of WebElements
     */
    public List<WebElement> findElementsList(By by) {
        return driver.findElements(by);
    }

    /**
     * This method will Return List of WebElements
     */
    public List<WebElement> getListOfElements(By by) {
        return driver.findElements(by);
    }

    public List<WebElement> findElementsList(WebElement element) {
        return (List<WebElement>) element;
    }

    /**
     * This method will find one WebElement
     */

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public WebElement findElement(WebElement element) {
        return element;
    }
    //******************************  clear Text from previous data ******************************

    public void clearTextFromField(WebElement element) {
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

    public void clearTextField(By by) {
        driver.findElement(by).clear();
    }

    public void clearTextField(WebElement element) {
        element.clear();
    }

    public void sendTabAndEnterKey(WebElement element) {
        element.sendKeys(Keys.TAB);
        // element.sendKeys(Keys.ENTER);
    }

    //*************************** Select Class Methods ***************************************//

    /**
     * This method will select the option by visible text
     */
    public void selectVisibleTextFromDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option by index
     */
    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }


    public void selectByContainsTextFromDropDown(WebElement element, String text) {
        List<WebElement> allOptions = new Select(element).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

    /**
     * When we do not have select tag for dropdown then we use this method
     */
    public void dynamicListDropDown(By by, String text) {
        List<WebElement> dynamicList = driver.findElements(by);
        for (int i = 0; i < dynamicList.size(); i++) {
            String option = dynamicList.get(i).getText();
            if (option.contains(text)) {
                dynamicList.get(i).click();
                break;
            }
        }
    }

    public void dynamicListDropDown(WebElement element, String text) {
        List<WebElement> dynamicList = (List<WebElement>) element;
        for (int i = 0; i < dynamicList.size(); i++) {
            String option = dynamicList.get(i).getText();
            if (option.contains(text)) {
                dynamicList.get(i).click();
                break;
            }
        }
    }

    //************************** Waits Methods *********************************************//

    /**
     * This explicit wait method will use to wait until visibilityOfElementLocated
     */

    public WebElement waitUntilVisibilityOfElementLocated(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
    }

    //***************************** Is Display Methods **********************************************//

    public boolean isTextDisplayed(By by, String expectedText) {
        boolean actualText = (driver.findElement(by).getText()).contains(expectedText); // Find and get actual text on page and check whether it contains expected text or not?
        assert actualText : expectedText + "Text is not found";
        return true;
    }

    public boolean isTextDisplayed(WebElement element, String expectedText) {
        boolean actualText = (element.getText()).contains(expectedText); // Find and get actual text on page and check whether it contains expected text or not?
        assert actualText : expectedText + "Text is not found";
        return true;
    }

    //************************** ArrayList Methods *********************************************//
    public void getArrayListOfProductsInChoice(By by) {
        List<WebElement> products = findElementsList(by);

        ArrayList<String> actualSortByProduct = new ArrayList<>();
        for (WebElement element : products) {
            String[] array = element.getText().split("Ex Tax:");
            actualSortByProduct.add(String.valueOf(Double.valueOf(array[0].substring(1).replaceAll(",", ""))));
        }

        System.out.println("Before sorting: " + actualSortByProduct);
        Collections.sort(actualSortByProduct, Collections.reverseOrder());
        System.out.println("After sorting: " + actualSortByProduct);

        ArrayList<String> afterSortByProduct = new ArrayList<>(actualSortByProduct);

        System.out.println("Expected result: " + afterSortByProduct);

    }

    public void getArrayListOfProductsInChoice(WebElement element) {
        List<WebElement> products = findElementsList(element);

        ArrayList<String> actualSortByProduct = new ArrayList<>();
        for (WebElement elements : products) {
            String[] array = elements.getText().split("Ex Tax:");
            actualSortByProduct.add(String.valueOf(Double.valueOf(array[0].substring(1).replaceAll(",", ""))));
        }

        System.out.println("Before sorting: " + actualSortByProduct);
        Collections.sort(actualSortByProduct, Collections.reverseOrder());
        System.out.println("After sorting: " + actualSortByProduct);

        ArrayList<String> afterSortByProduct = new ArrayList<>(actualSortByProduct);

        System.out.println("Expected result: " + afterSortByProduct);

    }

//********************************************** List of products ******************************************************

    /**
     * This method will get currentUrl
     */
    public String getCurrentUrlForVerification() {
        return driver.getCurrentUrl();
    }


    /**
     * This method will print List of element in Console (TopMenuList)
     */

    public void listOfProductsElement(By by, String text) {
        List<WebElement> listOfMenuElements = driver.findElements(by);
        for (WebElement element : listOfMenuElements) {
            System.out.println(element.getText());

            if (element.getText().trim().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }
    }

    public void listOfProductsElement(WebElement element, String text) {
        List<WebElement> listOfMenuElements = (List<WebElement>) element;
        for (WebElement elementList : listOfMenuElements) {
            System.out.println(elementList.getText());

            if (element.getText().trim().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }
    }

    //**************************************************************************************************

    /**
     * This method will verify logo is visible
     */
    public void verifyLogoVisible(WebElement element) {
        boolean logoPresent = element.isDisplayed();
        Assert.assertTrue(logoPresent);
        if (!logoPresent) {
            System.out.println("Logo not Visible");
        } else {
            System.out.println("Logo is Visible");
        }
    }

    public void loginToApplication(String username, String password) {
    }

    //=======================================Download files===============================================//
    public void seleniumDownloadFile(By by) throws InterruptedException {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\DownloadFiles");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.navigate().to("https://automationexercise.com/payment_done/500");

        //We find the download links
        List<WebElement> list = driver.findElements(by);

        //Click to 5MB web element
        WebElement el = list.get(list.size() - 1);
        el.click();
        Thread.sleep(500);
        //Hide Google Popup Ad
        // js.executeScript("document.querySelector(\"html > ins\").style.display='none'");
        //Again click to 5MB web element
        //  el.click();

        //Wait 15 seconds to download 5MB file.
        Thread.sleep(15000);

        //Get the user.dir folder
        File folder = new File(System.getProperty("user.dir") + "\\DownloadFiles");

        //List the files on that folder
        File[] listOfFiles = folder.listFiles();

        boolean found = false;
        File f = null;

        //Look for the file in the files
        // You should write smart REGEX according to the filename
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("5MB.zip")) {
                    f = new File(fileName);
                    found = true;
                }

            }
        }
//        Assertions.assertTrue(found, "Downloaded document is not found");
//        f.deleteOnExit();
//        driver.close();
    }

}
