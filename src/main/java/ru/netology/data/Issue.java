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
    private boolean bugLabel;
    private boolean enhancementLabel;
    private boolean helpWantedLabel;
    private boolean questionLabel;
    private boolean documentationLabel;


    public Issue(int id, String author, String assignee, String topic, boolean openStatus, String text, int howManyDaysAgoWasItCreated, boolean bugLabel, boolean enhancementLabel, boolean helpWantedLabel, boolean questionLabel, boolean documentationLabel) {
        this.id = id;
        this.author = author;
        this.assignee = assignee;
        this.topic = topic;
        this.openStatus = openStatus;
        this.text = text;
        this.howManyDaysAgoWasItCreated = howManyDaysAgoWasItCreated;
        this.bugLabel = bugLabel;
        this.enhancementLabel = enhancementLabel;
        this.helpWantedLabel = helpWantedLabel;
        this.questionLabel = questionLabel;
        this.documentationLabel = documentationLabel;
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

    public boolean isBugLabel() {
        return bugLabel;
    }

    public void setBugLabel(boolean bugLabel) {
        this.bugLabel = bugLabel;
    }

    public boolean isEnhancementLabel() {
        return enhancementLabel;
    }

    public void setEnhancementLabel(boolean enhancementLabel) {
        this.enhancementLabel = enhancementLabel;
    }

    public boolean isHelpWantedLabel() {
        return helpWantedLabel;
    }

    public void setHelpWantedLabel(boolean helpWantedLabel) {
        this.helpWantedLabel = helpWantedLabel;
    }

    public boolean isQuestionLabel() {
        return questionLabel;
    }

    public void setQuestionLabel(boolean questionLabel) {
        this.questionLabel = questionLabel;
    }

    public boolean isDocumentationLabel() {
        return documentationLabel;
    }

    public void setDocumentationLabel(boolean documentationLabel) {
        this.documentationLabel = documentationLabel;
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
