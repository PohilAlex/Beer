package com.example.beer;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.beer.model.BeerStorage;

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
        setActivityInitialTouchMode(false);
        mainActivity = getActivity();
        typeSpinner = (Spinner) mainActivity.findViewById(R.id.beer_type_spinner);
        addBtn = (Button) mainActivity.findViewById(R.id.add_btn);
        beerListView = (ListView) mainActivity.findViewById(R.id.beer_list);
        decoderView = mainActivity.getWindow().getDecorView();
        BeerStorage.getInstance().clear();
    }

    public void testLoad() {
        ViewAsserts.assertOnScreen(decoderView, typeSpinner);
        ViewAsserts.assertOnScreen(decoderView, addBtn);
        ViewAsserts.assertOnScreen(decoderView, beerListView);
    }

    public void testAddBtnClick() {
        int reportSize = BeerStorage.getInstance().getReportList().size();
        assertEquals(reportSize, beerListView.getAdapter().getCount());
        TouchUtils.clickView(this, addBtn);
        reportSize = BeerStorage.getInstance().getReportList().size();
        assertEquals(reportSize, beerListView.getAdapter().getCount());
        TouchUtils.clickView(this, addBtn);
        assertEquals(reportSize, beerListView.getAdapter().getCount());
    }

    @LargeTest
    public void testBeerListAddItem() {
        TouchUtils.clickView(this, addBtn);
        int position = 0 + beerListView.getHeaderViewsCount(); // =)
        ViewGroup layout = (ViewGroup) beerListView.getChildAt(position);
        TextView title = (TextView) layout.findViewById(R.id.beer_title);
        TextView count = (TextView) layout.findViewById(R.id.beer_count);
        Log.d("TEST1", "Title = " + title.getText());
        Log.d("TEST1", "Count = " + count.getText());
        assertEquals(title.getText(), typeSpinner.getSelectedItem());
        assertEquals(count.getText(), "1");

        TouchUtils.clickView(this, addBtn);
        assertEquals(title.getText(), typeSpinner.getSelectedItem());
        assertEquals(count.getText(), "2");

        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                typeSpinner.setSelection(1);
            }
        });
        TouchUtils.clickView(MainActivityTest.this, addBtn);
        getInstrumentation().waitForIdle(new Runnable() {
            @Override
            public void run() {
                int position = 1 + beerListView.getHeaderViewsCount();
                ViewGroup layout = (ViewGroup) beerListView.getChildAt(position);
                TextView title = (TextView) layout.findViewById(R.id.beer_title);
                TextView count = (TextView) layout.findViewById(R.id.beer_count);
                Log.d("TEST1", "Title = " + title.getText());
                Log.d("TEST1", "Count = " + count.getText());
                assertEquals(title.getText(), typeSpinner.getSelectedItem());
                assertEquals(count.getText(), "1");
            }
        });
    }

}
