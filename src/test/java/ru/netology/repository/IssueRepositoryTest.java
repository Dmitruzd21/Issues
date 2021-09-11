package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.data.Issue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {
    IssueRepository repository = new IssueRepository();
    Issue issue1 = new Issue(1, "Иван", "Катя", "Баг", true, "шшш", 17, new HashSet<String>(Arrays.asList("bug")));
    Issue issue2 = new Issue(2, "Иван", "Евгений", "Баг", false, "шшш", 14, new HashSet<String>(Arrays.asList("enhancement")));
    Issue issue3 = new Issue(3, "Алексей", "Катя", "Баг", true, "шшш", 20, new HashSet<String>(Arrays.asList("helpWanted", "bug")));
    Issue issue4 = new Issue(4, "Иван", "Катя", "Баг", true, "шшш", 20, new HashSet<String>(Arrays.asList("question")));
    Issue issue5 = new Issue(5, "Тамара", "Катя", "Баг", true, "шшш", 20, new HashSet<String>(Arrays.asList("documentation", "bug")));
    Issue issue6 = new Issue(3, "Иван", "Константин", "Баг", true, "шшш", 20, new HashSet<String>(Arrays.asList("bug")));

    // 1. Проверка добавления Issue
    @Test
    void shouldAdd() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);
        Issue[] expected = new Issue[]{issue1, issue2, issue3};
        Issue[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    // 2. Проверка редактирования (замена Issue c указанным индексом, на другой Issue) - индекс в пределах суммарного количества элементов коллекции
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

    // 3. Проверка редактирования (замена Issue c указанным индексом, на другой Issue) - индекс за пределами суммарного количества элементов коллекции
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

    // 4. Проверка удаления элемента, если такой имеется
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

    // 5. Проверка удаления элемента, если такой НЕ имеется
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

    // 6. Проеверка удаления объекта по ID, если такого объекта нет
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

    // 7. Проверка удаления объекта по ID,если есть 1 объект с искоемым ID
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

    // 8. Проверка удаления объекта по ID, если есть 2 объекта с искоемым ID
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

    // 9. Проверка очистки коллекции
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

    // 10. Проверка длины коллекции
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

    // 11. Проверка поиска по ID
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