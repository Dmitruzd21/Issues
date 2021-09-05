package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.data.Issue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {
    IssueRepository repository = new IssueRepository();
    Issue issue1 = new Issue(1, "Иван", "Катя", "Баг", true, "шшш", 17, true, false, false, false, false);
    Issue issue2 = new Issue(2, "Иван", "Катя", "Баг", false, "шшш", 14, true, false, false, false, false);
    Issue issue3 = new Issue(3, "Иван", "Катя", "Баг", true, "шшш", 20, true, false, false, false, false);
    Issue issue4 = new Issue(4, "Иван", "Катя", "Баг", true, "шшш", 20, true, false, false, false, false);
    Issue issue5 = new Issue(5, "Иван", "Катя", "Баг", true, "шшш", 20, true, false, false, false, false);
    Issue issue6 = new Issue(3, "Иван", "Катя", "Баг", true, "шшш", 20, true, false, false, false, false);

    // Проверка добавления Issue
    @Test
    void shouldAdd() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        Issue[] expected = new Issue[]{issue1, issue2, issue3};
        Issue[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    // Проверка возвращения элемента, соответсвующего индексу
    @Test
    void shouldGet() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        repository.add(issue4);
        repository.add(issue5);
        Issue[] expected = new Issue[]{issue2};
        Issue[] actual = repository.get(1);
        assertArrayEquals(expected, actual);
        // TODO
    }

    // Проверка редактирования (замена Issue c указанным индексом, на другой Issue) - индекс в пределах суммарного количества элементов коллекции
    @Test
    void shouldSetIfIndexWithinSize() throws Exception {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        repository.add(issue4);
        repository.set(1, issue5);
        Issue[] expected = new Issue[]{issue1, issue5, issue3, issue4};
        Issue[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    // Проверка редактирования (замена Issue c указанным индексом, на другой Issue) - индекс за пределами суммарного количества элементов коллекции
    @Test
    void shouldSetIfIndexOverSize() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        repository.add(issue4);
        assertThrows(RuntimeException.class, () -> {
            repository.set(7, issue5);
        });
    }

    // Проверка удаления элемента, если такой имеется
    @Test
    void shouldRemoveIfIssueExist() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        repository.remove(issue2);
        Issue[] expected = new Issue[]{issue1, issue3};
        Issue[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    // Проверка удаления элемента, если такой НЕ имеется
    @Test
    void shouldRemoveIfIssueDoesntExist() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        repository.remove(issue4);
        Issue[] expected = new Issue[]{issue1, issue2, issue3};
        Issue[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    // Проеверка удаления объекта по ID, если такого объекта нет
    @Test
    void shouldRemoveByIdIfIssueWithIdDoesntExist() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        repository.add(issue4);
        repository.removeById(5);
        Issue[] expected = new Issue[]{issue1, issue2, issue3, issue4};
        Issue[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    // Проверка удаления объекта по ID,если есть 1 объект с искоемым ID
    @Test
    void shouldRemoveByIdIfOneIssueWithIdExist() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        repository.add(issue4);
        repository.removeById(3);
        Issue[] expected = new Issue[]{issue1, issue2, issue4};
        Issue[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    // Проверка удаления объекта по ID, если есть 2 объекта с искоемым ID
    @Test
    void shouldRemoveByIdIfTwoIssuesWithIdExist() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        repository.add(issue4);
        repository.add(issue5);
        repository.add(issue3);
        repository.removeById(3);
        Issue[] expected = new Issue[]{issue1, issue2, issue4, issue5};
        Issue[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    // Проверка очистки коллекции
    @Test
    void shouldClear() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        repository.add(issue4);
        repository.add(issue5);
        repository.clear();
        Issue[] expected = new Issue[]{};
        Issue[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    // Проверка длины коллекции
    @Test
    void shouldSize() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        repository.add(issue4);
        repository.add(issue5);
        int expected = 5;
        int actual = repository.size();
        assertEquals(expected, actual);
    }

    // Проверка поиска по ID
    @Test
    void shouldFindById() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        repository.add(issue4);
        repository.add(issue5);
        Issue[] expected = new Issue[]{issue3};
        Issue[] actual = repository.findById(3);
        assertArrayEquals(expected, actual);
    }
}