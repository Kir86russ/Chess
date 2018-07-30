package ru.job4j.chess.firuges.black;


import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.white.KingWhite;


public class PawnBlack implements Figure {

    private String color = "black";
    private Cell position;


    public PawnBlack(Cell position) { // констурктор, принимает нашу позицию
        this.position = position;
    }


    @Override
    public String getColor(){
        return color;
    }

    @Override
    public Cell getPosition() { // геттер для поля position
        return position;
    }

    @Override
    public void setPosition(Cell position) {
        this.position = position;
    }

    private boolean checkShah(Cell cell, Figure[] figures) {

        for (int i = 0; i != figures.length; i++) {
            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 1 == cell.y) {
                System.out.println("LALALA");
                return true;
            }

            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 1 == cell.y)
                return true;
        }

        return false;
    }

    @Override
    public Cell[] way(Cell source, Cell dest, Figure[] figures) {
        Cell[] steps = new Cell[0];                                          // нулевой массив. просто нужен (типо объявили так)


        if (source.y == dest.y + 1 && source.x == dest.x) { // самое стандарное на 1 клетку в передвижение
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest) {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.y == 6 && source.y == dest.y + 2 && source.x == dest.x) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest || figures[i].getPosition().y == dest.y + 1) {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.y == dest.y + 1 && source.x == dest.x - 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {

                    figures[i].setPosition(Cell.X);

                    steps = new Cell[]{dest};

                }
            }
        }

        if (source.y == dest.y + 1 && source.x == dest.x + 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {

                    figures[i].setPosition(Cell.X);

                    steps = new Cell[]{dest};

                }
            }
        }
        if (checkShah(dest, figures)){
            Logic.isShah = true;
        }
        return steps;
    }


    @Override
    public Figure copy(Cell dest) { // создает новый объект пешки с новым значением dest
        return new PawnBlack(dest);
    }


}
