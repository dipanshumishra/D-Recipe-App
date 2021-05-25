package com.example.login.Model;

public class IngDetailModel {

    String Process,cookTime,ingDescription,prepTime,stepsRequired,totalIngrequired;


    public IngDetailModel(String process, String cookTime, String ingDescription, String prepTime, String stepsRequired, String totalIngrequired) {
        Process = process;
        this.cookTime = cookTime;
        this.ingDescription = ingDescription;
        this.prepTime = prepTime;
        this.stepsRequired = stepsRequired;
        this.totalIngrequired = totalIngrequired;
    }

    public String getProcess() {
        return Process;
    }

    public void setProcess(String process) {
        Process = process;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public String getIngDescription() {
        return ingDescription;
    }

    public void setIngDescription(String ingDescription) {
        this.ingDescription = ingDescription;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getStepsRequired() {
        return stepsRequired;
    }

    public void setStepsRequired(String stepsRequired) {
        this.stepsRequired = stepsRequired;
    }

    public String getTotalIngrequired() {
        return totalIngrequired;
    }

    public void setTotalIngrequired(String totalIngrequired) {
        this.totalIngrequired = totalIngrequired;
    }
}
