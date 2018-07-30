package ru.job4j.chess;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;

import java.util.ArrayList;

public class Chess extends Application {



    private final int size = 8;
    private final Logic logic = new Logic();
    private Group grid;
    ArrayList<superRectangle> list = new ArrayList<>();

    private Rectangle buildRectangle(int x, int y, int size, boolean white) {
        Rectangle rect = new Rectangle();
        rect.setX(x * size);
        rect.setY(y * size);
        rect.setHeight(size);
        rect.setWidth(size);
        if (white) {
            rect.setFill(Color.WHITE);
        } else {
            rect.setFill(Color.GRAY);
        }
        rect.setStroke(Color.BLACK);
        return rect;
    }


    class superRectangle extends Rectangle {

        private boolean flag = false;

        public boolean getFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        superRectangle() {
            super();
        }

    }

    private Rectangle buildFigure(int x, int y, int size, String image) {


        superRectangle rect = new superRectangle();

        rect.setX(x);
        rect.setY(y);
        rect.setHeight(size);
        rect.setWidth(size);
        Image img = new Image(this.getClass().getClassLoader().getResource(image).toString());
        rect.setFill(new ImagePattern(img));

        list.add(rect);
        final Rectangle momento = new Rectangle(x, y);
        rect.setOnDragDetected(
                event -> {
                    momento.setX(event.getX());
                    momento.setY(event.getY());
                }
        );
        rect.setOnMouseDragged(
                event -> {
                    rect.setX(event.getX() - size / 2); //  -size/2 для того чтобы при самом перетаскивании она красиво была на курсоре
                    rect.setY(event.getY() - size / 2); //  -size/2 для того чтобы при самом перетаскивании она красиво была на курсоре
                }
        );
        rect.setOnMouseReleased(
                event -> {               //   ((((((((SOURCE)))))                     ((((((DEST)))))
                    if (logic.move(findBy(momento.getX(), momento.getY()), findBy(event.getX(), event.getY()))) {


                        rect.setX(((int) event.getX() / 40) * 40 + 5);
                        rect.setY(((int) event.getY() / 40) * 40 + 5);
                        rect.setFlag(true);

                        for (int i = 0; i != list.size(); i++) {


                            if (list.get(i).getX() == (double) findBy(event.getX(), event.getY()).x * 40 + 5 && list.get(i).getY() == (double) findBy(event.getX(), event.getY()).y * 40 + 5 && !list.get(i).getFlag()) {
                                grid.getChildren().remove(list.get(i));
                            }


                        }

                        rect.setFlag(false);


                    } else {
                        rect.setX(((int) momento.getX() / 40) * 40 + 5);
                        rect.setY(((int) momento.getY() / 40) * 40 + 5);
                    }
                }
        );

        return rect;
    }


    private Group buildGrid() { // строит доску
        Group panel = new Group();
        for (int y = 0; y != size; y++) {
            for (int x = 0; x != size; x++) {
                panel.getChildren().add(
                        buildRectangle(x, y, 40, (x + y) % 2 == 0)
                );
            }
        }
        return panel;
    }

    @Override
    public void start(Stage stage) {
        BorderPane border = new BorderPane();
        HBox control = new HBox();
        control.setPrefHeight(40);
        control.setSpacing(10.0); // не влияет походу
        control.setAlignment(Pos.BASELINE_CENTER); // выравнивает кнопку по центру
        Button start = new Button("Реванш");
        start.setOnMouseClicked(
                event -> refresh(border)
        );
        control.getChildren().addAll(start);
        border.setBottom(control);
        border.setCenter(buildGrid());
        stage.setScene(new Scene(border, 400, 400));
        stage.setTitle("Шахматы");
        stage.setResizable(false);
        stage.show();
        refresh(border); // появляются все фигуры
    }

    private void refresh(BorderPane border) {
        grid = buildGrid();
        logic.clean();
        border.setCenter(grid);
        buildWhiteTeam(grid);
        buildBlackTeam(grid);
        Logic.isShah = false;
        Logic.count = 0;
    }

    private void buildBlackTeam(Group grid) {
        this.add(new PawnBlack(Cell.A7), grid);
        this.add(new PawnBlack(Cell.B7), grid);
        this.add(new PawnBlack(Cell.C7), grid);
        this.add(new PawnBlack(Cell.D7), grid);
        this.add(new PawnBlack(Cell.E7), grid);
        this.add(new PawnBlack(Cell.F7), grid);
        this.add(new PawnBlack(Cell.G7), grid);
        this.add(new PawnBlack(Cell.H7), grid);
        this.add(new RookBlack(Cell.A8), grid);
        this.add(new KnightBlack(Cell.B8), grid);
        this.add(new BishopBlack(Cell.C8), grid);
        this.add(new QueenBlack(Cell.D8), grid);
        this.add(new KingBlack(Cell.E8), grid);
        this.add(new BishopBlack(Cell.F8), grid);
        this.add(new KnightBlack(Cell.G8), grid);
        this.add(new RookBlack(Cell.H8), grid);
    }

    private void buildWhiteTeam(Group grid) {
        this.add(new PawnWhite(Cell.A2), grid);
        this.add(new PawnWhite(Cell.B2), grid);
        this.add(new PawnWhite(Cell.C2), grid);
        this.add(new PawnWhite(Cell.D2), grid);
        this.add(new PawnWhite(Cell.E2), grid);
        this.add(new PawnWhite(Cell.F2), grid);
        this.add(new PawnWhite(Cell.G2), grid);
        this.add(new PawnWhite(Cell.H2), grid);
        this.add(new RookWhite(Cell.A1), grid);
        this.add(new KnightWhite(Cell.B1), grid);
        this.add(new BishopWhite(Cell.C1), grid);
        this.add(new QueenWhite(Cell.D1), grid);
        this.add(new KingWhite(Cell.E1), grid);
        this.add(new BishopWhite(Cell.F1), grid);
        this.add(new KnightWhite(Cell.G1), grid);
        this.add(new RookWhite(Cell.H1), grid);
    }


    private void add(Figure figure, Group grid) {
        logic.add(figure); // неважно при удалении с доски
        Cell position = figure.getPosition();
        grid.getChildren().add(
                buildFigure( //
                        position.x * 40 + 5, position.y * 40 + 5, 30, figure.icon()  // (5, 245) , size = 30 , image
                )                                                                   //  (x, y)
        );
    }

    private Cell findBy(double graphX, double graphY) {  // возращает Cell как в перечислении , НЕ КАК НА ДОСКЕ!

        Cell result = Cell.A1;
        int x = (int) graphX / 40;
        int y = (int) graphY / 40;

        for (Cell cell : Cell.values()) {
            if (cell.x == x && cell.y == y) {
                result = cell;
                break;
            }
        }
        return result;
    }
}
