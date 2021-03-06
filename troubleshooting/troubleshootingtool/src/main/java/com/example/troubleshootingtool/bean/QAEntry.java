package com.example.troubleshootingtool.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Question",
        "Answers",
        "tags",
        "isAnswered",
        "isApproved",
        "answerCount",
        "score"
})
public class QAEntry {

    @JsonProperty("Question")
    private Question question;
    @JsonProperty("Answers")
    private List<Answer> answers = null;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("isAnswered")
    private Boolean isAnswered;
    @JsonProperty("isApproved")
    private Boolean isApproved;
    @JsonProperty("answerCount")
    private Integer answerCount;
    @JsonProperty("score")
    private Integer score;

    /**
     * No args constructor for use in serialization
     */
    public QAEntry() {
    }

    public QAEntry(Question question, List<Answer> answers, List<String> tags, Boolean isAnswered,Boolean isApproved, Integer answerCount, Integer score) {
        super();
        this.question = question;
        this.answers = answers;
        this.tags = tags;
        this.isAnswered = isAnswered;
        this.isApproved = isApproved;
        this.answerCount = answerCount;
        this.score = score;
    }

    @JsonProperty("Question")
    public Question getQuestion() {
        return question;
    }

    @JsonProperty("Question")
    public void setQuestion(Question question) {
        this.question = question;
    }

    @JsonProperty("Answers")
    public List<Answer> getAnswers() {
        return answers;
    }

    @JsonProperty("Answers")
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("isAnswered")
    public Boolean getIsAnswered() {
        return isAnswered;
    }

    @JsonProperty("isAnswered")
    public void setIsAnswered(Boolean isAnswered) {
        this.isAnswered = isAnswered;
    }

    @JsonProperty("isApproved")
    public Boolean getIsApproved() {
        return isApproved;
    }

    @JsonProperty("isApproved")
    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    @JsonProperty("answerCount")
    public Integer getAnswerCount() {
        return answerCount;
    }

    @JsonProperty("answerCount")
    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
    }

}