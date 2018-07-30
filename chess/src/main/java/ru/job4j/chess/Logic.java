package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.KingBlack;
import ru.job4j.chess.firuges.white.KingWhite;


public class Logic {

    public static boolean isShah = false;

    public static int count = 0; //////// хз че тварю


    private final Figure[] figures = new Figure[32]; // массив всех фигур на доске (32 штук)
    private int index = 0; // для метода add

    public void add(Figure figure) {
        figures[index++] = figure; // ??????? ++
    }

    public boolean move(Cell source, Cell dest) {
        System.out.println(count);
        System.out.println(isShah);
        boolean result = false;
        int index = findBy(source);
        if (index != -1) {

            if (isShah && figures[index].getClass() != KingWhite.class){
                System.out.println("ШАХ, ХОДИ КОРОЛЕМ");
                return false;
            }

            if (count % 2 == 0 && figures[index].getColor() == "white") {
                count++;
                Cell[] steps = figures[index].way(source, dest, figures);// тут steps = { dest }
                if (steps.length > 0) {                                 // && steps[steps.length - 1].equals(dest))
                    result = true;
                    figures[index] = figures[index].copy(dest); // перезаписал массив, учтя перемещение фигуры
                }

            }

            if (count % 2 != 0 && figures[index].getColor() == "black") {
                count++;
                Cell[] steps = figures[index].way(source, dest, figures);// тут steps = { dest }
                if (steps.length > 0) {                                 // && steps[steps.length - 1].equals(dest))
                    result = true;
                    figures[index] = figures[index].copy(dest); // перезаписал массив, учтя перемещение фигуры
                }

            }




        }
        return result;
    }


    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }


    private int findBy(Cell cell) {
        int result = -1;
        for (int index = 0; index != figures.length; index++) {
            if (figures[index] != null && figures[index].getPosition().equals(cell)) {
                result = index;
                break;
            }
        }
        return result;
    }
}
