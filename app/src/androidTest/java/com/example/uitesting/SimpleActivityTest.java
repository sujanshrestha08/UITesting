package com.example.uitesting;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.uitesting.R.id.etText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SimpleActivityTest{

    @Rule
    public ActivityTestRule<SimpleActivity> testRule =
        new ActivityTestRule<>(SimpleActivity.class);

    private String mText= "Hello";

    @Test
    public void TestUI() throws  Exception
    {
        onView(withId(R.id.etText))
                .perform(typeText(mText));

        closeSoftKeyboard();

        onView(withId(R.id.btnClick))
                .perform(click());

        onView(withId(R.id.tvDisplay))
                .check(matches(withText(mText)));
    }

}