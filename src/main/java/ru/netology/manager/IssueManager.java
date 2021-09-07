package ru.netology.manager;

import ru.netology.data.Issue;
import ru.netology.repository.IssueRepository;

import java.util.List;
import java.util.Set;

public class IssueManager {
    private IssueRepository repository;

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public IssueManager() {
    }

    // МЕТОДЫ СОБСТВЕННО МЕНЕДЖЕРА

    // 1. Отображение списка открытых Issue
    public Issue[] searchOpenIssues() {
        Issue[] result = new Issue[0];
        for (Issue issue : repository.getAll()) {
            if (matches(issue)) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                //(из какого массива, с какого места из источника, куда копировать,с какого места всавлять вцелевой, количество элементов которые хотим скопировать)
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Issue issue) {
        if (issue.isOpenStatus() == true) {
            return true;
        }
        return false;
    }

    // 2. Отображение списка закрытых Issue
    public Issue[] searchClosedIssues() {
        Issue[] result = new Issue[0];
        for (Issue issue : repository.getAll()) {
            if (matches2(issue)) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                //(из какого массива, с какого места из источника, куда копировать,с какого места всавлять вцелевой, количество элементов которые хотим скопировать)
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches2(Issue issue) {
        if (issue.isOpenStatus() == false) {
            return true;
        }
        return false;
    }

    // Фильтрация по имени автора
    public Issue[] searchByAuthor(String author) {
        Issue[] result = new Issue[0];
        for (Issue issue : repository.getAll()) {
            if (matches3(issue, author)) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                //(из какого массива, с какого места из источника, куда копировать,с какого места всавлять вцелевой, количество элементов которые хотим скопировать)
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches3(Issue issue, String author) {
        if (issue.getAuthor().contains(author)) {
            return true;
        }
        return false;
    }

    // Фильтрация по Tag
    public List<Issue> searchByTags(Set<String> searchTags) {
        List<Issue> filteredIssues = new List<Issue>();

        for (Issue issue : repository.getAll()) {
            Set<String> issueTags = issue.getTags();

            for (String searchTag : searchTags) {
                if (issueTags.contains(searchTags)) {
                    filteredIssues.add(issue);
                    continue;
                }
            }
            return filteredIssues;
        }
    }

        // Фильтрация по Assignee (на кого назначено)
    public Issue[] searchByAssignee(String assignee) {
        Issue[] result = new Issue[0];
        for (Issue issue : repository.getAll()) {
            if (matches4(issue, assignee)) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                //(из какого массива, с какого места из источника, куда копировать,с какого места всавлять вцелевой, количество элементов которые хотим скопировать)
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches4(Issue issue,String assignee) {
        if (issue.getAssignee().contains(assignee)) {
            return true;
        }
        return false;
    }

    //Закрытие Issue по id
    public void closeIssueById(int id) {
        int i = 0;
        for (Issue issue : repository.getAll()) {
            if (issue.getId() == id) {
                issue.setOpenStatus(false);
                i++;
            }
        }

    }

    // Открытие Issue по id
    public void openIssueById(int id) {
        int i = 0;
        for (Issue issue : repository.getAll()) {
            if (issue.getId() == id) {
                issue.setOpenStatus(true);
                i++;
            }

        }
    }

    // МЕТОДЫ РЕПОЗИТОРИЯ

    // 1.Создание (добавление)  - Сrud
    public void add(Issue issue) {
        repository.add(issue);
    }

    // 2.Просмотр - cRud
    // 2.1. Возвращает элемент, соответсвующий указанному индексу
    public Issue[] get(int index) {
        return repository.get(index);
    }

    //2.2. Возвращает все элементы
    public Issue[] getAll() {
        return repository.getAll();
    }

    // 3.Редактирование - crUd
    public void set(int index, Issue item) throws Exception {
        repository.set(index, item);
    }

    // 4.Удаление - cruD
    // 4.1 Очищает коллекцию
    public void clear() {
        repository.clear();
    }

    // 4.2 Удаление элемента, если такой имеется
    public void remove(Issue item) {
        repository.remove(item);
    }

    // 4.3 Удаление элемента по ID
    public void removeById(int ID) {
        repository.removeById(ID);
    }

    // 5. Количество элементов коллекции
    public int size() {
        return repository.size();
    }

    // 6. Поиск Issue по ID
    public Issue[] findById(int ID) {
        return repository.findById(ID);
    }

}
