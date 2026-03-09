package com.example.map;

import com.example.map.model.MapMarker;
import com.example.map.test.QuickCheck;
import com.example.map.utils.MapDataSource;
import com.example.map.utils.MapRenderer;

import java.util.List;

/**
 * Entry point for the demo.
 */
public class App {

    public static void main(String[] args) {
        int n = 30_000;

        MapDataSource ds = new MapDataSource();
        List<MapMarker> markers = ds.loadMarkers(n);

        new MapRenderer().render(markers);

        System.out.println();
        System.out.println("Run QuickCheck to verify Flyweight sharing:");
        System.out.println("  java com.example.map.test.QuickCheck\n");

        System.out.println("RUNNING QUICKCHECK....\n");
        QuickCheck.run();
    }
}