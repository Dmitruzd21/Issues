package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Issue;
import ru.netology.repository.IssueRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {
    IssueRepository repository = new IssueRepository();
    IssueManager manager = new IssueManager(repository);
    Issue i1 = new Issue(1, "Иван", "Катя", "Новое решение", true, "ррр", 19, new HashSet<String>(Arrays.asList("bug")));
    Issue i2 = new Issue(2, "Евгений", "Павел", "Старое решение", false, "ррр", 20, new HashSet<String>(Arrays.asList("enhancement")));
    Issue i3 = new Issue(3, "Олег", "Игорь", "Новое решение", true, "ррр", 17, new HashSet<String>(Arrays.asList("helpWanted", "bug")));
    Issue i4 = new Issue(4, "Кирилл", "Виктор", "Новое решение", false, "ррр", 18, new HashSet<String>(Arrays.asList("question")));
    Issue i5 = new Issue(5, "Светлана", "Ирина", "Новое решение", false, "ррр", 11, new HashSet<String>(Arrays.asList("documentation", "bug")));


    @BeforeEach
    public void setUp() {
        manager.add(i1);
        manager.add(i2);
        manager.add(i3);
        manager.add(i4);
    }

    // 1. Проверка отображения списка открытых Issue
    @Test
    void shouldsearchOpenIssues() {
        Issue[] expected = new Issue[]{i1, i3};
        Issue[] actual = manager.searchOpenIssues();
        assertArrayEquals(expected, actual);
    }

    // 2. Проверка отображения списка закрытых Issue (Issue c индексом существует)
    @Test
    void shouldsearchClosedIssues() {
        Issue[] expected = new Issue[]{i2, i4};
        Issue[] actual = manager.searchClosedIssues();
        assertArrayEquals(expected, actual);
    }

    // 3. Проверка закрытия Issue по id (Issue c индексом существует)
    @Test
    void shouldCloseById() {
        manager.closeIssueById(3);
        boolean actual = i3.isOpenStatus();
        assertFalse(actual);
    }

    // 4. Проверка открытия Issue по id (Issue c индексом не существует)
    @Test
    void shouldOpenById() {
        manager.openIssueById(2);
        boolean actual = i2.isOpenStatus();
        assertTrue(actual);
    }

    // 5. Проверка фильтрации по имени автора
    @Test
    void shouldFindByAuthor() {
        Issue[] expected = new Issue[]{i3};
        Issue[] actual = manager.searchByAuthor("Олег");
        assertArrayEquals(expected, actual);
    }

    // 6. Проверка фильтрации по assignee
    @Test
    void shouldFindByAssignee() {
        Issue[] expected = new Issue[]{i4};
        Issue[] actual = manager.searchByAssignee("Виктор");
        assertArrayEquals(expected, actual);
    }

    // 7. Проверка фильтрации по Тегам
    @Test
    void shoulfsearchByTags() {
        Issue[] expected = new Issue[]{i1, i3};
        Issue[] actual = manager.searchByTags(new HashSet<String>(Arrays.asList("bug")));
        assertArrayEquals(expected, actual);
    }
}