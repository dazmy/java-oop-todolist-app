package service;

import entity.Todolist;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {
    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        Todolist[] model = todoListRepository.getAll();
        System.out.println("--- TODOLIST ---");

        for (int i = 0; i < model.length; i++) {
            Todolist todo = model[i];
            int no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo.getTodolist());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        todoListRepository.add(new Todolist(todo));
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if (!success) System.out.println("Gagal menghapus todolist ke " + number);
    }
}
