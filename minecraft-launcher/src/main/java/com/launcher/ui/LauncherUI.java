package com.launcher.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.effect.DropShadow;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import com.launcher.core.LauncherManager;

/**
 * Основной интерфейс лаунчера с красивым дизайном
 */
public class LauncherUI {

    private VBox root;
    private Label statusLabel;
    private Button playButton;
    private ComboBox<String> versionComboBox;
    private ProgressBar progressBar;
    private LauncherManager launcherManager;

    public LauncherUI() {
        launcherManager = new LauncherManager();
        initializeUI();
    }

    private void initializeUI() {
        root = new VBox(0);
        root.setStyle("-fx-background-color: transparent;");
        root.setPadding(new Insets(0));

        // Верхняя панель с заголовком
        VBox topPanel = createTopPanel();
        root.getChildren().add(topPanel);

        // Центральная часть с контентом
        VBox centerPanel = createCenterPanel();
        VBox.setVgrow(centerPanel, Priority.ALWAYS);
        root.getChildren().add(centerPanel);

        // Нижняя панель с кнопкой запуска
        VBox bottomPanel = createBottomPanel();
        root.getChildren().add(bottomPanel);
    }

    private VBox createTopPanel() {
        VBox topBox = new VBox(10);
        topBox.setPadding(new Insets(20, 30, 10, 30));
        topBox.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #2c3e50, #1a252f);" +
            "-fx-background-radius: 20 20 0 0;"
        );

        // Заголовок
        Text titleLabel = new Text("MINECRAFT LAUNCHER");
        titleLabel.setFill(Color.WHITE);
        titleLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");
        
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.rgb(0, 0, 0, 0.5));
        shadow.setRadius(10);
        titleLabel.setEffect(shadow);

        // Подзаголовок
        Text subtitleLabel = new Text("Добро пожаловать в мир Minecraft!");
        subtitleLabel.setFill(Color.rgb(200, 200, 200));
        subtitleLabel.setStyle("-fx-font-size: 14px;");

        // Статус бар
        statusLabel = new Label("Готов к запуску");
        statusLabel.setStyle("-fx-text-fill: #3498db; -fx-font-size: 12px;");

        topBox.getChildren().addAll(titleLabel, subtitleLabel, statusLabel);
        return topBox;
    }

    private VBox createCenterPanel() {
        VBox centerBox = new VBox(20);
        centerBox.setPadding(new Insets(30));
        centerBox.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #1a252f, #2c3e50);"
        );
        centerBox.setAlignment(Pos.CENTER);

        // Логотип (плейсхолдер)
        StackPane logoContainer = new StackPane();
        logoContainer.setPrefSize(200, 200);
        logoContainer.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.1);" +
            "-fx-background-radius: 100;" +
            "-fx-border-color: rgba(255, 255, 255, 0.2);" +
            "-fx-border-width: 3;" +
            "-fx-border-radius: 100;"
        );

        Text logoText = new Text("MC");
        logoText.setFill(Color.WHITE);
        logoText.setStyle("-fx-font-size: 60px; -fx-font-weight: bold;");
        logoContainer.getChildren().add(logoText);

        // Выбор версии
        VBox versionBox = new VBox(8);
        versionBox.setAlignment(Pos.CENTER);

        Label versionLabel = new Label("Выберите версию:");
        versionLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14px;");

        versionComboBox = new ComboBox<>();
        versionComboBox.getItems().addAll(
            "1.20.4 (Последняя)",
            "1.20.1",
            "1.19.4",
            "1.18.2",
            "1.17.1",
            "1.16.5",
            "1.12.2 (Моды)"
        );
        versionComboBox.setValue("1.20.4 (Последняя)");
        versionComboBox.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.1);" +
            "-fx-text-fill: white;" +
            "-fx-prompt-text-fill: gray;" +
            "-fx-background-radius: 8;" +
            "-fx-border-color: rgba(255, 255, 255, 0.3);" +
            "-fx-border-radius: 8;" +
            "-fx-padding: 8 15;"
        );

        // Прогресс бар
        progressBar = new ProgressBar(0);
        progressBar.setPrefWidth(300);
        progressBar.setStyle(
            "-fx-accent: #3498db;" +
            "-fx-background-color: rgba(255, 255, 255, 0.2);" +
            "-fx-background-radius: 10;"
        );
        progressBar.setVisible(false);

        versionBox.getChildren().addAll(versionLabel, versionComboBox, progressBar);
        centerBox.getChildren().addAll(logoContainer, versionBox);

        return centerBox;
    }

    private VBox createBottomPanel() {
        VBox bottomBox = new VBox(10);
        bottomBox.setPadding(new Insets(20, 30, 30, 30));
        bottomBox.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #2c3e50, #1a252f);" +
            "-fx-background-radius: 0 0 20 20;"
        );
        bottomBox.setAlignment(Pos.CENTER);

        // Кнопка запуска
        playButton = new Button("▶ ИГРАТЬ");
        playButton.setPrefSize(250, 50);
        playButton.setStyle(
            "-fx-background-color: linear-gradient(to bottom, #27ae60, #2ecc71);" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 18px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 25;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0.5, 0, 2);" +
            "-fx-cursor: hand;"
        );

        // Анимация при наведении
        playButton.setOnMouseEntered(e -> {
            TranslateTransition transition = new TranslateTransition(Duration.millis(200), playButton);
            transition.setToY(-3);
            transition.play();
            playButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #2ecc71, #3498db);" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 25;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 15, 0.5, 0, 3);" +
                "-fx-cursor: hand;"
            );
        });

        playButton.setOnMouseExited(e -> {
            TranslateTransition transition = new TranslateTransition(Duration.millis(200), playButton);
            transition.setToY(0);
            transition.play();
            playButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #27ae60, #2ecc71);" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 25;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0.5, 0, 2);" +
                "-fx-cursor: hand;"
            );
        });

        playButton.setOnAction(e -> handlePlayClick());

        // Дополнительные кнопки
        HBox settingsBox = new HBox(15);
        settingsBox.setAlignment(Pos.CENTER);

        Button settingsButton = createStyledButton("⚙ Настройки");
        Button modsButton = createStyledButton("📦 Моды");
        Button skinsButton = createStyledButton("👤 Скины");

        settingsBox.getChildren().addAll(settingsButton, modsButton, skinsButton);

        bottomBox.getChildren().addAll(playButton, settingsBox);
        return bottomBox;
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.1);" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 12px;" +
            "-fx-background-radius: 15;" +
            "-fx-border-color: rgba(255, 255, 255, 0.2);" +
            "-fx-border-radius: 15;" +
            "-fx-padding: 8 20;" +
            "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e -> 
            button.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.2);" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-background-radius: 15;" +
                "-fx-border-color: rgba(255, 255, 255, 0.4);" +
                "-fx-border-radius: 15;" +
                "-fx-padding: 8 20;" +
                "-fx-cursor: hand;"
            )
        );

        button.setOnMouseExited(e -> 
            button.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.1);" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-background-radius: 15;" +
                "-fx-border-color: rgba(255, 255, 255, 0.2);" +
                "-fx-border-radius: 15;" +
                "-fx-padding: 8 20;" +
                "-fx-cursor: hand;"
            )
        );

        return button;
    }

    private void handlePlayClick() {
        String selectedVersion = versionComboBox.getValue();
        statusLabel.setText("Запуск версии: " + selectedVersion);
        statusLabel.setStyle("-fx-text-fill: #f39c12; -fx-font-size: 12px;");
        
        playButton.setDisable(true);
        playButton.setText("⏳ ЗАПУСК...");
        
        progressBar.setVisible(true);
        
        // Симуляция процесса запуска
        launcherManager.launchGame(selectedVersion, new com.launcher.core.LaunchProgress() {
            @Override
            public void updateProgress(double progress, String message) {
                progressBar.setProgress(progress);
                statusLabel.setText(message);
            }

            @Override
            public void onComplete() {
                playButton.setDisable(false);
                playButton.setText("▶ ИГРАТЬ");
                progressBar.setVisible(false);
                statusLabel.setText("Игра запущена!");
                statusLabel.setStyle("-fx-text-fill: #2ecc71; -fx-font-size: 12px;");
            }

            @Override
            public void onError(String error) {
                playButton.setDisable(false);
                playButton.setText("▶ ИГРАТЬ");
                progressBar.setVisible(false);
                statusLabel.setText("Ошибка: " + error);
                statusLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-size: 12px;");
            }
        });
    }

    public VBox getRoot() {
        return (VBox) root.getCenter(); // Возвращаем основной контейнер
    }
}
