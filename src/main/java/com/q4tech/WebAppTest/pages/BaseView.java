package com.q4tech.WebAppTest.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;

public abstract class BaseView {
    protected WebDriver driver;
    protected Wait<WebDriver> fluentWait;
    private static final int TIMEOUT = 10; // Tiempo de espera por defecto
    private static final int POLLING_INTERVAL = 5; // Intervalo de chequeo en segundos
    //private static final Logger logger = LoggerFactory.getLogger(BaseView.class);

    public BaseView(WebDriver driver) {
        this.driver = driver;
        this.fluentWait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(TIMEOUT))
            .pollingEvery(Duration.ofSeconds(POLLING_INTERVAL))
            .ignoring(NoSuchElementException.class);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        getLogger().info("Current URL: {}", url);
        return url;
    }

    // Wrapper para click
    public void click(WebElement element) {
        try {
            waitForElementToBeClickable(element).click();
            getLogger().info("Clicked on element: {}", element);
        } catch (Exception e) {
            getLogger().error("Failed to click on element: {}", element, e);
            throw e;
        }
    }
    public void clickWithJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        getLogger().info("JavaScript click performed on element: {}", element);
    }
    // Wrapper para click con reintentos
    public void clickWithRetry(WebElement element, int attempts) {
        retryOperation(() -> click(element), attempts);
    }

    // Wrapper para sendKeys
    public void sendKeys(WebElement element, CharSequence... keysToSend) {
        try {
            waitForElementToBeVisible(element).sendKeys(keysToSend);
            getLogger().info("Sent keys '{}' to element: {}", keysToSend, element);
        } catch (Exception e) {
            getLogger().error("Failed to send keys '{}' to element: {}", keysToSend, element, e);
            throw e;
        }
    }

    // Espera a que el elemento sea clickeable usando FluentWait
    public WebElement waitForElementToBeClickable(WebElement element) {
        return fluentWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Espera a que el elemento sea visible usando FluentWait
    public WebElement waitForElementToBeVisible(WebElement element) {
        return fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wrapper para retryOperation
    public void retryOperation(Runnable operation, int attempts) {
        for (int i = 0; i < attempts; i++) {
            try {
                operation.run();
                getLogger().info("Operation succeeded on attempt {}", i + 1);
                return;
            } catch (Exception e) {
                getLogger().warn("Operation failed on attempt {}", i + 1, e);
                if (i == attempts - 1) {
                    getLogger().error("Operation failed after {} attempts", attempts, e);
                    throw e; // Lanza la excepción si se agotaron los intentos
                }
                // Opción para hacer una pausa entre intentos
                try {
                    Thread.sleep(1000); // Pausa de 1 segundo antes de reintentar
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // Métodos adicionales
    public void mouseOver(WebElement toggleAside) {
        new Actions(driver).moveToElement(toggleAside).perform();
        getLogger().info("Mouse over element: {}", toggleAside);
    }

    public void moveMouseToCenter(WebElement toggleAside) {
        int windowWidth = driver.manage().window().getSize().getWidth();
        int windowHeight = driver.manage().window().getSize().getHeight();

        Actions actions = new Actions(driver);
        actions.moveByOffset(windowWidth / 2 - toggleAside.getLocation().getX(),
                windowHeight / 2 - toggleAside.getLocation().getY()).perform();
        getLogger().info("Moved mouse to center relative to element: {}", toggleAside);
    }

    public WebDriver switchToWebviewFrame(WebElement webviewFrameMainTris) {
        WebDriver frameDriver = driver.switchTo().frame(webviewFrameMainTris);
        getLogger().info("Switched to frame: {}", webviewFrameMainTris);
        return frameDriver;
    }

    public WebDriver switchToDefaultContent() {
        WebDriver defaultDriver = driver.switchTo().defaultContent();
        getLogger().info("Switched to default content");
        return defaultDriver;
    }

    // Método abstracto para que cada subclase defina su propio logger
    protected abstract Logger getLogger();
}