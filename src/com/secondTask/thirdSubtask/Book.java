package com.secondTask.thirdSubtask;

import com.secondTask.InitializationException;

public class Book {

    private String authorName, title, coverColour;
    private Integer totalPages, currPage = 1;

    private final Integer MINS_IN_HOUR = 60;
    private final Integer WORDS_IN_PAGE = 521;

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCoverColour(String coverColour) {
        this.coverColour = coverColour;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public int read(Integer readingHours, Integer wordsPerMinute) throws InitializationException {

        if (this.totalPages == null) throw new InitializationException("The book hasn't been chosen yet.");

        int readPages = readingHours * wordsPerMinute * MINS_IN_HOUR / WORDS_IN_PAGE;
        this.currPage += readPages;
        return readPages;
    }

    public void Clear() {
        this.authorName = null;
        this.title = null;
        this.coverColour = null;

        this.totalPages = null;
        this.currPage = 1;
    }

    @Override
    public String toString() {
        return "Book {" +
                " authorName = '" + authorName + '\'' +
                ", title = '" + title + '\'' +
                ", coverColour = '" + coverColour + '\'' +
                ", totalPages = " + totalPages +
                ", currPage = " + currPage +
                '}';
    }
}
