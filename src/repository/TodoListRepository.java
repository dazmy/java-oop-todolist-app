package repository;

import entity.Todolist;

public interface TodoListRepository {
    Todolist[] getAll();

    void add(Todolist todo);

    boolean remove(Integer number);
}
