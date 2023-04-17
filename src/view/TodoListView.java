package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        while (true) {
            todoListService.showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah TodoList");
            System.out.println("2. Hapus TodoList");
            System.out.println("x. Keluar Aplikasi");

            String input = InputUtil.input("Pilih");
            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Maaf, pilihan tidak tersedia");
            }
        }
    }

    public void addTodoList() {
        System.out.println("--- TAMBAH TODOLIST ---");

        String todo = InputUtil.input("Todo (x jika batal)");
        if (todo.equals("x")) {
            // batal dan kembali ke showTodoList()
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("--- HAPUS TODOLIST ---");

        String number = InputUtil.input("Masukkan nomor yang ingin dihapus (x jika batal)");
        if (number.equals("x")) {
            // batal dan kembali ke showTodoList()
        } else {
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }
}
