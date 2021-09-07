package ru.netology.data;

import java.util.*;
import java.util.function.UnaryOperator;


public class Issue implements List<Issue> {
    private int id;
    private String author;
    private String assignee;
    private String topic;
    private boolean openStatus;
    private String text;
    private int howManyDaysAgoWasItCreated;
    private Set <String> tags = new HashSet<String> ();

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Issue(int id, String author, String assignee, String topic, boolean openStatus, String text, int howManyDaysAgoWasItCreated, Set<String> tags) {
        this.id = id;
        this.author = author;
        this.assignee = assignee;
        this.topic = topic;
        this.openStatus = openStatus;
        this.text = text;
        this.howManyDaysAgoWasItCreated = howManyDaysAgoWasItCreated;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(boolean openStatus) {
        this.openStatus = openStatus;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getHowManyDaysAgoWasItCreated() {
        return howManyDaysAgoWasItCreated;
    }

    public void setHowManyDaysAgoWasItCreated(int howManyDaysAgoWasItCreated) {
        this.howManyDaysAgoWasItCreated = howManyDaysAgoWasItCreated;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Issue> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Issue issue) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Issue> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Issue> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<Issue> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super Issue> c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {

    }

    @Override
    public Issue get(int index) {
        return null;
    }

    @Override
    public Issue set(int index, Issue element) {
        return null;
    }

    @Override
    public void add(int index, Issue element) {

    }

    @Override
    public Issue remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Issue> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Issue> listIterator(int index) {
        return null;
    }

    @Override
    public List<Issue> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<Issue> spliterator() {
        return List.super.spliterator();
    }
}
