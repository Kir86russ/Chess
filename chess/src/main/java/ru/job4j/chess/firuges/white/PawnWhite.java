package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;


public class PawnWhite implements Figure {
    private String color = "white";
    private Cell position;

    public PawnWhite(Cell position) {
        this.position = position;
    }


    @Override
    public void setPosition(Cell position) {
        this.position = position;
    }
    @Override
    public String getColor(){
        return color;
    }

    @Override
    public Cell getPosition() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest, Figure[] figures) {
        Cell[] steps = new Cell[0];                   //    нулевой массив. просто нужен (типо объявили так)
        if ((source.y == dest.y - 1 && source.x == dest.x) || (source.y == 1 && source.y == dest.y - 2 && source.x == dest.x)) {
            steps = new Cell[] { dest };
        }
        return steps; // возращает массиив (список шагов для хода)
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
