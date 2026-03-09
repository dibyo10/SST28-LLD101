package com.example.map.factory;

import com.example.map.model.MarkerStyle;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO (student):
 * Implement Flyweight factory that caches MarkerStyle by a stable key.
 * <p>
 * Suggested key format:
 * shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O")
 * <p>
 * After refactor:
 * - MapDataSource should call this factory to obtain shared MarkerStyle instances.
 */
public class MarkerStyleFactory {

    private static final Map<String, MarkerStyle> cache = new HashMap<>();

    public static MarkerStyle get(String shape, String color, int size, boolean filled) {
        String key = shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");
        if (!cache.containsKey(key)) {
            MarkerStyle obj = new MarkerStyle(shape, color, size, filled);
            cache.put(key, obj);
        }
        return cache.get(key);
    }

    public static int cacheSize() {
        return cache.size();
    }
}