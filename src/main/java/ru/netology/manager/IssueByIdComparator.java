package ru.netology.manager;

import ru.netology.data.Issue;

import java.util.Comparator;

public class IssueByIdComparator implements Comparator<Issue> {
    @Override
    public int compare(Issue o1, Issue o2) {
        return o1.getId() - o2.getId();
    }
}
