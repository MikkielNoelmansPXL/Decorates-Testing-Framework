package portal.Frameworktest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import portal.hooks.DefaultHooks;

import java.util.Random;

import static com.google.common.truth.Truth.assertThat;

public class CounterTest extends DefaultHooks {
    @BeforeTest
    public void beforeGroup(){
        pages.counterPage.navigateTo();
    }
    @Test(groups = {"Counter", "Functionality"})
        public void clickCounter() {
        Random random = new Random();
        int upperbound = 25;
        int randomNumber = random.nextInt(upperbound);

        for (int i = 0; i < randomNumber; i++) {
            pages.counterPage.clickCounter();
        }

        assertThat(pages.counterPage.counterAmount()).contains("Current count: " + randomNumber);
    }
}
