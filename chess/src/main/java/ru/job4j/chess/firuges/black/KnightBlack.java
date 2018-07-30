package ru.job4j.chess.firuges.black;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.white.KingWhite;

public class KnightBlack implements Figure {
    private String color = "black";
    private Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public void setPosition(Cell position) {
        this.position = position;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Cell getPosition() {
        return this.position;
    }



    private boolean checkShah(Cell cell, Figure[] figures) {

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 2 == cell.y)
                    return true;

                if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 2 == cell.y)
                    return true;

                if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 1 == cell.y)
                    return true;

                if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 1 == cell.y)
                    return true;

                if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 1 == cell.y)
                    return true;

                if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 1 == cell.y)
                    return true;

                if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 2 == cell.y)
                    return true;

                if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 2 == cell.y)
                    return true;
            }

            return false;
    }

    @Override
    public Cell[] way(Cell source, Cell dest, Figure[] figures) {
        Cell[] steps = new Cell[0];

        if (source.x == dest.x - 1 && source.y == dest.y + 2) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 1 && source.y == dest.y + 2) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x - 2 && source.y == dest.y + 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 2 && source.y == dest.y + 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x - 2 && source.y == dest.y - 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};


        }

        if (source.x == dest.x + 2 && source.y == dest.y - 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x - 1 && source.y == dest.y - 2) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 1 && source.y == dest.y - 2) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (checkShah(dest, figures)){
            Logic.isShah = true;
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
