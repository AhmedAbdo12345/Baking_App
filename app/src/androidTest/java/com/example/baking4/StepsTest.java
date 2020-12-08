package com.example.baking4;

import android.drm.DrmStore;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.example.baking4.Fragment.StepsFragment;
import com.example.baking4.Fragment.VedioFragment;
import com.google.android.exoplayer2.Player;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4ClassRunner.class)
public class StepsTest {
    @Rule
    public ActivityTestRule<DetailsActivity> mActivityTestRule =
            new ActivityTestRule<>(DetailsActivity.class);
    @Test
    public void checkbutton() {

//        onView((withId(R.id.RV_Baking)))
//                .perform(click());

     // onView(withId(R.id.playerView)).check(matches(withText("0")));
       // onView(withId(R.id.playerView)).check(matches(isDisplayed()));
//        onView(withId(R.id.image_thumbnailURL)).check(matches(isDisplayed()));
//        onView(withId(R.id.vedio_Button)).check(matches(isDisplayed()));
  //      onView(withId(R.id.image_thumbnailURL)).check(matches(isDisplayed()));


    }
}