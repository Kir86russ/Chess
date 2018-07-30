package ru.job4j.chess.firuges.white;


import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.*;


public class KingWhite implements Figure {

    private String color = "white";
    private Cell position;

    @Override
    public void setPosition(Cell position) {
        this.position = position;
    }

    public KingWhite(final Cell position) {
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


    // ПРОВЕРЯЕТ НАЛИЧИЕ АТАКИ ПЕРЕД ШАГОМ ВВЕРХ ТОЛЬКО ОТ КОНЯ, СЛОНА (ПРАВАЯ ВЕРХНЯЯ ДИАГ), ФЕРЗЬ (КАК СЛОН), лАДЛЬЯ ТОЖЕ работает, но есть баг
    // 1) баг! при одновременноЙ АТАКЕ ОТ ФЕРЗЯ И ЛАДЬИ
    // 2) баг! ладья/король
    private boolean checkAttack1(Cell cell, Figure[] figures) {


        for (int i = 0; i != figures.length; i++) {

            // * конь ниже *//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;


            // Слон/ферзь нижу
            /* этот if ниже есть */
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            /* ниже if вроде норм */
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {

                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }
            /* ниже норм */
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* ниже вроде норм */
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* nizhe norm */
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* blabla */
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            ///// выше верхняя правая диаг.


            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }               // выше верхняя левая диаг проверка на атаку от  слона и ферзя [вроде норм]
//
//
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class)) // +
                return true;
//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }

//
            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }                ///// выше нижняя правая диаг для слона и ферзя проверка атаки на белого короля на 1 шаг вперед
//
//
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class && figures[i].getClass() == KingBlack.class))
                return true;
//
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }       //// выше нижняя левая диагональ слона ферзя , для проверки короля на ШАГ ВПЕРЕД (ВВЕРХ)


            // ниже проверка на ладью и ферзя и короля справа при ходе короля белого вверх на 1 клетку (КРЕСТ ТИПО ПОЛУЧАЕТСЯ)


            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }    ////// правая горизонталь Ладья/ферзь нападет!


            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;


            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                  ////// левая горизонталь ладья\ферзь ОТСЮДА скобки ставить!

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {

                        return false;
                    }
                }

                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                   /////// вертикальная прямая ладья/ферзь


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class))
                return true;


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y)) {
                        return false;
                    }
                }
                return true;
            } /////// вертикалка вниз ферзь\ладья


            // ниже проверка на атаку от двух пешек на шаг вперед от белого короля (вроде норм)
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
        }


        return false;
    }

    private boolean checkAttack2(Cell cell, Figure[] figures) {


        for (int i = 0; i != figures.length; i++) {

            // * конь ниже *//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;


            // Слон/ферзь нижe
            /* этот if ниже есть */
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            /* ниже if вроде норм */
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {

                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }
            /* ниже норм */
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* ниже вроде норм */
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* nizhe norm */
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* blabla */
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            ///// выше верхняя правая диаг.


            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }               // выше верхняя левая диаг проверка на атаку от  слона и ферзя [вроде норм]
//
//
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class)) // +
                return true;
//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }

//
            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }                ///// выше нижняя правая диаг для слона и ферзя проверка атаки на белого короля на 1 шаг вперед
//
//
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class && figures[i].getClass() == KingBlack.class))
                return true;
//
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }       //// выше нижняя левая диагональ слона ферзя , для проверки короля на ШАГ ВПЕРЕД (ВВЕРХ)


            // ниже проверка на ладью и ферзя и короля справа при ходе короля белого вверх на 1 клетку (КРЕСТ ТИПО ПОЛУЧАЕТСЯ)


            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }    ////// правая горизонталь Ладья/ферзь нападет!


            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;


            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                  ////// левая горизонталь ладья\ферзь ОТСЮДА скобки ставить!


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y)) {

                        return false;
                    }
                }

                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                   /////// вертикальная прямая ладья/ферзь


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y)) {
                        return false;
                    }
                }
                return true;
            } /////// вертикалка вниз ферзь\ладья


            // ниже проверка на атаку от двух пешек на шаг вперед от белого короля (вроде норм)
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
        }


        return false;
    }

    private boolean checkAttack3(Cell cell, Figure[] figures) {


        for (int i = 0; i != figures.length; i++) {

            // * конь ниже *//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;


            // Слон/ферзь нижe
            /* этот if ниже есть */
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            /* ниже if вроде норм */
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {

                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }
            /* ниже норм */
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* ниже вроде норм */
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* nizhe norm */
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* blabla */
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            ///// выше верхняя правая диаг.


            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }               // выше верхняя левая диаг проверка на атаку от  слона и ферзя [вроде норм]
//
//
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class)) // +
                return true;
//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }

//
            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }                ///// выше нижняя правая диаг для слона и ферзя проверка атаки на белого короля на 1 шаг вперед
//
//
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class && figures[i].getClass() == KingBlack.class))
                return true;
//
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }       //// выше нижняя левая диагональ слона ферзя , для проверки короля на ШАГ ВПЕРЕД (ВВЕРХ)


            // ниже проверка на ладью и ферзя и короля справа при ходе короля белого вверх на 1 клетку (КРЕСТ ТИПО ПОЛУЧАЕТСЯ)

            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                return true;
            }

            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }    ////// правая горизонталь Ладья/ферзь нападет!


            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;


            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                  ////// левая горизонталь ладья\ферзь ОТСЮДА скобки ставить!

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class)) {
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                   /////// вертикальная прямая ладья/ферзь


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            } /////// вертикалка вниз ферзь\ладья


            // ниже проверка на атаку от двух пешек на шаг вперед от белого короля (вроде норм)
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
        }


        return false;
    }

    private boolean checkAttack4(Cell cell, Figure[] figures) {


        for (int i = 0; i != figures.length; i++) {

            // * конь ниже *//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;


            // Слон/ферзь нижe
            /* этот if ниже есть */
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            /* ниже if вроде норм */
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {

                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }
            /* ниже норм */
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* ниже вроде норм */
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* nizhe norm */
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* blabla */
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            ///// выше верхняя правая диаг.


            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }               // выше верхняя левая диаг проверка на атаку от  слона и ферзя [вроде норм]
//
//
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class)) // +
                return true;
//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }

//
            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }                ///// выше нижняя правая диаг для слона и ферзя проверка атаки на белого короля на 1 шаг вперед
//
//
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class && figures[i].getClass() == KingBlack.class))
                return true;
//
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }       //// выше нижняя левая диагональ слона ферзя , для проверки короля на ШАГ ВПЕРЕД (ВВЕРХ)


            // ниже проверка на ладью и ферзя и короля справа при ходе короля белого вверх на 1 клетку (КРЕСТ ТИПО ПОЛУЧАЕТСЯ)

            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class)) {
                return true;
            }

            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }    ////// правая горизонталь Ладья/ферзь нападет!


            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                  ////// левая горизонталь ладья\ферзь ОТСЮДА скобки ставить!

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class)) {
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                   /////// вертикальная прямая ладья/ферзь


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            } /////// вертикалка вниз ферзь\ладья


            // ниже проверка на атаку от двух пешек на шаг вперед от белого короля (вроде норм)
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
        }


        return false;
    }

    private boolean checkAttack5(Cell cell, Figure[] figures) {


        for (int i = 0; i != figures.length; i++) {

            // * конь ниже *//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;


            // Слон/ферзь нижу
            /* этот if ниже есть */
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            /* ниже if вроде норм */
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {

                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }
            /* ниже норм */
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* ниже вроде норм */
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* nizhe norm */
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* blabla */
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            ///// выше верхняя правая диаг.


            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }               // выше верхняя левая диаг проверка на атаку от  слона и ферзя [вроде норм]
//
//
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class)) // +
                return true;
//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }

//
            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }                ///// выше нижняя правая диаг для слона и ферзя проверка атаки на белого короля на 1 шаг вперед
//
//
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                return true;
            }
//
            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }       //// выше нижняя левая диагональ слона ферзя , для проверки короля на ШАГ ВПЕРЕД (ВВЕРХ)


            // ниже проверка на ладью и ферзя и короля справа при ходе короля белого вверх на 1 клетку (КРЕСТ ТИПО ПОЛУЧАЕТСЯ)


            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }    ////// правая горизонталь Ладья/ферзь нападет!


            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;


            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                  ////// левая горизонталь ладья\ферзь ОТСЮДА скобки ставить!

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {

                        return false;
                    }
                }

                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                   /////// вертикальная прямая ладья/ферзь


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            } /////// вертикалка вниз ферзь\ладья


            // ниже проверка на атаку от двух пешек на шаг вперед от белого короля (вроде норм)
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
        }


        return false;
    }

    private boolean checkAttack6(Cell cell, Figure[] figures) {


        for (int i = 0; i != figures.length; i++) {

            // * конь ниже *//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;


            // Слон/ферзь нижу
            /* этот if ниже есть */
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            /* ниже if вроде норм */
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {

                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }
            /* ниже норм */
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* ниже вроде норм */
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* nizhe norm */
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* blabla */
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            ///// выше верхняя правая диаг.


            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }               // выше верхняя левая диаг проверка на атаку от  слона и ферзя [вроде норм]
//
//
//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                return true;
            }
//
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }

//
            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }                ///// выше нижняя правая диаг для слона и ферзя проверка атаки на белого короля на 1 шаг вперед
//
//
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class && figures[i].getClass() == KingBlack.class))
                return true;
//
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }       //// выше нижняя левая диагональ слона ферзя , для проверки короля на ШАГ ВПЕРЕД (ВВЕРХ)


            // ниже проверка на ладью и ферзя и короля справа при ходе короля белого вверх на 1 клетку (КРЕСТ ТИПО ПОЛУЧАЕТСЯ)


            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }    ////// правая горизонталь Ладья/ферзь нападет!


            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;


            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                  ////// левая горизонталь ладья\ферзь ОТСЮДА скобки ставить!

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {

                        return false;
                    }
                }

                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                   /////// вертикальная прямая ладья/ферзь


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            } /////// вертикалка вниз ферзь\ладья


            // ниже проверка на атаку от двух пешек на шаг вперед от белого короля (вроде норм)
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
        }


        return false;
    }

    private boolean checkAttack7(Cell cell, Figure[] figures) {


        for (int i = 0; i != figures.length; i++) {

            // * конь ниже *//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;


            // Слон/ферзь нижу
            /* этот if ниже есть */
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            /* ниже if вроде норм */
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {

                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }
            /* ниже норм */
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* ниже вроде норм */
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* nizhe norm */
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* blabla */
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            ///// выше верхняя правая диаг.

            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }               // выше верхняя левая диаг проверка на атаку от  слона и ферзя [вроде норм]
//
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class)) {
                return true;
            }
//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }

//
            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }                ///// выше нижняя правая диаг для слона и ферзя проверка атаки на белого короля на 1 шаг вперед
//
//
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class && figures[i].getClass() == KingBlack.class))
                return true;
//
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }       //// выше нижняя левая диагональ слона ферзя , для проверки короля на ШАГ ВПЕРЕД (ВВЕРХ)


            // ниже проверка на ладью и ферзя и короля справа при ходе короля белого вверх на 1 клетку (КРЕСТ ТИПО ПОЛУЧАЕТСЯ)


            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }    ////// правая горизонталь Ладья/ферзь нападет!


            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;


            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                  ////// левая горизонталь ладья\ферзь ОТСЮДА скобки ставить!

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {

                        return false;
                    }
                }

                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                   /////// вертикальная прямая ладья/ферзь


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            } /////// вертикалка вниз ферзь\ладья


            // ниже проверка на атаку от двух пешек на шаг вперед от белого короля (вроде норм)
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
        }


        return false;
    }

    private boolean checkAttack8(Cell cell, Figure[] figures) {


        for (int i = 0; i != figures.length; i++) {

            // * конь ниже *//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 2 == cell.y && figures[i].getClass() == KnightBlack.class)
                return true;


            // Слон/ферзь нижу


            /* ниже if вроде норм */
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                return true;
            }

            /* ниже норм */
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* ниже вроде норм */
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* nizhe norm */
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            /* blabla */
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }

            ///// выше верхняя правая диаг.

            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class)) {
                return true;
            }

            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y + 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y + 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y + 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y + 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y + 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y + 1)) {
                        return false;
                    }
                }
                return true;
            }               // выше верхняя левая диаг проверка на атаку от  слона и ферзя [вроде норм]
//
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class)) {
                return true;
            }
//
            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }

//
            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x - 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x - 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x - 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x - 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x - 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x - 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }                ///// выше нижняя правая диаг для слона и ферзя проверка атаки на белого короля на 1 шаг вперед
//
//
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class && figures[i].getClass() == KingBlack.class))
                return true;
//
            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1) {
                        return false;
                    }
                }
                return true;
            }
//
            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }
//
//
            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == BishopBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == figures[i].getPosition().x + 6 && figures[k].getPosition().y == figures[i].getPosition().y - 6) || (figures[k].getPosition().x == figures[i].getPosition().x + 5 && figures[k].getPosition().y == figures[i].getPosition().y - 5) || (figures[k].getPosition().x == figures[i].getPosition().x + 4 && figures[k].getPosition().y == figures[i].getPosition().y - 4) || (figures[k].getPosition().x == figures[i].getPosition().x + 3 && figures[k].getPosition().y == figures[i].getPosition().y - 3) || (figures[k].getPosition().x == figures[i].getPosition().x + 2 && figures[k].getPosition().y == figures[i].getPosition().y - 2) || (figures[k].getPosition().x == figures[i].getPosition().x + 1 && figures[k].getPosition().y == figures[i].getPosition().y - 1)) {
                        return false;
                    }
                }
                return true;
            }       //// выше нижняя левая диагональ слона ферзя , для проверки короля на ШАГ ВПЕРЕД (ВВЕРХ)


            // ниже проверка на ладью и ферзя и короля справа при ходе короля белого вверх на 1 клетку (КРЕСТ ТИПО ПОЛУЧАЕТСЯ)


            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x - 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x - 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x + 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x + 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }    ////// правая горизонталь Ладья/ферзь нападет!


            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;


            if (figures[i].getPosition().x + 2 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 3 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 4 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 5 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 6 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x + 7 == cell.x && figures[i].getPosition().y == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x - 6 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 5 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 4 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 3 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 2 && figures[k].getPosition().y == cell.y) || (figures[k].getPosition().x == cell.x - 1 && figures[k].getPosition().y == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                  ////// левая горизонталь ладья\ферзь ОТСЮДА скобки ставить!

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 1 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {

                        return false;
                    }
                }

                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y + 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y + 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }                   /////// вертикальная прямая ладья/ферзь


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 1 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class || figures[i].getClass() == KingBlack.class))
                return true;

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 2 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y) {
                        return false;
                    }
                }
                return true;
            }


            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 3 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 4 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 5 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 6 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            }

            if (figures[i].getPosition().x == cell.x && figures[i].getPosition().y - 7 == cell.y && (figures[i].getClass() == RookBlack.class || figures[i].getClass() == QueenBlack.class)) {
                for (int k = 0; k != figures.length; k++) {
                    if ((figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 6 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 5 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 4 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 3 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 2 == cell.y) || (figures[k].getPosition().x == cell.x && figures[k].getPosition().y - 1 == cell.y)) {
                        return false;
                    }
                }
                return true;
            } /////// вертикалка вниз ферзь\ладья


            // ниже проверка на атаку от двух пешек на шаг вперед от белого короля (вроде норм)
            if (figures[i].getPosition().x - 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
            if (figures[i].getPosition().x + 1 == cell.x && figures[i].getPosition().y - 1 == cell.y && figures[i].getClass() == PawnBlack.class)
                return true;
        }


        return false;
    }


    @Override
    public Cell[] way(Cell source, Cell dest, Figure[] figures) {
        Cell[] steps = new Cell[0];

        //010
        //0x0
        //000
        if (source.x == dest.x && source.y == dest.y + 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    if (!checkAttack1(dest, figures)) { // если false то
                        figures[i].setPosition(Cell.X);
                        steps = new Cell[]{dest};
                    }
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    return steps;
                }
            }
            if (!checkAttack1(dest, figures))
                steps = new Cell[]{dest};
        }


        //000
        //0x0
        //010
        if (source.x == dest.x && source.y == dest.y - 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    if (!checkAttack2(dest, figures)) {
                        figures[i].setPosition(Cell.X);
                        steps = new Cell[]{dest};
                    }
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    return steps;
                }
            }
            if (!checkAttack2(dest, figures))
                steps = new Cell[]{dest};
        }

        //000
        //1x0
        //000
        if (source.x == dest.x + 1 && source.y == dest.y) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    if (!checkAttack3(dest, figures)) {
                        figures[i].setPosition(Cell.X);
                        steps = new Cell[]{dest};
                    }
                }
                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    return steps;
                }
            }
            if (!checkAttack3(dest, figures))
                steps = new Cell[]{dest};

        }

        //000
        //0x1
        //000
        if (source.x == dest.x - 1 && source.y == dest.y) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    if (!checkAttack4(dest, figures)) {
                        figures[i].setPosition(Cell.X);
                        steps = new Cell[]{dest};
                    }
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    return steps;
                }
            }
            if (!checkAttack4(dest, figures))
                steps = new Cell[]{dest};
        }                                                   // krest UP


        //001
        //0x0
        //000
        if (source.x == dest.x - 1 && source.y == dest.y + 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    if (!checkAttack5(dest, figures)) {
                        figures[i].setPosition(Cell.X);
                        steps = new Cell[]{dest};
                    }
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    return steps;
                }
            }
            if (!checkAttack5(dest, figures))
                steps = new Cell[]{dest};
        }

        //100
        //0x0
        //000
        if (source.x == dest.x + 1 && source.y == dest.y + 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    if (!checkAttack6(dest, figures)) {
                        figures[i].setPosition(Cell.X);
                        steps = new Cell[]{dest};
                    }
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    return steps;
                }
            }
            if (!checkAttack6(dest, figures))
                steps = new Cell[]{dest};
        }


        //000
        //0x0
        //001
        if (source.x == dest.x - 1 && source.y == dest.y - 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    if (!checkAttack7(dest, figures)) {
                        figures[i].setPosition(Cell.X);
                        steps = new Cell[]{dest};
                    }
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    return steps;
                }
            }
            if (!checkAttack7(dest, figures))
                steps = new Cell[]{dest};
        }

        //000
        //0x0
        //100
        if (source.x == dest.x + 1 && source.y == dest.y - 1) {
            for (int i = 0; i != figures.length; i++) {
                if (figures[i].getPosition() == dest && figures[i].getColor() == "black") {
                    if (!checkAttack8(dest, figures)) {
                        figures[i].setPosition(Cell.X);
                        steps = new Cell[]{dest};
                    }
                }

                if (figures[i].getPosition() == dest && figures[i].getColor() == "white") {
                    return steps;
                }
            }
            if (!checkAttack8(dest, figures))
                steps = new Cell[]{dest};
        }                       // diagonal UP


        Logic.isShah = false;
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}
