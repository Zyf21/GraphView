package com.example.aleksandr.grafik;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Calendar;
import java.util.Date;

public class Main3Activity extends AppCompatActivity {

    //Число должно быть на 1 меньше чем количество дат в массиве
    private int mNumLabels = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        GraphView graphdata =  findViewById(R.id.graphData);

        Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d2 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d3 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d4 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d5 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d6 = calendar.getTime();



        //  Date  d1 = new Date(System.currentTimeMillis());
        //  Date d2 = new Date(System.currentTimeMillis() + 10000);
        //  Date d3 = new Date(System.currentTimeMillis() + 20000);


        // you can directly pass Date objects to DataPoint-Constructor
        // this will convert the Date to double via Date#getTime()
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(d1, 1),
                new DataPoint(d2, 4),
                new DataPoint(d3, 2),
                new DataPoint(d4, 5),
                new DataPoint(d5, 1),
                new DataPoint(d6, 4)
        });
        // Просто прокрутка
        // graphdata.getViewport().setScrollable(true);

        //Прокрутка с увеличение
        graphdata.getViewport().setScalable(true);

        graphdata.getGridLabelRenderer().setGridColor(Color.RED);
        graphdata.getGridLabelRenderer().setHighlightZeroLines(false);
        graphdata.getGridLabelRenderer().setVerticalLabelsVAlign(GridLabelRenderer.VerticalLabelsVAlign.ABOVE);
        graphdata.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
        graphdata.getGridLabelRenderer().reloadStyles();
        graphdata.getGridLabelRenderer().setHorizontalLabelsColor(Color.RED);
        
        graphdata.addSeries(series);

        // set date label formatter
        graphdata.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(graphdata.getContext()));
        graphdata.getGridLabelRenderer().setNumHorizontalLabels(mNumLabels);

        // set manual x bounds to have nice steps
        graphdata.getViewport().setMinX(d1.getTime());
        graphdata.getViewport().setMaxX(d3.getTime());
        graphdata.getViewport().setXAxisBoundsManual(true);

        // as we use dates as labels, the human rounding to nice readable numbers
        // is not nessecary
        graphdata.getGridLabelRenderer().setHumanRounding(false);

    }




}
