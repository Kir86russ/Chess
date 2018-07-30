package ru.job4j.chess.firuges.black;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.white.KingWhite;


public class BishopBlack implements Figure {
    private String color = "black";
    private Cell position;

    public BishopBlack(final Cell position) {
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

    public boolean checkShah(Cell cell, Figure[] figures) {

        for (int i = 0; i != figures.length; i++) {
            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 1 == cell.y) // +
                return true;

            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 2 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y + 3 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y + 4 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y + 5 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y + 6 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y + 7 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            ///// выше верхняя правая диаг.


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 1 == cell.y) // +
                return true;

            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 2 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y + 3 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y + 4 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y + 5 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y + 6 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y + 7 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }               // выше верхняя левая диаг.


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y) // +
                return true;

            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 2 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y - 3 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y - 4 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y - 5 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y - 6 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y - 7 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }                ///// выше нижняя правая диаг.


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y) // +
                return true;

            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 2 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y - 3 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y - 4 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y - 5 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y - 6 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getClass() == KingWhite.class && figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y - 7 == cell.y) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }                        ///// выше левая нижняя диаг.
        }

        return false;
    }

    // вроде всё готово
    @Override
    public Cell[] way(Cell source, Cell dest, Figure[] figures) {
        Cell[] steps = new Cell[0];

        if (source.x == dest.x - 1 && source.y == dest.y + 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor().equals("white")) {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }

                if (figures[i].getPosition() == dest && figures[i].getColor().equals("black")) {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }


        if (source.x == dest.x - 2 && source.y == dest.y + 2) {

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition().x == dest.x - 1 && figures[i].getPosition().y == dest.y + 1) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }

            steps = new Cell[]{dest};
        }


        if (source.x == dest.x - 3 && source.y == dest.y + 3) {

            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x - 2 && figures[i].getPosition().y == dest.y + 2) || (figures[i].getPosition().x == dest.x - 1 && figures[i].getPosition().y == dest.y + 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x - 4 && source.y == dest.y + 4) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x - 3 && figures[i].getPosition().y == dest.y + 3) || (figures[i].getPosition().x == dest.x - 2 && figures[i].getPosition().y == dest.y + 2) || (figures[i].getPosition().x == dest.x - 1 && figures[i].getPosition().y == dest.y + 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x - 5 && source.y == dest.y + 5) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x - 4 && figures[i].getPosition().y == dest.y + 4) || (figures[i].getPosition().x == dest.x - 3 && figures[i].getPosition().y == dest.y + 3) || (figures[i].getPosition().x == dest.x - 2 && figures[i].getPosition().y == dest.y + 2) || (figures[i].getPosition().x == dest.x - 1 && figures[i].getPosition().y == dest.y + 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x - 6 && source.y == dest.y + 6) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x - 5 && figures[i].getPosition().y == dest.y + 5) || (figures[i].getPosition().x == dest.x - 4 && figures[i].getPosition().y == dest.y + 4) || (figures[i].getPosition().x == dest.x - 3 && figures[i].getPosition().y == dest.y + 3) || (figures[i].getPosition().x == dest.x - 2 && figures[i].getPosition().y == dest.y + 2) || (figures[i].getPosition().x == dest.x - 1 && figures[i].getPosition().y == dest.y + 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x - 7 && source.y == dest.y + 7) { //  правая верхнаяя диаг.
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x - 6 && figures[i].getPosition().y == dest.y + 6) || (figures[i].getPosition().x == dest.x - 5 && figures[i].getPosition().y == dest.y + 5) || (figures[i].getPosition().x == dest.x - 4 && figures[i].getPosition().y == dest.y + 4) || (figures[i].getPosition().x == dest.x - 3 && figures[i].getPosition().y == dest.y + 3) || (figures[i].getPosition().x == dest.x - 2 && figures[i].getPosition().y == dest.y + 2) || (figures[i].getPosition().x == dest.x - 1 && figures[i].getPosition().y == dest.y + 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 1 && source.y == dest.y + 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor().equals("white")) {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }

                if (figures[i].getPosition() == dest && figures[i].getColor().equals("black")) {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 2 && source.y == dest.y + 2) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition().x == dest.x + 1 && figures[i].getPosition().y == dest.y + 1) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }

            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 3 && source.y == dest.y + 3) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x + 2 && figures[i].getPosition().y == dest.y + 2) || (figures[i].getPosition().x == dest.x + 1 && figures[i].getPosition().y == dest.y + 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 4 && source.y == dest.y + 4) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x + 3 && figures[i].getPosition().y == dest.y + 3) || (figures[i].getPosition().x == dest.x + 2 && figures[i].getPosition().y == dest.y + 2) || (figures[i].getPosition().x == dest.x + 1 && figures[i].getPosition().y == dest.y + 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 5 && source.y == dest.y + 5) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x + 4 && figures[i].getPosition().y == dest.y + 4) || (figures[i].getPosition().x == dest.x + 3 && figures[i].getPosition().y == dest.y + 3) || (figures[i].getPosition().x == dest.x + 2 && figures[i].getPosition().y == dest.y + 2) || (figures[i].getPosition().x == dest.x + 1 && figures[i].getPosition().y == dest.y + 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 6 && source.y == dest.y + 6) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x + 5 && figures[i].getPosition().y == dest.y + 5) || (figures[i].getPosition().x == dest.x + 4 && figures[i].getPosition().y == dest.y + 4) || (figures[i].getPosition().x == dest.x + 3 && figures[i].getPosition().y == dest.y + 3) || (figures[i].getPosition().x == dest.x + 2 && figures[i].getPosition().y == dest.y + 2) || (figures[i].getPosition().x == dest.x + 1 && figures[i].getPosition().y == dest.y + 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 7 && source.y == dest.y + 7) { // левая верхняя диаг.
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x + 6 && figures[i].getPosition().y == dest.y + 6) || (figures[i].getPosition().x == dest.x + 5 && figures[i].getPosition().y == dest.y + 5) || (figures[i].getPosition().x == dest.x + 4 && figures[i].getPosition().y == dest.y + 4) || (figures[i].getPosition().x == dest.x + 3 && figures[i].getPosition().y == dest.y + 3) || (figures[i].getPosition().x == dest.x + 2 && figures[i].getPosition().y == dest.y + 2) || (figures[i].getPosition().x == dest.x + 1 && figures[i].getPosition().y == dest.y + 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 1 && source.y == dest.y - 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor().equals("white")) {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }

                if (figures[i].getPosition() == dest && figures[i].getColor().equals("black")) {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 2 && source.y == dest.y - 2) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition().x == dest.x + 1 && figures[i].getPosition().y == dest.y - 1) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }

            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 3 && source.y == dest.y - 3) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x + 2 && figures[i].getPosition().y == dest.y - 2) || (figures[i].getPosition().x == dest.x + 1 && figures[i].getPosition().y == dest.y - 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 4 && source.y == dest.y - 4) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x + 3 && figures[i].getPosition().y == dest.y - 3) || (figures[i].getPosition().x == dest.x + 2 && figures[i].getPosition().y == dest.y - 2) || (figures[i].getPosition().x == dest.x + 1 && figures[i].getPosition().y == dest.y - 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 5 && source.y == dest.y - 5) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x + 4 && figures[i].getPosition().y == dest.y - 4) || (figures[i].getPosition().x == dest.x + 3 && figures[i].getPosition().y == dest.y - 3) || (figures[i].getPosition().x == dest.x + 2 && figures[i].getPosition().y == dest.y - 2) || (figures[i].getPosition().x == dest.x + 1 && figures[i].getPosition().y == dest.y - 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 6 && source.y == dest.y - 6) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x + 5 && figures[i].getPosition().y == dest.y - 5) || (figures[i].getPosition().x == dest.x + 4 && figures[i].getPosition().y == dest.y - 4) || (figures[i].getPosition().x == dest.x + 3 && figures[i].getPosition().y == dest.y - 3) || (figures[i].getPosition().x == dest.x + 2 && figures[i].getPosition().y == dest.y - 2) || (figures[i].getPosition().x == dest.x + 1 && figures[i].getPosition().y == dest.y - 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x + 7 && source.y == dest.y - 7) { //  левая нижняя диаг.
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x + 6 && figures[i].getPosition().y == dest.y - 6) || (figures[i].getPosition().x == dest.x + 5 && figures[i].getPosition().y == dest.y - 5) || (figures[i].getPosition().x == dest.x + 4 && figures[i].getPosition().y == dest.y - 4) || (figures[i].getPosition().x == dest.x + 3 && figures[i].getPosition().y == dest.y - 3) || (figures[i].getPosition().x == dest.x + 2 && figures[i].getPosition().y == dest.y - 2) || (figures[i].getPosition().x == dest.x + 1 && figures[i].getPosition().y == dest.y - 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x - 1 && source.y == dest.y - 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor().equals("white")) {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }

                if (figures[i].getPosition() == dest && figures[i].getColor().equals("black")) {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x - 2 && source.y == dest.y - 2) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition().x == dest.x - 1 && figures[i].getPosition().y == dest.y - 1) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }

            steps = new Cell[]{dest};
        }

        if (source.x == dest.x - 3 && source.y == dest.y - 3) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x - 2 && figures[i].getPosition().y == dest.y - 2) || (figures[i].getPosition().x == dest.x - 1 && figures[i].getPosition().y == dest.y - 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x - 4 && source.y == dest.y - 4) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x - 3 && figures[i].getPosition().y == dest.y - 3) || (figures[i].getPosition().x == dest.x - 2 && figures[i].getPosition().y == dest.y - 2) || (figures[i].getPosition().x == dest.x - 1 && figures[i].getPosition().y == dest.y - 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }
        if (source.x == dest.x - 5 && source.y == dest.y - 5) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x - 4 && figures[i].getPosition().y == dest.y - 4) || (figures[i].getPosition().x == dest.x - 3 && figures[i].getPosition().y == dest.y - 3) || (figures[i].getPosition().x == dest.x - 2 && figures[i].getPosition().y == dest.y - 2) || (figures[i].getPosition().x == dest.x - 1 && figures[i].getPosition().y == dest.y - 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x - 6 && source.y == dest.y - 6) {
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x - 5 && figures[i].getPosition().y == dest.y - 5) || (figures[i].getPosition().x == dest.x - 4 && figures[i].getPosition().y == dest.y - 4) || (figures[i].getPosition().x == dest.x - 3 && figures[i].getPosition().y == dest.y - 3) || (figures[i].getPosition().x == dest.x - 2 && figures[i].getPosition().y == dest.y - 2) || (figures[i].getPosition().x == dest.x - 1 && figures[i].getPosition().y == dest.y - 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }

        if (source.x == dest.x - 7 && source.y == dest.y - 7) { //  нижняя правая диаг.
            for (int i = 0; i != figures.length; i++) {
                if ((figures[i].getPosition().x == dest.x - 6 && figures[i].getPosition().y == dest.y - 6) || (figures[i].getPosition().x == dest.x - 5 && figures[i].getPosition().y == dest.y - 5) || (figures[i].getPosition().x == dest.x - 4 && figures[i].getPosition().y == dest.y - 4) || (figures[i].getPosition().x == dest.x - 3 && figures[i].getPosition().y == dest.y - 3) || (figures[i].getPosition().x == dest.x - 2 && figures[i].getPosition().y == dest.y - 2) || (figures[i].getPosition().x == dest.x - 1 && figures[i].getPosition().y == dest.y - 1)) {
                    return steps;
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    figures[i].setPosition(Cell.X);
                    steps = new Cell[]{dest};
                }
            }

            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    return steps;
                }
            }
            steps = new Cell[]{dest};
        }
        if (checkShah(dest, figures)) {
            Logic.isShah = true;
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
