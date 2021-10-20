package com.example.simpleparadox.listycity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.app.Activity;
import android.widget.EditText;
import android.widget.ListView;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test class for MainActivity. All the UI tests are written here. Robotium test framework is
 * used
 */
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<>(MainActivity.class, true, true);
    private Solo solo;

    /**
     * Runs before all tests and creates solo instance.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), rule.getActivity());
    }

    /**
     * Gets the Activity
     *
     * @throws Exception
     */
    @Test
    public void start() throws Exception {
        Activity activity = rule.getActivity();
    }

    /**
     * Add a city to the listview and check the city name using assertTrue
     * Clear all the cities from the listview and check again with assertFalse
     */
    @Test
    public void checkList() {
        // Asserts that the current activity is the MainActivity. Otherwise, show “Wrong Activity”
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
        solo.clickOnButton("ADD CITY"); //Click ADD CITY Button
        //Get view for EditText and enter a city name
        solo.enterText((EditText) solo.getView(R.id.editText_name), "Edmonton");
        solo.clickOnButton("CONFIRM"); //Select CONFIRM Button
        solo.clearEditText((EditText) solo.getView(R.id.editText_name)); //Clear the EditText
        /* True if there is a text: Edmonton on the screen, wait at least 2 seconds and find
           minimum one match. */
        assertTrue(solo.waitForText("Edmonton", 1, 2000));
        solo.clickOnButton("CLEAR ALL"); //Select CLEAR ALL
        //True if there is no text: Edmonton on the screen
        assertFalse(solo.searchText("Edmonton"));
    }

    /**
     * Check item taken from the listview
     */
    @Test
    public void checkCiyListItem() {
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
        solo.clickOnButton("ADD CITY");
        solo.enterText((EditText) solo.getView(R.id.editText_name), "Edmonton");
        solo.clickOnButton("CONFIRM");
        solo.waitForText("Edmonton", 1, 2000);
        // Get MainActivity to access its variables and methods.
        MainActivity activity = (MainActivity) solo.getCurrentActivity();
        final ListView cityList = activity.cityList; // Get the listview
        String city = (String) cityList.getItemAtPosition(0); // Get item from first position
        assertEquals("Edmonton", city);
    }

    private void moveToShowCity() {
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
        solo.clickOnButton("CLEAR ALL");

        // add city
        solo.clickOnButton("ADD CITY");
        solo.enterText((EditText) solo.getView(R.id.editText_name), "Edmonton");
        solo.clickOnButton("CONFIRM");
        solo.waitForText("Edmonton", 1, 2000);
        solo.clickOnText("Edmonton");
    }

    private void moveToMain() {
        solo.clickOnButton("BACK");
        solo.waitForActivity("MainActivity", 5000);
    }

    @Test
    public void checkMoveShowActivity() {
        moveToShowCity();
        // test for correct activity
        solo.waitForActivity("ShowActivity", 5000);
        solo.assertCurrentActivity("Wrong Activity", ShowActivity.class);
        moveToMain();
    }

    @Test
    public void checkCorrectCity() {
        moveToShowCity();
        // test for correct city
        assertTrue(solo.searchText("Edmonton"));
        moveToMain();
    }

    @Test
    public void checkBackButton() {
        moveToShowCity();
        // test that back button works
        solo.clickOnButton("BACK");
        solo.waitForActivity("MainActivity", 5000);
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);
    }

    /**
     * Closes the activity after each test
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

}