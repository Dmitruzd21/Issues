package ru.netology.repository;

import ru.netology.data.Issue;

import java.util.ArrayList;
import java.util.List;

public class IssueRepository {
    private List<Issue> issues = new ArrayList<>();


    // 1.Создание (добавление)  - Сrud
    public boolean add(Issue item) {
        return issues.add(item);
    }

    // 2.Просмотр - cRud
    // 2.1. Возвращает элемент, соответсвующий указанному индексу
    public Issue[] get(int index) {
        return issues.get(index).toArray(new Issue[0]);
    }

    //2.2. Возвращает все элементы
    public Issue[] getAll() {
        return issues.toArray(new Issue[0]);
    }

    // 3.Редактирование - crUd
    public void set(int index, Issue item) throws Exception {
        if (index > issues.size()) {
            throw new RuntimeException("Указанный вами индекс" + index + "больше суммарного количества элементов коллекции");
        }
        issues.set(index, item);
    }

    // 4.Удаление - cruD
    // 4.1 Очищает коллекцию
    public void clear() {
        issues.clear();
    }

    // 4.2 Удаление элемента, если такой имеется
    public boolean remove(Issue item) {
        return issues.remove(item);
    }

    // 4.3 Удаление элемента по ID
    public void removeById(int id) {
        issues.removeIf(issue -> issue.getId() == id);
    }

    // 5. Количество элементов коллекции
    public int size () {
        return issues.size();
    }

    // 6. Поиск элементов по ID - возвращает объект по идентификатору (либо null, если такого объекта нет)
    public Issue[] findById(int id) {
        Issue[] result = new Issue[1];
        int i = 0;
        for (Issue issue : getAll()) {
            if (issue.getId() == id) {
                result[i] = issue;
                i++;
            }
        }
        return result;
    }
}
