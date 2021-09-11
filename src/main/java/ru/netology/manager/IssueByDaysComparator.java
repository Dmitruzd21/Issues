package ru.netology.manager;

import ru.netology.data.Issue;

import java.util.Comparator;

public class IssueByDaysComparator implements Comparator<Issue> {

    @Override
    public int compare(Issue o1, Issue o2) {
        return o1.getHowManyDaysAgoWasItCreated() - o2.getHowManyDaysAgoWasItCreated();
    }
}
