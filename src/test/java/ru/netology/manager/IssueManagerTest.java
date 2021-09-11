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
    Issue i1 = new Issue(1, "Иван", "Катя", "Новое решение", true, "ррр", 20, new HashSet<String>(Arrays.asList("bug")));
    Issue i2 = new Issue(2, "Евгений", "Павел", "Старое решение", false, "ррр", 19, new HashSet<String>(Arrays.asList("enhancement")));
    Issue i3 = new Issue(3, "Олег", "Игорь", "Новое решение", true, "ррр", 18, new HashSet<String>(Arrays.asList("helpWanted", "bug")));
    Issue i4 = new Issue(4, "Кирилл", "Виктор", "Новое решение", false, "ррр", 17, new HashSet<String>(Arrays.asList("question")));
    Issue i5 = new Issue(5, "Толик", "Ирина", "Новое решение", false, "ррр", 16, new HashSet<String>(Arrays.asList("documentation", "bug")));
    Issue i6 = new Issue(6, "Светлана", "Петр", "Новое решение", false, "ррр", 15, new HashSet<String>(Arrays.asList("documentation")));
    Issue i7 = new Issue(7, "Светлана", "Петр", "Новое решение", false, "ррр", 14, new HashSet<String>(Arrays.asList("documentation")));
    Issue i8 = new Issue(8, "Тамара", "Петр", "Новое решение", false, "ррр", 13, new HashSet<String>(Arrays.asList("documentation", "bug")));
    Issue i9 = new Issue(8, "Тамара", "Петр", "Новое решение", false, "ррр", 12, new HashSet<String>(Arrays.asList("documentation", "bug")));

    // ПРИМЕЧАНИЕ: i5 по дефолту НЕ добавляем
    @BeforeEach
    public void setUp() {
        manager.add(i1);
        manager.add(i2);
        manager.add(i3);
        manager.add(i4);
        manager.add(i6);
        manager.add(i7);
        manager.add(i8);
    }

    // 1. Проверка отображения списка открытых Issue (при этом есть много открытых Issue)
    @Test
    void shouldSearchOpenIssuesIfManyOpenIssuesExist() {
        Issue[] expected = new Issue[]{i3, i1};
        Issue[] actual = manager.searchOpenIssues(new IssueByDaysComparator());
        assertArrayEquals(expected, actual);
    }

    // 2. Проверка отображения списка открытых Issue (при этом есть только ОДНО открытое Issue)
    @Test
    void shouldSearchOpenIssuesIfOneIssueExists() {
        manager.removeById(1);
        Issue[] expected = new Issue[]{i3};
        Issue[] actual = manager.searchOpenIssues(new IssueByDaysComparator());
        assertArrayEquals(expected, actual);
    }

    // 3. Проверка отображения списка открытых Issue (при этом нет открытых Issue)
    @Test
    void shouldSearchOpenIssuesIfOpenIssuesDoNotExist() {
        manager.removeById(1);
        manager.removeById(3);
        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchOpenIssues(new IssueByDaysComparator());
        assertArrayEquals(expected, actual);
    }

    // 4. Проверка отображения списка закрытых Issue (при этом имеется много закрытых Issue)
    @Test
    void shouldsearchClosedIssuesIfManyClosedIssuesExist() {
        Issue[] expected = new Issue[]{i8, i7, i6, i4, i2};
        Issue[] actual = manager.searchClosedIssues(new IssueByDaysComparator());
        assertArrayEquals(expected, actual);
    }

    // 5. Проверка отображения списка закрытых Issue (при этом имеется ОДНО закрытое Issue)
    @Test
    void shouldsearchClosedIssuesIfOneClosedIssueExists() {
        manager.removeById(2);
        manager.removeById(5);
        manager.removeById(6);
        manager.removeById(7);
        manager.removeById(8);
        Issue[] expected = new Issue[]{i4};
        Issue[] actual = manager.searchClosedIssues(new IssueByDaysComparator());
        assertArrayEquals(expected, actual);
    }

    // 5. Проверка отображения списка закрытых Issue (при этом НЕТ закрытых Issue)
    @Test
    void shouldsearchClosedIssuesIfIssuesDoNotExist() {
        manager.removeById(2);
        manager.removeById(4);
        manager.removeById(5);
        manager.removeById(6);
        manager.removeById(7);
        manager.removeById(8);
        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchClosedIssues(new IssueByDaysComparator());
        assertArrayEquals(expected, actual);
    }

    // 6. Проверка закрытия Issue по id (Issue c индексом существует)
    @Test
    void shouldCloseByIdIfIssueWithIndexExists() {
        manager.closeIssueById(3);
        boolean actual = i3.isOpenStatus();
        assertFalse(actual);
    }

    // 7. Проверка закрытия Issue по id (Issue c индексом НЕ существует)
    @Test
    void shouldCloseByIdIfIssueWithIndexDoesNotExist() {
        assertThrows(RuntimeException.class, () -> {
            manager.closeIssueById(27);
        });
    }

    // 8. Проверка открытия Issue по id (Issue c индексом существует)
    @Test
    void shouldOpenByIdIfIssueWithIdExist() {
        manager.openIssueById(2);
        boolean actual = i2.isOpenStatus();
        assertTrue(actual);
    }

    // 9. Проверка открытия Issue по id (Issue c индексом НЕ существует)
    @Test
    void shouldOpenByIdIfIssueWithIndexDoesNotExist() {
        assertThrows(RuntimeException.class, () -> {
            manager.openIssueById(27);
        });
    }

    // 10. Проверка фильтрации по имени автора (имеется ОДИН Issue c искоемым именем автора)
    @Test
    void shouldFindByAuthorIfOneIssueWithAuthorExists() {
        Issue[] expected = new Issue[]{i3};
        Issue[] actual = manager.searchByAuthor("Олег", new IssueByDaysComparator());
        assertArrayEquals(expected, actual);
    }

    // 11. Проверка фильтрации по имени автора (имеется много Issues c искоемым именем автора)
    @Test
    void shouldFindByAuthorIfManyIssuesWithAuthorExist() {
        Issue[] expected = new Issue[]{i7, i6};
        Issue[] actual = manager.searchByAuthor("Светлана", new IssueByDaysComparator());
        assertArrayEquals(expected, actual);
    }

    // 12. Проверка фильтрации по имени автора (НЕТ Issues c искоемым именем автора)
    @Test
    void shouldFindByAuthorIfIssueWithAuthorDoesNotExist() {
        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByAuthor("Жасмин", new IssueByDaysComparator());
        assertArrayEquals(expected, actual);
    }

    // 13. Проверка фильтрации по assignee (имеется ОДИН Issue c искоемым именем assignee)
    @Test
    void shouldFindByAssigneeIfOneIssueExists() {
        Issue[] expected = new Issue[]{i4};
        Issue[] actual = manager.searchByAssignee("Виктор", new IssueByDaysComparator());
        assertArrayEquals(expected, actual);
    }

    // 14. Проверка фильтрации по assignee (имеется МНОГО Issues c искоемым именем assignee)
    @Test
    void shouldFindByAssigneeIfManyIssuesExist() {
        Issue[] expected = new Issue[]{i8, i7, i6};
        Issue[] actual = manager.searchByAssignee("Петр", new IssueByDaysComparator());
        assertArrayEquals(expected, actual);
    }

    // 15. Проверка фильтрации по assignee (НЕТ Issues c искоемым именем assignee)
    @Test
    void shouldFindByAssigneeIfIssueDoesNotExist() {
        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByAssignee("Александр", new IssueByDaysComparator());
        assertArrayEquals(expected, actual);
    }


    // 16. Проверка фильтрации по Тегам (много Issue с искоемым тегом)
    @Test
    void shouldSearchByTagsIfManyIssuesWithTagExist() {
        Issue[] expected = new Issue[]{i1, i3, i8};
        Issue[] actual = manager.searchByTags(new HashSet<String>(Arrays.asList("bug")));
        assertArrayEquals(expected, actual);
    }

    // 17. Проверка фильтрации по Тегам (ОДИН Issue с искоемым тегом)
    @Test
    void shouldSearchByTagsIfOneIssueWithTagExists() {
        Issue[] expected = new Issue[]{i4};
        Issue[] actual = manager.searchByTags(new HashSet<String>(Arrays.asList("question")));
        assertArrayEquals(expected, actual);
    }

    // 18. Проверка фильтрации по Тегам (НЕТ Issue с искоемым тегом)
    @Test
    void shouldSearchByTagsIfIssueWithTagDoesNotExist() {
        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByTags(new HashSet<String>(Arrays.asList("problem")));
        assertArrayEquals(expected, actual);
    }

    //ПРОВЕРКА МЕТОДОВ,КОТОРЫЕ ОПИРАЮТСЯ НА МЕТОДЫ РЕПОЗИТОРИЯ
    // 1. Проверка добавления Issue
    @Test
    void shouldAdd() {
        manager.add(i9);
        Issue[] expected = new Issue[]{i1, i2, i3, i4, i6, i7, i8, i9};
        Issue[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    // 2. Проверка редактирования (замена Issue c указанным индексом, на другой Issue) - индекс в пределах суммарного количества элементов коллекции
    @Test
    void shouldSetIfIndexWithinSize() throws Exception {
        manager.set(3, i9);
        Issue[] expected = new Issue[]{i1, i2, i3, i9, i6, i7, i8};
        Issue[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    // 3. Проверка редактирования (замена Issue c указанным индексом, на другой Issue) - индекс за пределами суммарного количества элементов коллекции
    @Test
    void shouldSetIfIndexOverSize() {
        assertThrows(RuntimeException.class, () -> {
            manager.set(27, i9);
        });
    }

    // 4. Проверка удаления элемента, если такой имеется
    @Test
    void shouldRemoveIfIssueExist() {
        manager.remove(i6);
        Issue[] expected = new Issue[]{i1, i2, i3, i4, i7, i8};
        Issue[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    // 5. Проверка удаления элемента, если такой НЕ имеется
    @Test
    void shouldRemoveIfIssueDoesntExist() {
        manager.remove(i9);
        Issue[] expected = new Issue[]{i1, i2, i3, i4, i6, i7, i8};
        Issue[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    // 6. Проеверка удаления объекта по ID, если такого объекта нет
    @Test
    void shouldRemoveByIdIfIssueWithIdDoesntExist() {
        manager.removeById(27);
        Issue[] expected = new Issue[]{i1, i2, i3, i4, i6, i7, i8};
        Issue[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    // 7. Проверка удаления объекта по ID,если есть 1 объект с искоемым ID
    @Test
    void shouldRemoveByIdIfOneIssueWithIdExist() {
        manager.removeById(3);
        Issue[] expected = new Issue[]{i1, i2, i4, i6, i7, i8};
        Issue[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    // 8. Проверка удаления объекта по ID, если есть 2 объекта с искоемым ID
    @Test
    void shouldRemoveByIdIfTwoIssuesWithIdExist() {
        manager.add(i9);
        manager.removeById(8);
        Issue[] expected = new Issue[]{i1, i2, i3, i4, i6, i7};
        Issue[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    // 9. Проверка очистки коллекции
    @Test
    void shouldClear() {
        manager.clear();
        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    // 10. Проверка длины коллекции
    @Test
    void shouldSize() {
        int expected = 7;
        int actual = manager.size();
        assertEquals(expected, actual);
    }

    // 11. Проверка поиска по ID
    @Test
    void shouldFindById() {
        Issue[] expected = new Issue[]{i3};
        Issue[] actual = manager.findById(3);
        assertArrayEquals(expected, actual);
    }

}