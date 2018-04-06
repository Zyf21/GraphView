package com.example.aleksandr.grafik;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        GraphView graph =  findViewById(R.id.graph);
        DataPoint[] points = new DataPoint[50];
        for (int i = 0; i < 50; i++) {
            points[i] = new DataPoint(i, Math.sin(i*0.5) * 20*(Math.random()*10+1));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);

        // set manual X bounds
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(10);

        // enable scrolling
        graph.getViewport().setScrollable(true);

        //Цвет графика
        series.setColor(Color.BLUE);
        series.setTitle("Какой-то текст");

        //Тип графика
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(15);
        series.setThickness(8);

        // Настройка фона
        graph.getGridLabelRenderer().setVerticalAxisTitle("Вертикально");
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Горизонтально");
        graph.getGridLabelRenderer().setGridColor(Color.RED);
        graph.getGridLabelRenderer().setHighlightZeroLines(false);
        graph.getGridLabelRenderer().setVerticalLabelsVAlign(GridLabelRenderer.VerticalLabelsVAlign.ABOVE);
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
        graph.getGridLabelRenderer().reloadStyles();
        graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.RED);

        // Цвет фона и границ
        graph.getViewport().setBackgroundColor(Color.argb(255, 222, 222, 222));
        graph.getViewport().setDrawBorder(true);
        graph.getViewport().setBorderColor(Color.BLUE);

        graph.addSeries(series);

        // Добавление текста к подписям
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    return super.formatLabel(value, isValueX)+ " $";
                } else {
                    // show currency for y values
                    return super.formatLabel(value, isValueX) + " €";
                }
            }
        });
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);

    }
}
