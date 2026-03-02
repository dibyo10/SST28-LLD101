package com.example.metrics;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Thread-safe Singleton MetricsRegistry using static holder pattern.
 */
public class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Map<String, Long> counters = new HashMap<>();
    private static volatile boolean instanceCreated = false;

    // Private constructor with reflection protection
    private MetricsRegistry() {
        synchronized (MetricsRegistry.class) {
            if (instanceCreated) {
                throw new IllegalStateException("Instance already exists. Use getInstance()");
            }
            instanceCreated = true;
        }
    }

    // Static holder pattern for lazy initialization and thread safety
    private static class Holder {
        private static final MetricsRegistry INSTANCE = new MetricsRegistry();
    }

    public static MetricsRegistry getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized void setCount(String key, long value) {
        counters.put(key, value);
    }

    public synchronized void increment(String key) {
        counters.put(key, getCount(key) + 1);
    }

    public synchronized long getCount(String key) {
        return counters.getOrDefault(key, 0L);
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }

    // Preserve singleton on deserialization
    @Serial
    protected Object readResolve() {
        return getInstance();
    }
}
