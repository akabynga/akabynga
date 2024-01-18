package com.akabynga.patterns.observer.editor;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}