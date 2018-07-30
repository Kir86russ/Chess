package ru.job4j.chess.firuges;

public interface Figure {


    String getColor();   //  возращает цвет фигуры
    Cell getPosition(); //  возращает текующую клетку, которую фигура заниает
    void setPosition(Cell cell);

    Cell[] way(Cell source, Cell dest, Figure[] figures);    /*     way() проверяет,что фигура может так двигаться,
                                                                    если да,то возращает массив клеток по которым пойдет,
                                                                     не смотрит, есть ли на пути преграды */




    default String icon() { // сложная фигня для присвоения картинок фигурок
        return String.format("%s.png", getClass().getSimpleName());

    }

    Figure copy(Cell dest); // делает клон фигуры, делает новую фигуру и перезаписывает массив

}
