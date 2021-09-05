package org.treguluvcource.aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary{


    public void addBook(String  personName, Book book) {
        System.out.println("Мы добавляем книгу в UniLibrary");
        System.out.println("----------------------------------------");
    }

    public String getBook() {
        System.out.println("Мы берем книгу из UniLibrary: ");
        return "Война и мир";
    }

    public String returnBook() {
        int a = 10/0;
        System.out.println("Мы Возвращаем книку в UniLibrary");
        return "Преступление и наказание";
    }

    public void addMagazine() {
        System.out.println("Мы добавляем журнал в UniLibrary");
        System.out.println("----------------------------------------");
    }

    public void getMagazine() {
        System.out.println("Мы берем журнал из UniLibrary");
        System.out.println("----------------------------------------");
    }

    public void returnMagazine() {
        System.out.println("Мы Возвращаем журнал в UniLibrary");
        System.out.println("----------------------------------------");
    }





}
