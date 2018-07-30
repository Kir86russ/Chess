package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class KingBlack implements Figure {
    private String color = "black";
    private Cell position;

    public KingBlack(final Cell position) {
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
        Cell[] steps = new Cell[]{dest};

        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}
