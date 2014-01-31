package com.example.beer;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.example.beer.MainActivityTest \
 * com.example.beer.tests/android.test.InstrumentationTestRunner
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super("com.example.beer", MainActivity.class);
    }

    MainActivity mainActivity;
    Spinner typeSpinner;
    Button addBtn;
    ListView beerListView;
    View decoderView;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(true);
        mainActivity = getActivity();
        typeSpinner = (Spinner) mainActivity.findViewById(R.id.beer_type_spinner);
        addBtn = (Button) mainActivity.findViewById(R.id.add_btn);
        beerListView = (ListView) mainActivity.findViewById(R.id.beer_list);
        decoderView = mainActivity.getWindow().getDecorView();
    }

    public void testLoad() {
        ViewAsserts.assertOnScreen(decoderView, typeSpinner);
        ViewAsserts.assertOnScreen(decoderView, addBtn);
        ViewAsserts.assertOnScreen(decoderView, beerListView);
    }

}
