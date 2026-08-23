package com.launcher.core;

/**
 * Интерфейс для отслеживания прогресса запуска
 */
public interface LaunchProgress {
    void updateProgress(double progress, String message);
    void onComplete();
    void onError(String error);
}
